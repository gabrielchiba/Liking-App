package com.example.likingapp.view_presenter.personal_list;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.likingapp.R;
import com.example.likingapp.adapters.SuperHeroRecyclerViewAdapter;
import com.example.likingapp.databinding.ActivityPersonalListBinding;
import com.example.likingapp.view_presenter.fragment_personal_list.PersonalListFragment;
import com.example.likingapp.models.OwnUser;

import java.util.ArrayList;

import se.emilsjolander.sprinkles.Query;


public class PersonalListActivity extends AppCompatActivity implements PersonalListContract.View,
        SearchView.OnQueryTextListener, SuperHeroRecyclerViewAdapter.ItemActionListener{

    private ActivityPersonalListBinding binding;
    private PersonalListContract.Presenter presenter;
    SuperHeroRecyclerViewAdapter adapter;

    // Foreign Key Reference
    long userID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        presenter = new PersonalListPresenter(this, this);
        binding = DataBindingUtil.setContentView(this,
                R.layout.activity_personal_list);

        userID = getIntent().getLongExtra("registeredUserID", 0);

        OwnUser user = Query.one(OwnUser.class, " SELECT * FROM own_user WHERE id = "+userID, true).get();

        setExtras(user);
        setFragment(PersonalListFragment.newInstance());
        setupRecyclerView();

    }

    @Override
    public void setExtras(OwnUser user) {
        binding.setUser(user);
    }

    @Override
    public void setFragment(Fragment fragment) {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(binding.frameLayoutFrag.getId(), fragment); // frag_container is your FrameLayout container
        ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        ft.commit();
    }

    @Override
    public void setupRecyclerView() {
        RecyclerView recyclerView = binding.personalHeroesList;
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new SuperHeroRecyclerViewAdapter(this, presenter.getAllHeroesOfUserFromDB(userID));
        adapter.setActionListener(this);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        adapter.getFilter().filter(newText);
        return false;
    }

    @Override
    public void infoItem(int position) {

    }

    @Override
    public void addItem(int position) {

    }
}