package com.example.likingapp.model_view_presenter.people;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.app.Activity;
import android.os.Bundle;

import com.example.likingapp.R;
import com.example.likingapp.databinding.ActivityPeopleBinding;

public class PeopleActivity extends AppCompatActivity implements PeopleContract.View{

    private ActivityPeopleBinding binding;
    private PeopleContract.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = new PeoplePresenter(this, this);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_people);
    }
}