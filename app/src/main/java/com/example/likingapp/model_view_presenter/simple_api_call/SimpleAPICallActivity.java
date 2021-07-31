package com.example.likingapp.model_view_presenter.simple_api_call;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.likingapp.R;
import com.example.likingapp.adapters.SuperHeroRecyclerViewAdapter;
import com.example.likingapp.api.RetrofitClient;
import com.example.likingapp.databinding.ActivitySimpleApicallBinding;
import com.example.likingapp.models.Hero;
import com.example.likingapp.models.CharacterDataWrapper;
import com.example.likingapp.utils.constants;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SimpleAPICallActivity extends AppCompatActivity implements SimpleAPICallContract.View,
        SearchView.OnQueryTextListener, SuperHeroRecyclerViewAdapter.ItemActionListener{

    private ActivitySimpleApicallBinding binding;
    private SimpleAPICallContract.Presenter presenter;

    SuperHeroRecyclerViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = new SimpleAPICallPresenter(this, this);
        binding = DataBindingUtil.setContentView(this,
                R.layout.activity_simple_apicall);
        String firstName = getIntent().getStringExtra("firstName");
        if (firstName != null)  binding.setFirstName(firstName);
        String login = getIntent().getStringExtra("login");
        if (login != null) binding.setLogin(login);
        String email = getIntent().getStringExtra("email");
        if (email != null) binding.setEmail(email);

        getSuperHeroes();

        setupSearchView();

    }

    @Override
    public void setupRecyclerView(List<Hero> heroes) {
        RecyclerView recyclerView = binding.heroesList;
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new SuperHeroRecyclerViewAdapter(this, heroes);
        adapter.setActionListener(this);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void setupSearchView() {
        binding.searchView.setQueryHint("Search");
        binding.searchView.setOnQueryTextListener(this);
        binding.searchView.setIconifiedByDefault(false);
    }

    private void getSuperHeroes() {
        Call<CharacterDataWrapper> call = RetrofitClient.getInstance().getMyApi().getsuperHeroes(constants.ts, constants.APIKey, constants.hash);
        Log.d("REQUEST", String.valueOf(call.request()));
        call.enqueue(new Callback<CharacterDataWrapper>() {
            @Override
            public void onResponse(Call<CharacterDataWrapper> call, Response<CharacterDataWrapper> response) {
                CharacterDataWrapper myheroList = response.body();
                setupRecyclerView(myheroList.getData().getResults());
//                Log.d("BODY", String.valueOf(myheroList.getData().getResults().get(0)));
            }

            @Override
            public void onFailure(Call<CharacterDataWrapper> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "Erro ao acessar Api", Toast.LENGTH_LONG).show();
            }

        });
    }

    @Override
    public void deleteItem(int position) {

    }

    @Override
    public void editItem(int position) {

    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        Toast.makeText(this, "Texto enviado", Toast.LENGTH_SHORT).show();
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        adapter.getFilter().filter(newText);
        return false;
    }
}