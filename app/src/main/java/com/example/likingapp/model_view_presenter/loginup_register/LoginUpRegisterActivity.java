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
import com.example.likingapp.model_view_presenter.simple_api_call.simpleAPICallActivity;

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

        ActivityResultLauncher<Intent> emailActivityResultLauncher = registerForActivityResult(
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

        binding.buttonRegister.setOnClickListener(v -> registerEmail(v, user, emailActivityResultLauncher));
        binding.buttonApi.setOnClickListener(v -> apiAccess(v, user));
        binding.buttonAccess.setOnClickListener(v -> registerAccess(v, user));
    }

    public boolean haveBlankFields(User user) {
        return user.getName().equals("") || user.getSurname().equals("") ||
                user.getLogin().equals("") || user.getPass().equals("");
    }

    public void registerEmail(View v, User user, ActivityResultLauncher<Intent> emailActivityResultLauncher) {
        if (haveBlankFields(user)) {
            Toast.makeText(this, "Complete todos os campos", Toast.LENGTH_SHORT).show();
        } else {
            Intent i = new Intent(LoginUpRegisterActivity.this, RegisterEmailActivity.class);


            emailActivityResultLauncher.launch(i);
        }
    }

    public void registerAccess(View v, User user) {
        if (haveBlankFields(user)) {
            Toast.makeText(this, "Complete todos os campos", Toast.LENGTH_SHORT).show();
        }
        else {
            Intent i = new Intent(LoginUpRegisterActivity.this, PeopleActivity.class);
            startActivity(i);
        }

    }
    public void apiAccess(View v, User user) {
        if (haveBlankFields(user)) {
            Toast.makeText(this, "Complete todos os campos", Toast.LENGTH_SHORT).show();
        }
        else {
            Intent i = new Intent(LoginUpRegisterActivity.this, simpleAPICallActivity.class);
            String firstName = user.getName();
            i.putExtra("com.example.likingapp.firstName", firstName);
            String login = user.getLogin();
            i.putExtra("com.example.likingapp.login", login);
            String email = user.getEmail();
            i.putExtra("com.example.likingapp.email", email);
            startActivity(i);
        }
    }
}