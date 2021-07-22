package com.example.likingapp.model_view_presenter.loginup_register;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.likingapp.model_view_presenter.people_list.PeopleListActivity;
import com.example.likingapp.R;
import com.example.likingapp.model_view_presenter.register_email.RegisterEmailActivity;
import com.example.likingapp.databinding.ActivityLoginupRegisterBinding;
import com.example.likingapp.model_view_presenter.simple_api_call.SimpleAPICallActivity;
import com.example.likingapp.models.OwnUser;
import com.facebook.stetho.Stetho;

import se.emilsjolander.sprinkles.Query;

public class LoginUpRegisterActivity extends AppCompatActivity implements LoginUpRegisterContract.View {

    private ActivityLoginupRegisterBinding binding;
    private LoginUpRegisterContract.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Stetho.initializeWithDefaults(this);
        presenter = new LoginUpRegisterPresenter(this, this);

        binding = DataBindingUtil.setContentView(this,
                R.layout.activity_loginup_register);
        OwnUser user = presenter.createNewEmptyOwnUser();

        binding.setUser(user);

//        Log.d("SQL", String.valueOf(Query.one(OwnUser.class, " SELECT * FROM own_user WHERE name = '"+name+"'", true).get()));

        ActivityResultLauncher<Intent> emailActivityResultLauncher = createEmailActivityLauncher(user);

        binding.buttonRegister.setOnClickListener(v -> registerEmail(v, user, emailActivityResultLauncher));
        binding.buttonApi.setOnClickListener(v -> apiAccess(v, user));
        binding.buttonAccess.setOnClickListener(v -> registerAccess(v, user));

    }

    @Override
    public ActivityResultLauncher<Intent> createEmailActivityLauncher(OwnUser user) {
        return registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                result -> {
                    if (result.getResultCode() == Activity.RESULT_OK) {
                        Intent data = result.getData();
                        assert data != null;
                        user.email = data.getStringExtra("registeredMail");
//                        Log.d("USER", user.id + user.name + user.lastName + user.login + user.password + user.saveCredentials);
                        presenter.registerOwnUserOnDB(user);
                    }
                });
    }

    @Override
    public void registerEmail(View v, OwnUser user, ActivityResultLauncher<Intent> emailActivityResultLauncher) {
        if (presenter.haveBlankFields(user)) {
            Toast.makeText(this, this.getString(R.string.complete_fields), Toast.LENGTH_SHORT).show();
        } else {
            Intent i = new Intent(LoginUpRegisterActivity.this, RegisterEmailActivity.class);

            emailActivityResultLauncher.launch(i);
        }
    }

    @Override
    public void registerAccess(View v, OwnUser user) {
        if (presenter.haveBlankFields(user)) {
            Toast.makeText(this, this.getString(R.string.complete_fields), Toast.LENGTH_SHORT).show();
        }
        else if (presenter.checkUserLoginExist(user)) {
            if (presenter.isUserWrong(user, presenter.getUserByLogin(user.login))) {
                Toast.makeText(this, this.getString(R.string.user_exists), Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, R.string.success_login, Toast.LENGTH_SHORT).show();
                Intent i = new Intent(LoginUpRegisterActivity.this, PeopleListActivity.class);
                i.putExtra("registeredUserID", presenter.getUserByLogin(user.login).id);
                startActivity(i);
            }

        }
        else {
            Intent i = new Intent(LoginUpRegisterActivity.this, PeopleListActivity.class);
            startActivity(i);
        }

    }

    @Override
    public void apiAccess(View v, OwnUser user) {
        if (presenter.haveBlankFields(user)) {
            Toast.makeText(this, this.getString(R.string.complete_fields), Toast.LENGTH_SHORT).show();
        }
        else {
            Intent i = new Intent(LoginUpRegisterActivity.this, SimpleAPICallActivity.class);
            i.putExtra("firstName", user.name);
            i.putExtra("login", user.login);
            i.putExtra("email", user.email);
            startActivity(i);
        }
    }
}