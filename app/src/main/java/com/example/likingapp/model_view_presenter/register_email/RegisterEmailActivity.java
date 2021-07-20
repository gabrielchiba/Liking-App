package com.example.likingapp.model_view_presenter.register_email;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.likingapp.R;
import com.example.likingapp.databinding.ActivityRegisterEmailBinding;

public class RegisterEmailActivity extends AppCompatActivity implements RegisterEmailContract.View{

    private ActivityRegisterEmailBinding binding;
    private RegisterEmailContract.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        presenter = new RegisterEmailPresenter(this, this);
        binding = DataBindingUtil.setContentView(this,
                R.layout.activity_register_email);

        binding.buttonConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                confirmEmail(v);
            }
        });

    }

    @Override
    public void confirmEmail(View v) {
        String registeredMail = binding.getEmail();
        if (presenter.isValidEmail(registeredMail)) {
            Intent returnIntent = new Intent();
            returnIntent.putExtra("registeredMail", registeredMail);
            setResult(Activity.RESULT_OK,returnIntent);
            finish();
        } else {
            Toast.makeText(this, this.getString(R.string.insert_valid_email), Toast.LENGTH_SHORT).show();
        }
    }
}