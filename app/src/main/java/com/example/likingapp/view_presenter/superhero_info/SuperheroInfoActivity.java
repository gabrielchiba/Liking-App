package com.example.likingapp.view_presenter.superhero_info;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.likingapp.R;
import com.example.likingapp.databinding.ActivitySuperheroInfoBinding;
import com.example.likingapp.models.CharacterDataWrapper;
import com.example.likingapp.models.Hero;
import com.example.likingapp.utils.AppUtils;
import com.example.likingapp.utils.constants;
import com.example.likingapp.view_presenter.fragment_personal_list.PersonalListFragment;
import com.squareup.picasso.Picasso;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SuperheroInfoActivity extends AppCompatActivity implements SuperheroInfoContract.View{
    private ActivitySuperheroInfoBinding binding;
    private SuperheroInfoContract.Presenter presenter;

    // Hero Id reference
    long heroID;

    // Auxiliary Class
    AppUtils appUtils;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = new SuperHeroInfoPresenter(this, this);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_superhero_info);

        heroID = getIntent().getLongExtra("heroID", 0);

        appUtils = new AppUtils(getApplicationContext());
        String ts = appUtils.getTimeStamp();
        String hash = appUtils.md5(ts+ constants.PRIVATE_KEY+constants.API_KEY);

        setSuperHeroByIdFromAPI(ts, hash, heroID);

        setFragment(PersonalListFragment.newInstance());
    }

    @Override
    public void setSuperHeroByIdFromAPI(String ts, String hash, long heroID) {

        Call<CharacterDataWrapper> call = presenter.getSuperHeroesFromAPI(String.valueOf(heroID), ts, hash);
        Log.d("REQUEST", String.valueOf(call.request()));

        call.enqueue(new Callback<CharacterDataWrapper>() {
            @Override
            public void onResponse(Call<CharacterDataWrapper> call, Response<CharacterDataWrapper> response) {
                CharacterDataWrapper completeResponse = response.body();
                List<Hero> heroesList = completeResponse.getData().getResults();
                Hero hero = heroesList.get(0);
                setFields(hero);
            }

            @Override
            public void onFailure(Call<CharacterDataWrapper> call, Throwable t) {
                Toast.makeText(getApplicationContext(), R.string.error_api_access, Toast.LENGTH_LONG).show();
            }


        });
    }

    @Override
    public void setFragment(Fragment fragment) {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(binding.frameLayout.getId(), fragment);
        ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        ft.commit();
    }

    @Override
    public void setFields(Hero hero) {
        if (hero.name != null & !hero.name.isEmpty()) {
            binding.setHeroName(hero.name);
        } else {
            binding.setHeroName(getResources().getString(R.string.super_hero_name));
        }
        if (hero.description != null & !hero.description.isEmpty()) {
            binding.setHeroDescription(hero.description);
        } else {
            binding.setHeroDescription(getResources().getString(R.string.description_super_hero));
        }
        if (hero.thumbnail != null & !hero.thumbnail.getPath().isEmpty()) {
            String imageURL = hero.thumbnail.getPath() + '.' + hero.thumbnail.getExtension();
            Picasso.get().load(imageURL).into(binding.imageViewHeroAvatar);
        }
    }
}