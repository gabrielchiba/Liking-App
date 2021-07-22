package com.example.likingapp.model_view_presenter.people_list;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.likingapp.R;
import com.example.likingapp.databinding.ActivityPeopleListBinding;
import com.example.likingapp.model_view_presenter.register_person.RegisterPersonActivity;
import com.example.likingapp.utils.PeopleRecyclerViewAdapter;

import java.util.ArrayList;

public class PeopleListActivity extends AppCompatActivity implements PeopleListContract.View, PeopleRecyclerViewAdapter.ItemClickListener{
    PeopleRecyclerViewAdapter adapter;

    private ActivityPeopleListBinding binding;
    private PeopleListContract.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = new PeopleListPresenter(this, this);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_people_list);
        createFab();

        // data to populate the RecyclerView with
        ArrayList<String> animalNames = new ArrayList<>();
        animalNames.add("Horse");
        animalNames.add("Cow");
        animalNames.add("Camel");
        animalNames.add("Sheep");
        animalNames.add("Goat");

        // set up the RecyclerView
        RecyclerView recyclerView = binding.peopleList;
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new PeopleRecyclerViewAdapter(this, animalNames);
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
            startActivity(i);
        });
    }

}