package com.example.likingapp.model_view_presenter.simple_api_call;

import com.example.likingapp.models.Hero;
import com.example.likingapp.models.OwnUser;
import com.example.likingapp.models.Person;

import java.util.List;

public interface SimpleAPICallContract {
    interface View {
        void setupRecyclerView(List<Hero> heroes);
        void setupSearchView();
        void setExtras(OwnUser user);
        void sendExtrasToPersonalListFragment();
    }

    interface Presenter {
        List<Hero> getAllHeroesOfUserFromDB(long userId);
    }
}
