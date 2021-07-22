package com.example.likingapp.model_view_presenter.register_person;

import android.content.Context;

import com.example.likingapp.models.Person;

public class RegisterPersonPresenter implements RegisterPersonContract.Presenter{
    private RegisterPersonContract.View view;
    private Context context;

    public RegisterPersonPresenter(RegisterPersonContract.View view, Context context) {
        this.view = view;
        this.context = context;
    }

    @Override
    public Person createNewEmptyPerson() {
        return new Person();
    }

    @Override
    public void registerPersonOnDB(Person person) {
        person.save();
    }

}
