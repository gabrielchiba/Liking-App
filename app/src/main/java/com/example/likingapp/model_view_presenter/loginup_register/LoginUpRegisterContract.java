package com.example.likingapp.model_view_presenter.loginup_register;

import android.content.Intent;

import androidx.activity.result.ActivityResultLauncher;

import com.example.likingapp.models.OwnUser;

public interface LoginUpRegisterContract {

    interface View {
        ActivityResultLauncher<Intent> createEmailActivityLauncher(OwnUser user);
        void registerEmail(android.view.View v, OwnUser user, ActivityResultLauncher<Intent> emailActivityResultLauncher);
        void registerAccess(android.view.View v, OwnUser user);
        void apiAccess(android.view.View v, OwnUser user);
    }

    interface Presenter {
        boolean haveBlankFields(OwnUser user);
        OwnUser createNewEmptyOwnUser();
        void registerOwnUserOnDB(OwnUser ownUser);
        boolean checkUserLoginExist(OwnUser user);
        boolean isUserWrong(OwnUser user, OwnUser registeredUser);
        OwnUser getUserByLogin(String login);
    }
}
