package com.example.likingapp.model_view_presenter.loginup_register;

import android.content.Context;

import com.example.likingapp.models.OwnUser;

import se.emilsjolander.sprinkles.Query;

public class LoginUpRegisterPresenter implements LoginUpRegisterContract.Presenter {
    private LoginUpRegisterContract.View view;
    private Context context;

    public LoginUpRegisterPresenter(LoginUpRegisterContract.View view, Context context) {
        this.view = view;
        this.context = context;
    }

    @Override
    public boolean haveBlankFields(OwnUser user) {
        return user.name==null || user.lastName==null ||
                user.login==null || user.password==null;
    }

    @Override
    public OwnUser createNewEmptyOwnUser() {
        return new OwnUser();
    }

    @Override
    public void registerOwnUserOnDB(OwnUser ownUser) {
        ownUser.save();
    }

    @Override
    public boolean checkUserLoginExist(OwnUser user) {
        return Query.one(OwnUser.class, " SELECT * FROM own_user WHERE login = '" + user.login + "'", true).get() != null;
    }

    @Override
    public boolean isUserWrong(OwnUser user, OwnUser registeredUser) {
        return !user.name.equals(registeredUser.name) || !user.lastName.equals(registeredUser.lastName) ||
                !user.password.equals(registeredUser.password);
    }

    @Override
    public OwnUser getUserByLogin(String login) {
        return Query.one(OwnUser.class, " SELECT * FROM own_user WHERE login = '" + login + "'", true).get();
    }

}
