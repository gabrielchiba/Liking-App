package com.example.likingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;

public class SplashScreenActivity extends AppCompatActivity {
    private static final int DISPLAY_DURATION = 1500;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        new Handler(Looper.myLooper()).postDelayed(() -> {
            Intent i = new Intent(SplashScreenActivity.this, MainActivity.class);
            startActivity(i);
            finish();
        }, DISPLAY_DURATION);
    }
}