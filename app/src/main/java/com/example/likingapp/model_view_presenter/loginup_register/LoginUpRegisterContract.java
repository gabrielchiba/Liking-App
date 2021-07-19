package com.example.likingapp.model_view_presenter.loginup_register;

import android.content.Intent;

import androidx.activity.result.ActivityResultLauncher;

import com.example.likingapp.User;

public interface LoginUpRegisterContract {

    interface View {
        ActivityResultLauncher<Intent> createEmailActivityLauncher(User user);
        void registerEmail(android.view.View v, User user, ActivityResultLauncher<Intent> emailActivityResultLauncher);
        void registerAccess(android.view.View v, User user);
        void apiAccess(android.view.View v, User user);
    }

    interface Presenter {
        boolean haveBlankFields(User user);

    }
}
