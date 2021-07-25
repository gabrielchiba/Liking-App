package com.example.likingapp.model_view_presenter.register_email;

import android.view.View;

public interface RegisterEmailContract {
    interface View {

        void confirmEmail(android.view.View v);
    }

    interface Presenter {
        boolean isValidEmail(CharSequence target);
        boolean emailExists(String email);
    }
}
