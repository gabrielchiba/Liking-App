package com.example.likingapp.model_view_presenter.superhero_info;

import android.content.Context;

import com.example.likingapp.model_view_presenter.personal_list.PersonalListContract;

public class SuperHeroInfoPresenter implements SuperheroInfoContract.Presenter{
    private SuperheroInfoContract.View view;
    private Context context;

    public SuperHeroInfoPresenter(SuperheroInfoContract.View view, Context context) {
        this.view = view;
        this.context = context;
    }
}
