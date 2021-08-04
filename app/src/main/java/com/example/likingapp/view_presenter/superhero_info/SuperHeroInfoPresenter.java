package com.example.likingapp.view_presenter.superhero_info;

import android.content.Context;

public class SuperHeroInfoPresenter implements SuperheroInfoContract.Presenter{
    private SuperheroInfoContract.View view;
    private Context context;

    public SuperHeroInfoPresenter(SuperheroInfoContract.View view, Context context) {
        this.view = view;
        this.context = context;
    }
}
