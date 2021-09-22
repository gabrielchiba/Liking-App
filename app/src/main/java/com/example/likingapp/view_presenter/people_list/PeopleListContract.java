package com.example.likingapp.view_presenter.people_list;

import android.content.Intent;

import androidx.activity.result.ActivityResultLauncher;

import com.example.likingapp.models.Person;
import com.example.likingapp.models.PersonDao;

import java.util.List;

public interface PeopleListContract {
    interface View {
        void registerNewPerson(long id, boolean isUpdate);
        ActivityResultLauncher<Intent> createPersonActivityLauncher();
        void setupRecyclerView();
        void updateElement(int position, long id);
        void setupSearchView();
    }

    interface Presenter {
        List<Person> getAllPersonsOfUserFromDB(PersonDao daoSession, long userId);
        Person getOnePersonOfUserFromDB(PersonDao daoSession, long id);
        void removePersonFromDB(PersonDao daoSession, Person person);
    }
}
