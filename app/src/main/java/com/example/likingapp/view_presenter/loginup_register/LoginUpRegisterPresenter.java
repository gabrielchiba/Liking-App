package com.example.likingapp.view_presenter.loginup_register;

import android.content.Context;
import android.util.Log;

import com.example.likingapp.models.DaoSession;
import com.example.likingapp.models.OwnUser;
import com.example.likingapp.models.OwnUserDao;

import java.util.List;
import java.util.logging.Logger;

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
        return (isNullOrEmpty(user.name, user.lastName, user.login, user.password));
    }

    @Override
    public boolean isNullOrEmpty(String... values) {
        for (String v: values)
            if(v == null || v.isEmpty())
                return true;
            return false;
    }

    @Override
    public OwnUser createNewEmptyOwnUser() {
        return new OwnUser();
    }

    @Override
    public void registerOwnUserOnDB(OwnUserDao daoSession, OwnUser ownUser) {
        daoSession.insert(ownUser);
    }

    @Override
    public boolean checkUserLoginExist(OwnUserDao daoSession, OwnUser user) {
        return !daoSession.queryBuilder().where(OwnUserDao.Properties.Login.eq(user.login)).list().isEmpty();
//        return Query.one(OwnUser.class, " SELECT * FROM own_user WHERE login = '" + user.login + "'", true).get() != null;
    }

    @Override
    public boolean isUserWrong(OwnUser user, OwnUser registeredUser) {
        return !user.name.equals(registeredUser.name) || !user.lastName.equals(registeredUser.lastName) ||
                !user.password.equals(registeredUser.password);
    }

    @Override
    public OwnUser getUserByLogin(OwnUserDao daoSession, String login) {
        List<OwnUser> ownUserList = daoSession.queryBuilder().where(OwnUserDao.Properties.Login.eq(login)).list();
        OwnUser ownUser = null;

        if (!ownUserList.isEmpty())
            ownUser = ownUserList.get(0);

        Log.d("DAO", String.valueOf(ownUser));
        return ownUser;
    }

}
