package com.example.likingapp.model_view_presenter.people;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.provider.Contacts;
import android.view.View;

import com.example.likingapp.R;
import com.example.likingapp.databinding.ActivityPeopleBinding;
import com.example.likingapp.model_view_presenter.register_person.RegisterPersonActivity;

public class PeopleActivity extends AppCompatActivity implements PeopleContract.View{

    private ActivityPeopleBinding binding;
    private PeopleContract.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = new PeoplePresenter(this, this);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_people);

        binding.fab.setOnClickListener(view -> {
            Intent i = new Intent(PeopleActivity.this, RegisterPersonActivity.class);
            startActivity(i);
        });
    }
}