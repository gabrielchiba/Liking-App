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

public class RegisterEmailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivityRegisterEmailBinding activityRegisterEmailBinding = DataBindingUtil.setContentView(this,
                R.layout.activity_register_email);

        activityRegisterEmailBinding.buttonConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                confirmEmail(v, activityRegisterEmailBinding);
            }
        });

    }

    public static boolean isValidEmail(CharSequence target) {
        if (target == null) {
            return false;
        } else {
            return android.util.Patterns.EMAIL_ADDRESS.matcher(target).matches();
        }
    }

    public void confirmEmail(View v, ActivityRegisterEmailBinding activityRegisterEmailBinding) {
        String registeredMail = activityRegisterEmailBinding.getEmail();
        if (isValidEmail(registeredMail)) {
            Intent returnIntent = new Intent();
            returnIntent.putExtra("com.example.likingapp.registeredMail", registeredMail);
            setResult(Activity.RESULT_OK,returnIntent);
            finish();
        } else {
            Toast.makeText(this, "Insira um email válido", Toast.LENGTH_SHORT).show();
        }
    }
}