package com.example.likingapp.model_view_presenter.register_person;

import com.example.likingapp.models.Person;

public interface RegisterPersonContract {
    interface View {

    }

    interface Presenter {
        Person createNewEmptyPerson();
        void registerPersonOnDB(Person person);
    }
}
