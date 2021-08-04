package com.example.likingapp.view_presenter.simple_api_call;

import androidx.fragment.app.Fragment;

import com.example.likingapp.models.CharacterDataWrapper;
import com.example.likingapp.models.Hero;
import com.example.likingapp.models.OwnUser;

import java.util.List;

import retrofit2.Call;

public interface SimpleAPICallContract {
    interface View {
        void setupRecyclerView();
        void setupSearchView();
        void setExtras(OwnUser user);
        void sendExtrasToPersonalListFragment();
        void setFragment(Fragment fragment);
        void getAllSuperHeroes();
    }

    interface Presenter {
        Call<CharacterDataWrapper> getSuperHeroesFromAPI(String ts, String hash, String limit, String offset);
//        List<Hero> getAllHeroesOfUserFromDB(long userId);
    }
}
