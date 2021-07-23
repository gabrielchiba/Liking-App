package com.example.likingapp.model_view_presenter.people_list;

import com.example.likingapp.models.Person;

import java.util.List;

public interface PeopleListContract {
    interface View {
        void createFab();
        void setupRecyclerView();
    }

    interface Presenter {
        List<Person> getAllPersonsOfUserFromDB(long id);
    }
}
