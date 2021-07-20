package com.example.likingapp.model_view_presenter.register_person;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;

import com.example.likingapp.R;
import com.example.likingapp.databinding.ActivityRegisterPersonBinding;

public class RegisterPersonActivity extends AppCompatActivity implements RegisterPersonContract.View{

    private ActivityRegisterPersonBinding binding;
    private RegisterPersonContract.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = new RegisterPersonPresenter(this, this);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_register_person);

    }
}