package com.example.likingapp.view_presenter.people_list;

import android.content.Context;

import com.example.likingapp.models.OwnUser;
import com.example.likingapp.models.OwnUserDao;
import com.example.likingapp.models.Person;
import com.example.likingapp.models.PersonDao;

import java.util.List;

import se.emilsjolander.sprinkles.CursorList;
import se.emilsjolander.sprinkles.Query;

public class PeopleListPresenter implements PeopleListContract.Presenter{
    private PeopleListContract.View view;
    private Context context;

    public PeopleListPresenter(PeopleListContract.View view, Context context) {
        this.view = view;
        this.context = context;
    }

    @Override
    public List<Person> getAllPersonsOfUserFromDB(PersonDao daoSession, long userId) {
        List<Person> personList = daoSession.queryBuilder().where(PersonDao.Properties.User_id.eq(userId)).list();
        return personList;
    }

    @Override
    public Person getOnePersonOfUserFromDB(PersonDao daoSession, long id) {
        Person person = null;
        List<Person> personList = daoSession.queryBuilder().where(PersonDao.Properties.Id.eq(id)).list();
        if (!personList.isEmpty())
            person = personList.get(0);
        return person;

    }

    @Override
    public void removePersonFromDB(PersonDao daoSession, Person person) {
        daoSession.delete(person);
    }
}
