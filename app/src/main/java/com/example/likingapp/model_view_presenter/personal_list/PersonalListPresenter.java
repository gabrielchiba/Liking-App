package com.example.likingapp.model_view_presenter.personal_list;


import android.content.Context;

public class PersonalListPresenter implements PersonalListContract.Presenter{
    private PersonalListContract.View view;
    private Context context;

    public PersonalListPresenter(PersonalListContract.View view, Context context) {
        this.view = view;
        this.context = context;
    }
}
