package com.example.likingapp.view_presenter.register_email;

import com.example.likingapp.models.OwnUserDao;

public interface RegisterEmailContract {
    interface View {

        void confirmEmail(android.view.View v);
    }

    interface Presenter {
        boolean isValidEmail(CharSequence target);
        boolean emailExists(OwnUserDao daoSession, String email);
    }
}
