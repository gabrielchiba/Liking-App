package com.example.likingapp.model_view_presenter.register_person;

import android.content.Context;

public class RegisterPersonPresenter implements RegisterPersonContract.Presenter{
    private RegisterPersonContract.View view;
    private Context context;

    public RegisterPersonPresenter(RegisterPersonContract.View view, Context context) {
        this.view = view;
        this.context = context;
    }
}
