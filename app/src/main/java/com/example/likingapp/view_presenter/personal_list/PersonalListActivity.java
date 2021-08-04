package com.example.likingapp.view_presenter.personal_list;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import androidx.fragment.app.FragmentTransaction;
import android.os.Bundle;

import com.example.likingapp.R;
import com.example.likingapp.databinding.ActivityPersonalListBinding;
import com.example.likingapp.view_presenter.fragment_personal_list.PersonalListFragment;
import com.example.likingapp.models.OwnUser;

import se.emilsjolander.sprinkles.Query;


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

        OwnUser user = Query.one(OwnUser.class, " SELECT * FROM own_user WHERE id = "+userID, true).get();

        setExtras(user);
        setFragment(PersonalListFragment.newInstance());

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
}