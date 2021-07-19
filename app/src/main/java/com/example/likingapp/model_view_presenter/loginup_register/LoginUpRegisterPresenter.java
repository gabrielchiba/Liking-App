package com.example.likingapp.model_view_presenter.loginup_register;

import android.content.Context;
import android.content.Intent;

import androidx.activity.result.ActivityResultLauncher;

import com.example.likingapp.User;

public class LoginUpRegisterPresenter implements LoginUpRegisterContract.Presenter {
    private LoginUpRegisterContract.View view;
    private Context context;

    public LoginUpRegisterPresenter(LoginUpRegisterContract.View view, Context context) {
        this.view = view;
        this.context = context;
    }

    @Override
    public boolean haveBlankFields(User user) {
        return user.getName().equals("") || user.getSurname().equals("") ||
                user.getLogin().equals("") || user.getPass().equals("");
    }
}
