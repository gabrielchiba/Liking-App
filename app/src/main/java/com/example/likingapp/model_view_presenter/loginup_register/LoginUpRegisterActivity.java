package com.example.likingapp.model_view_presenter.loginup_register;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.likingapp.model_view_presenter.people.PeopleActivity;
import com.example.likingapp.R;
import com.example.likingapp.model_view_presenter.register_email.RegisterEmailActivity;
import com.example.likingapp.User;
import com.example.likingapp.databinding.ActivityLoginupRegisterBinding;
import com.example.likingapp.model_view_presenter.simple_api_call.SimpleAPICallActivity;

public class LoginUpRegisterActivity extends AppCompatActivity implements LoginUpRegisterContract.View {

    private ActivityLoginupRegisterBinding binding;
    private LoginUpRegisterContract.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = new LoginUpRegisterPresenter(this, this);

        binding = DataBindingUtil.setContentView(this,
                R.layout.activity_loginup_register);
        User user = new User("", "", "", "", "");
        binding.setUser(user);

        ActivityResultLauncher<Intent> emailActivityResultLauncher = createEmailActivityLauncher(user);

        binding.buttonRegister.setOnClickListener(v -> registerEmail(v, user, emailActivityResultLauncher));
        binding.buttonApi.setOnClickListener(v -> apiAccess(v, user));
        binding.buttonAccess.setOnClickListener(v -> registerAccess(v, user));
    }

    @Override
    public ActivityResultLauncher<Intent> createEmailActivityLauncher(User user) {
        return registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                result -> {
                    if (result.getResultCode() == Activity.RESULT_OK) {
                        Intent data = result.getData();
                        assert data != null;
                        String email = data.getStringExtra("com.example.likingapp.registeredMail");
                        user.setEmail(email);
                        binding.setUser(user);
                    }
                });
    }

    @Override
    public void registerEmail(View v, User user, ActivityResultLauncher<Intent> emailActivityResultLauncher) {
        if (presenter.haveBlankFields(user)) {
            Toast.makeText(this, "Complete todos os campos", Toast.LENGTH_SHORT).show();
        } else {
            Intent i = new Intent(LoginUpRegisterActivity.this, RegisterEmailActivity.class);


            emailActivityResultLauncher.launch(i);
        }
    }

    @Override
    public void registerAccess(View v, User user) {
        if (presenter.haveBlankFields(user)) {
            Toast.makeText(this, "Complete todos os campos", Toast.LENGTH_SHORT).show();
        }
        else {
            Intent i = new Intent(LoginUpRegisterActivity.this, PeopleActivity.class);
            startActivity(i);
        }

    }

    @Override
    public void apiAccess(View v, User user) {
        if (presenter.haveBlankFields(user)) {
            Toast.makeText(this, "Complete todos os campos", Toast.LENGTH_SHORT).show();
        }
        else {
            Intent i = new Intent(LoginUpRegisterActivity.this, SimpleAPICallActivity.class);
            i.putExtra("com.example.likingapp.firstName", user.getName());
            i.putExtra("com.example.likingapp.login", user.getLogin());
            i.putExtra("com.example.likingapp.email", user.getEmail());
            startActivity(i);
        }
    }
}