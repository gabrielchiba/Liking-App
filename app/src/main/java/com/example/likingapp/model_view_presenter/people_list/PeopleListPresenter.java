package com.example.likingapp.model_view_presenter.people_list;

import android.content.Context;

import com.example.likingapp.models.Person;

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
    public List<Person> getAllPersonsOfUserFromDB(long id) {
        CursorList<Person> cursorList = Query.many(Person.class, " SELECT * FROM person WHERE ID = '" + id + "'", true).get();
        List<Person> personList = cursorList.asList();
        cursorList.close();
        return personList;
    }
}
