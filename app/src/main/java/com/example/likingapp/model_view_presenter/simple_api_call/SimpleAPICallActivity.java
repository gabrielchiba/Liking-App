package com.example.likingapp.model_view_presenter.simple_api_call;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;

import com.example.likingapp.R;
import com.example.likingapp.databinding.ActivitySimpleApicallBinding;

public class SimpleAPICallActivity extends AppCompatActivity implements SimpleAPICallContract.View{

    private ActivitySimpleApicallBinding binding;
    private SimpleAPICallContract.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = new SimpleAPICallPresenter(this, this);
        binding = DataBindingUtil.setContentView(this,
                R.layout.activity_simple_apicall);
        String firstName = getIntent().getStringExtra("firstName");
        if (firstName != null)  binding.setFirstName(firstName);
        String login = getIntent().getStringExtra("login");
        if (login != null) binding.setLogin(login);
        String email = getIntent().getStringExtra("email");
        if (email != null) binding.setEmail(email);
    }
}