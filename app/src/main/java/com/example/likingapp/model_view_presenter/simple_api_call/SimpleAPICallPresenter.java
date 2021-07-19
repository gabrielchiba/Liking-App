package com.example.likingapp.model_view_presenter.simple_api_call;

import android.content.Context;

public class SimpleAPICallPresenter implements SimpleAPICallContract.Presenter{
    private SimpleAPICallContract.View view;
    private Context context;

    public SimpleAPICallPresenter(SimpleAPICallContract.View view, Context context) {
        this.view = view;
        this.context = context;
    }
}
