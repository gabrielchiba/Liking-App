package com.example.likingapp.view_presenter.superhero_info;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.example.likingapp.R;
import com.example.likingapp.api.RetrofitClient;
import com.example.likingapp.models.CharacterDataWrapper;
import com.example.likingapp.models.Hero;
import com.example.likingapp.models.HeroDao;
import com.example.likingapp.utils.constants;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import se.emilsjolander.sprinkles.Query;

public class SuperHeroInfoPresenter implements SuperheroInfoContract.Presenter{
    private SuperheroInfoContract.View view;
    private Context context;

    public SuperHeroInfoPresenter(SuperheroInfoContract.View view, Context context) {
        this.view = view;
        this.context = context;
    }

    @Override
    public Hero getSuperHeroByHeroIdOnDB(HeroDao daoSession, long heroId) {
        return daoSession.queryBuilder().where(HeroDao.Properties.Id.eq(heroId)).list().get(0);
    }

    @Override
    public Call<CharacterDataWrapper> getSuperHeroesFromAPI(String id, String ts, String hash) {
        Call<CharacterDataWrapper> call = RetrofitClient
                .getInstance()
                .getMyApi()
                .getSuperHeroByID(
                        id,
                        ts,
                        constants.API_KEY,
                        hash);
        return call;
    }
}
