package com.example.likingapp.model_view_presenter.people_list;

import android.content.Intent;

import androidx.activity.result.ActivityResultLauncher;

import com.example.likingapp.models.Person;

import java.util.List;

public interface PeopleListContract {
    interface View {
        void registerNewPerson(ActivityResultLauncher<Intent> personActivityResultLauncher);
        ActivityResultLauncher<Intent> createPersonActivityLauncher();
        void setupRecyclerView();
    }

    interface Presenter {
        List<Person> getAllPersonsOfUserFromDB(long id);
    }
}
