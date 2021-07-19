package com.example.likingapp.model_view_presenter.loginup_register;

import android.content.Context;

import com.example.likingapp.User;

public class LoginUpRegisterPresenter implements LoginUpRegisterContract.Presenter {
    private LoginUpRegisterContract.View view;
    private Context context;

    public LoginUpRegisterPresenter(LoginUpRegisterContract.View view, Context context) {
        this.view = view;
        this.context = context;
    }

    @Override
    public void init(User user) {
//        this.view.haveBlankFields(user);
    }
}
