package com.example.likingapp.model_view_presenter.simple_api_call;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.likingapp.R;
import com.example.likingapp.api.RetrofitClient;
import com.example.likingapp.databinding.ActivitySimpleApicallBinding;
import com.example.likingapp.models.CharacterDataWrapper;
import com.example.likingapp.utils.PeopleRecyclerViewAdapter;
import com.example.likingapp.utils.constants;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SimpleAPICallActivity extends AppCompatActivity implements SimpleAPICallContract.View, PeopleRecyclerViewAdapter.ItemActionListener{

    private ActivitySimpleApicallBinding binding;
    private SimpleAPICallContract.Presenter presenter;

    PeopleRecyclerViewAdapter adapter;

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

//        setupRecyclerView();

        getSuperHeroes();
    }

    private void setupRecyclerView() {
//        RecyclerView recyclerView = binding.heroesList;
//        recyclerView.setLayoutManager(new LinearLayoutManager(this));
//        adapter = new PeopleRecyclerViewAdapter(this, );
//        adapter.setActionListener(this);
//        recyclerView.setAdapter(adapter);
    }

    private void getSuperHeroes() {
        Call<CharacterDataWrapper> call = RetrofitClient.getInstance().getMyApi().getsuperHeroes(constants.ts, constants.APIKey, constants.hash);
        Log.d("REQUEST", String.valueOf(call.request()));
        call.enqueue(new Callback<CharacterDataWrapper>() {
            @Override
            public void onResponse(Call<CharacterDataWrapper> call, Response<CharacterDataWrapper> response) {
                CharacterDataWrapper myheroList = response.body();
                Log.d("BODY", String.valueOf(myheroList.getData().getCount()));

//                superListView.setAdapter(new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, myhero));
            }

            @Override
            public void onFailure(Call<CharacterDataWrapper> call, Throwable t) {
                t.getCause();
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
}