package com.example.likingapp.model_view_presenter.people;

import android.content.Context;

public class PeoplePresenter implements PeopleContract.Presenter{
    private PeopleContract.View view;
    private Context context;

    public PeoplePresenter(PeopleContract.View view, Context context) {
        this.view = view;
        this.context = context;
    }
}
