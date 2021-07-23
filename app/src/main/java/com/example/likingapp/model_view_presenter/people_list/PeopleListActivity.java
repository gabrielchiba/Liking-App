package com.example.likingapp.model_view_presenter.people_list;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.likingapp.R;
import com.example.likingapp.databinding.ActivityPeopleListBinding;
import com.example.likingapp.model_view_presenter.register_person.RegisterPersonActivity;
import com.example.likingapp.models.Person;
import com.example.likingapp.utils.PeopleRecyclerViewAdapter;

import se.emilsjolander.sprinkles.Query;


public class PeopleListActivity extends AppCompatActivity implements PeopleListContract.View, PeopleRecyclerViewAdapter.ItemClickListener{
    PeopleRecyclerViewAdapter adapter;

    private ActivityPeopleListBinding binding;
    private PeopleListContract.Presenter presenter;
    private long userID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = new PeopleListPresenter(this, this);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_people_list);
        userID = getIntent().getLongExtra("registeredUserID", 0);

        createFab();

        setupRecyclerView();
//        Log.d("USERID", String.valueOf(userID));

//        OwnUser user = Query.one(OwnUser.class, " SELECT * FROM own_user WHERE id = " + userID, true).get();
    }

    @Override
    public void setupRecyclerView() {
        RecyclerView recyclerView = binding.peopleList;
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new PeopleRecyclerViewAdapter(this, presenter.getAllPersonsOfUserFromDB(userID));
        adapter.setClickListener(this);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onItemClick(View view, int position) {
        Toast.makeText(this, "You clicked " + adapter.getItem(position) + " on row number " + position, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void createFab() {
        binding.fab.setOnClickListener(view -> {
            Intent i = new Intent(PeopleListActivity.this, RegisterPersonActivity.class);
            i.putExtra("registeredUserID", userID);
            startActivity(i);
        });
    }

}