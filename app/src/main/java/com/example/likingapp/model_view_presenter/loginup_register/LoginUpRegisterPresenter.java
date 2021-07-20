package com.example.likingapp.model_view_presenter.loginup_register;

import android.content.Context;

import com.example.likingapp.models.OwnUser;

public class LoginUpRegisterPresenter implements LoginUpRegisterContract.Presenter {
    private LoginUpRegisterContract.View view;
    private Context context;

    public LoginUpRegisterPresenter(LoginUpRegisterContract.View view, Context context) {
        this.view = view;
        this.context = context;
    }

    @Override
    public boolean haveBlankFields(OwnUser user) {
        return user.name.equals("") || user.lastName.equals("") ||
                user.login.equals("") || user.password.equals("");
    }
}
