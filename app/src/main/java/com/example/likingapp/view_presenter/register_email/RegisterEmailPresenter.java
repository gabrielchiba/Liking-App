package com.example.likingapp.view_presenter.register_email;

import android.content.Context;

import com.example.likingapp.models.OwnUser;
import com.example.likingapp.models.OwnUserDao;

import java.util.List;

import se.emilsjolander.sprinkles.Query;

public class RegisterEmailPresenter implements RegisterEmailContract.Presenter{
    private RegisterEmailContract.View view;
    private Context context;

    public RegisterEmailPresenter(RegisterEmailContract.View view, Context context) {
        this.view = view;
        this.context = context;
    }

    @Override
    public boolean isValidEmail(CharSequence target) {
        if (target == null) {
            return false;
        } else {
            return android.util.Patterns.EMAIL_ADDRESS.matcher(target).matches();
        }
    }

    @Override
    public boolean emailExists(OwnUserDao daoSession, String email) {
        List<OwnUser> ownUserList = daoSession.queryBuilder().where(OwnUserDao.Properties.Email.eq(email)).list();
        // Check if user exists before access email attribute
        if (!ownUserList.isEmpty()) {
            return ownUserList.get(0).email.equals(email);
        }
        else return false;
    }
}
