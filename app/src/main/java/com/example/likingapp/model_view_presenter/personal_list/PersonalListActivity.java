package com.example.likingapp.model_view_presenter.personal_list;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.util.Log;

import com.example.likingapp.R;
import com.example.likingapp.databinding.ActivityPersonalListBinding;


public class PersonalListActivity extends AppCompatActivity implements PersonalListContract.View{

    private ActivityPersonalListBinding binding;
    private PersonalListContract.Presenter presenter;

    // Foreign Key Reference
    long userID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        presenter = new PersonalListPresenter(this, this);
        binding = DataBindingUtil.setContentView(this,
                R.layout.activity_personal_list);

        userID = getIntent().getLongExtra("registeredUserID", 0);
        Log.d("ID", String.valueOf(userID));
    }
}