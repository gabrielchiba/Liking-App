package com.example.likingapp.view_presenter.splash_screen;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;

import com.example.likingapp.R;
import com.example.likingapp.view_presenter.loginup_register.LoginUpRegisterActivity;

public class SplashScreenActivity extends AppCompatActivity {
    private static final int DISPLAY_DURATION = 1500;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DataBindingUtil.setContentView(this, R.layout.activity_splash_screen);
        new Handler(Looper.myLooper()).postDelayed(() -> {
            Intent i = new Intent(SplashScreenActivity.this, LoginUpRegisterActivity.class);
            startActivity(i);
            finish();
        }, DISPLAY_DURATION);
    }
}