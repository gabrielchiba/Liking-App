package com.example.likingapp.view_presenter.register_email;

import android.content.Context;

import com.example.likingapp.models.OwnUser;

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
    public boolean emailExists(String email) {
        OwnUser user = Query.one(OwnUser.class, " SELECT * FROM own_user WHERE email = '"+email+"'", true).get();
        // Check if user exists before access email attribute
        if (user != null) {
            return user.email.equals(email);
        }
        else return false;
    }
}
