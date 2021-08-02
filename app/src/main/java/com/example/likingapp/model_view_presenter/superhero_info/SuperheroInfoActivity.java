package com.example.likingapp.model_view_presenter.superhero_info;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;

import com.example.likingapp.R;
import com.example.likingapp.databinding.ActivitySuperheroInfoBinding;

public class SuperheroInfoActivity extends AppCompatActivity implements SuperheroInfoContract.View{
    private ActivitySuperheroInfoBinding binding;
    private SuperheroInfoContract.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = new SuperHeroInfoPresenter(this, this);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_superhero_info);
    }
}