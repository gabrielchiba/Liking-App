package com.example.likingapp.view_presenter.register_email;

public interface RegisterEmailContract {
    interface View {

        void confirmEmail(android.view.View v);
    }

    interface Presenter {
        boolean isValidEmail(CharSequence target);
        boolean emailExists(String email);
    }
}
