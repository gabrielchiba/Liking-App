package com.example.likingapp.view_presenter.simple_api_call;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.widget.Toast;

import com.example.likingapp.R;
import com.example.likingapp.adapters.SuperHeroRecyclerViewAdapter;
import com.example.likingapp.api.RetrofitClient;
import com.example.likingapp.databinding.ActivitySimpleApicallBinding;
import com.example.likingapp.view_presenter.fragment_api_call.APICallFragment;
import com.example.likingapp.view_presenter.superhero_info.SuperheroInfoActivity;
import com.example.likingapp.models.Hero;
import com.example.likingapp.models.CharacterDataWrapper;
import com.example.likingapp.models.OwnUser;
import com.example.likingapp.utils.AppUtils;
import com.example.likingapp.utils.constants;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import se.emilsjolander.sprinkles.Query;

public class SimpleAPICallActivity extends AppCompatActivity implements SimpleAPICallContract.View,
        SuperHeroRecyclerViewAdapter.ItemActionListener{

    private ActivitySimpleApicallBinding binding;
    private SimpleAPICallContract.Presenter presenter;

    // Auxiliary Class
    AppUtils appUtils;

    SuperHeroRecyclerViewAdapter adapter;

    // Foreign Key Reference
    private long userID;

    // Flag to update
    private boolean isUpdate = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = new SimpleAPICallPresenter(this, this);
        binding = DataBindingUtil.setContentView(this,
                R.layout.activity_simple_apicall);

        appUtils = new AppUtils(getApplicationContext());

        userID = getIntent().getLongExtra("registeredUserID", 0);

        OwnUser user = Query.one(OwnUser.class, " SELECT * FROM own_user WHERE id = "+userID, true).get();

        sendExtrasToPersonalListFragment();

        setExtras(user);
        setupRecyclerView();
        setupSearchView();
        setFragment(APICallFragment.newInstance());
        getAllSuperHeroes();

    }

    @Override
    public void setupRecyclerView() {
        RecyclerView recyclerView = binding.heroesList;
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new SuperHeroRecyclerViewAdapter(this, new ArrayList<>());
        adapter.setActionListener(this);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void setupSearchView() {
        binding.searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                adapter.getFilter().filter(newText);
                return false;
            }
        });
        binding.searchView.setFocusable(false);
        binding.searchView.setIconifiedByDefault(false);
        binding.searchView.clearFocus();
    }

    @Override
    public void setExtras(OwnUser user) {
        binding.setUser(user);
    }

    @Override
    public void setFragment(Fragment fragment) {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(binding.frameLayoutFrag.getId(), fragment);
        ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        ft.commit();
    }

    @Override
    public void sendExtrasToPersonalListFragment() {
        Intent i = new Intent(SimpleAPICallActivity.this, APICallFragment.class);
        i.putExtra("registeredUserID", userID);
//        startActivity(i);
    }

    @Override
    public void getAllSuperHeroes() {
        String ts = appUtils.getTimeStamp();
        String hash = appUtils.md5(ts+constants.PRIVATE_KEY+constants.API_KEY);
        int limit = 100;

        for (int i = 0; i < 1493; i+=limit) {
            Call<CharacterDataWrapper> call = presenter.getSuperHeroesFromAPI(ts, hash, Long.toString(limit), Long.toString(i));

            Log.d("REQUEST", i + String.valueOf(call.request()));
            call.enqueue(new Callback<CharacterDataWrapper>() {
                @Override
                public void onResponse(Call<CharacterDataWrapper> call, Response<CharacterDataWrapper> response) {
                    CharacterDataWrapper completeResponse = response.body();
                    List<Hero> heroesList = completeResponse.getData().getResults();
                    adapter.addAll(heroesList);
                }

                @Override
                public void onFailure(Call<CharacterDataWrapper> call, Throwable t) {
                    Toast.makeText(getApplicationContext(), R.string.error_api_access, Toast.LENGTH_LONG).show();
                }

            });
        }
    }

    @Override
    public void infoItem(int position) {
        Intent i = new Intent(SimpleAPICallActivity.this, SuperheroInfoActivity.class);
        i.putExtra("heroID", adapter.getItem(position).id);
        startActivity(i);
    }

    @Override
    public void addOrDeleteItem(int position) {
        presenter.registerHeroOnDB(adapter.getItem(position), userID);
        Toast.makeText(this, R.string.added_hero, Toast.LENGTH_SHORT).show();
    }
}