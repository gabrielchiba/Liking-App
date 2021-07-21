package com.example.likingapp.model_view_presenter.people_list;

import android.content.Context;

public class PeopleListPresenter implements PeopleListContract.Presenter{
    private PeopleListContract.View view;
    private Context context;

    public PeopleListPresenter(PeopleListContract.View view, Context context) {
        this.view = view;
        this.context = context;
    }
}
