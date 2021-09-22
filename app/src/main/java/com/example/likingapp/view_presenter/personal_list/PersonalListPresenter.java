package com.example.likingapp.view_presenter.personal_list;


import android.content.Context;

import com.example.likingapp.models.Hero;
import com.example.likingapp.models.HeroDao;
import com.example.likingapp.models.Person;
import com.example.likingapp.models.PersonDao;

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
    public List<Hero> getAllHeroesOfUserFromDB(HeroDao daoSession, long userId) {
        List<Hero> heroList = daoSession.queryBuilder().where(HeroDao.Properties.User_id.eq(userId)).list();
        return heroList;
    }

    @Override
    public void removeHeroByIDFromDB(HeroDao daoSession, long id) {
        Hero hero = daoSession.queryBuilder().where(HeroDao.Properties.Id.eq(id)).list().get(0);
        daoSession.delete(hero);
    }
}
