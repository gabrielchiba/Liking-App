package com.example.likingapp.view_presenter.superhero_info;

import androidx.fragment.app.Fragment;

import com.example.likingapp.models.CharacterDataWrapper;
import com.example.likingapp.models.Hero;
import com.example.likingapp.models.HeroDao;

import retrofit2.Call;

public interface SuperheroInfoContract {
    interface View {
        void setFragment(Fragment fragment);
        void setFields(Hero hero);
        void setSuperHeroByIdFromAPI(String ts, String hash, long heroID);

    }
    interface Presenter {
        Hero getSuperHeroByHeroIdOnDB(HeroDao daoSession, long heroId);
        Call<CharacterDataWrapper> getSuperHeroesFromAPI(String id, String ts, String hash);
    }
}
