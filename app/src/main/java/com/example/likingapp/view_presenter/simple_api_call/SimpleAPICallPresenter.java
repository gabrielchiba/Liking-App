package com.example.likingapp.view_presenter.simple_api_call;

import android.content.Context;

import com.example.likingapp.api.RetrofitClient;
import com.example.likingapp.models.CharacterDataWrapper;
import com.example.likingapp.models.Hero;
import com.example.likingapp.utils.constants;

import java.util.List;

import retrofit2.Call;
import se.emilsjolander.sprinkles.CursorList;
import se.emilsjolander.sprinkles.Query;

public class SimpleAPICallPresenter implements SimpleAPICallContract.Presenter{
    private SimpleAPICallContract.View view;
    private Context context;

    public SimpleAPICallPresenter(SimpleAPICallContract.View view, Context context) {
        this.view = view;
        this.context = context;
    }

    @Override
    public Call<CharacterDataWrapper> getSuperHeroesFromAPI(String ts, String hash, String limit, String offset) {
        Call<CharacterDataWrapper> call = RetrofitClient
                .getInstance()
                .getMyApi()
                .getSuperHeroesAtLimitAtOffset(
                        ts,
                        constants.API_KEY,
                        hash,
                        limit,
                        offset);
        return call;
    }

//    @Override
//    public List<Hero> getAllHeroesOfUserFromDB(long userId) {
//        CursorList<Hero> cursorList = Query.many(Hero.class, " SELECT * FROM hero WHERE user_id = '" + userId + "'", true).get();
//        List<Hero> heroList = cursorList.asList();
//        cursorList.close();
//        return heroList;
//    }
}
