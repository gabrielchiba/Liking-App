package com.example.likingapp.view_presenter.personal_list;


import android.content.Context;

import com.example.likingapp.models.Hero;
import com.example.likingapp.models.Person;

import java.util.List;

import se.emilsjolander.sprinkles.CursorList;
import se.emilsjolander.sprinkles.Query;

public class PersonalListPresenter implements PersonalListContract.Presenter{
    private PersonalListContract.View view;
    private Context context;

    public PersonalListPresenter(PersonalListContract.View view, Context context) {
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

    @Override
    public void removeHeroByIDFromDB(long id) {
        Hero hero = Query.one(Hero.class, " SELECT * FROM hero WHERE id = " + id, true).get();
        hero.delete();
    }
}
