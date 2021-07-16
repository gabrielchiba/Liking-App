package com.example.likingapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.likingapp.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
        ActivityMainBinding activityMainBinding = DataBindingUtil.setContentView(this,
                R.layout.activity_main);
        User user = new User("", "", "", "", "");
        activityMainBinding.setUser(user);
        activityMainBinding.buttonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registerAcess(v, user);
            }
        });
        activityMainBinding.buttonApi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                apiAcess(v, user);
            }
        });
    }

    public boolean haveBlankFields(User user) {
        return user.getName().equals("") || user.getSurname().equals("") ||
                user.getLogin().equals("") || user.getPass().equals("");
    }

    public void registerEmail(View v) {
        Intent i = new Intent(MainActivity.this, RegisterEmailActivity.class);
        startActivity(i);
    }

    public void registerAcess(View v, User user) {
        if (haveBlankFields(user)) {
            Toast.makeText(this, "Complete todos os campos", Toast.LENGTH_SHORT).show();
        }
        else {
            Intent i = new Intent(MainActivity.this, PeopleActivity.class);
            startActivity(i);
        }

    }
    public void apiAcess(View v, User user) {
        if (haveBlankFields(user)) {
            Toast.makeText(this, "Complete todos os campos", Toast.LENGTH_SHORT).show();
        }
        else {
            Intent i = new Intent(MainActivity.this, simpleAPICallActivity.class);
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