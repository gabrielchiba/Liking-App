package com.example.likingapp.model_view_presenter.simple_api_call;

import android.content.Context;

import com.example.likingapp.models.Hero;
import com.example.likingapp.models.Person;

import java.util.List;

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
    public List<Hero> getAllHeroesOfUserFromDB(long userId) {
        CursorList<Hero> cursorList = Query.many(Hero.class, " SELECT * FROM hero WHERE user_id = '" + userId + "'", true).get();
        List<Hero> heroList = cursorList.asList();
        cursorList.close();
        return heroList;
    }
}
