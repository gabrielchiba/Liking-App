package com.example.likingapp.view_presenter.personal_list;

import androidx.fragment.app.Fragment;

import com.example.likingapp.models.Hero;
import com.example.likingapp.models.OwnUser;

import java.util.List;

public interface PersonalListContract {
    interface View {
        void setExtras(OwnUser user);
        void setFragment(Fragment fragment);
        void setupRecyclerView();
        void setupSearchView();
    }
    interface Presenter {
        List<Hero> getAllHeroesOfUserFromDB(long userId);
        void removeHeroByIDFromDB(long id);
    }
}
