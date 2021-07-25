package com.example.likingapp.model_view_presenter.people_list;

import android.content.Intent;

import androidx.activity.result.ActivityResultLauncher;

import com.example.likingapp.models.Person;

import java.util.List;

public interface PeopleListContract {
    interface View {
        void registerNewPerson(long id, boolean isUpdate);
        ActivityResultLauncher<Intent> createPersonActivityLauncher();
        void setupRecyclerView();
        void updateElement(int position, long id);
    }

    interface Presenter {
        List<Person> getAllPersonsOfUserFromDB(long userId);
        Person getOnePersonOfUserFromDB(long id);
        void removePersonFromDB(Person person);
    }
}
