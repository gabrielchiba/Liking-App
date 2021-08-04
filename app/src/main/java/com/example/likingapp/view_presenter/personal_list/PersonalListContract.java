package com.example.likingapp.view_presenter.personal_list;

import androidx.fragment.app.Fragment;

import com.example.likingapp.models.OwnUser;

public interface PersonalListContract {
    interface View {
        void setExtras(OwnUser user);
        void setFragment(Fragment fragment);
    }
    interface Presenter {

    }
}
