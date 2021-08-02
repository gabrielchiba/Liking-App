package com.example.likingapp.model_view_presenter.people_list;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.example.likingapp.R;
import com.example.likingapp.databinding.ActivityPeopleListBinding;
import com.example.likingapp.model_view_presenter.register_person.RegisterPersonActivity;
import com.example.likingapp.adapters.PeopleRecyclerViewAdapter;
import com.example.likingapp.utils.AppUtils;


public class PeopleListActivity extends AppCompatActivity implements PeopleListContract.View,
        SearchView.OnQueryTextListener, PeopleRecyclerViewAdapter.ItemActionListener{
    PeopleRecyclerViewAdapter adapter;
    ActivityResultLauncher<Intent> personActivityResultLauncher;

    // Auxiliary Functions Class
    AppUtils appUtils;

    private ActivityPeopleListBinding binding;
    private PeopleListContract.Presenter presenter;

    // Foreign Key Reference
    private long userID;

    // Flag to update
    private boolean isUpdate = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = new PeopleListPresenter(this, this);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_people_list);
        userID = getIntent().getLongExtra("registeredUserID", 0);

        setupRecyclerView();

        setupSearchView();

        personActivityResultLauncher = createPersonActivityLauncher();

        binding.fab.setOnClickListener(view -> registerNewPerson(0, false));


    }

    @Override
    public ActivityResultLauncher<Intent> createPersonActivityLauncher() {
        return registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                result -> {
                    if (result.getResultCode() == Activity.RESULT_OK) {
                        Intent data = result.getData();
                        assert data != null;
                        long id = data.getLongExtra("registeredPersonID", 0);

                        if (!isUpdate) {
                            adapter.add(adapter.getItemCount(), presenter.getOnePersonOfUserFromDB(id));
                        }
                    }
                });
    }

    @Override
    public void setupRecyclerView() {
        RecyclerView recyclerView = binding.peopleList;
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new PeopleRecyclerViewAdapter(this, presenter.getAllPersonsOfUserFromDB(userID));
        adapter.setActionListener(this);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void updateElement(int position, long id) {
        adapter.update(position, presenter.getOnePersonOfUserFromDB(id));
    }

    @Override
    public void setupSearchView() {
        binding.searchView2.setOnQueryTextListener(this);
        binding.searchView2.setIconifiedByDefault(false);
    }

    @Override
    public void registerNewPerson(long id, boolean isUpdate) {
        // Set if is update
        this.isUpdate = isUpdate;
        Intent i = new Intent(PeopleListActivity.this, RegisterPersonActivity.class);
        i.putExtra("registeredUserID", userID);
        i.putExtra("editPersonID", id);
        personActivityResultLauncher.launch(i);
    }

    @Override
    public void deleteItem(int position) {
        presenter.removePersonFromDB(adapter.getItem(position));
        adapter.remove(position);
    }

    @Override
    public void editItem(int position) {
        registerNewPerson(adapter.getItem(position).id, true);
        updateElement(position, adapter.getItem(position).id);
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