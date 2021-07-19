package com.example.likingapp.model_view_presenter.simple_api_call;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;

import com.example.likingapp.R;
import com.example.likingapp.databinding.ActivitySimpleApicallBinding;

public class simpleAPICallActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DataBindingUtil.setContentView(this, R.layout.activity_simple_apicall);
        ActivitySimpleApicallBinding activitySimpleApicallBinding = DataBindingUtil.setContentView(this,
                R.layout.activity_simple_apicall);
        String firstName = getIntent().getStringExtra("com.example.likingapp.firstName");
        if (firstName != null)  activitySimpleApicallBinding.setFirstName(firstName);
        String login = getIntent().getStringExtra("com.example.likingapp.login");
        if (login != null) activitySimpleApicallBinding.setLogin(login);
        String email = getIntent().getStringExtra("com.example.likingapp.email");
        if (email != null) activitySimpleApicallBinding.setEmail(email);
    }
}