package com.example.likingapp.view_presenter.fragment_personal_list;

import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.likingapp.R;
import com.example.likingapp.databinding.FragmentPersonalListBinding;


public class PersonalListFragment extends Fragment {

    public static Fragment newInstance() {
        PersonalListFragment mFragment = new PersonalListFragment();
        return mFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        FragmentPersonalListBinding binding = DataBindingUtil.inflate(inflater, R.layout.fragment_personal_list, container, false);

        View view = binding.getRoot();
        binding.buttonBack2.setOnClickListener(this::backAccess);
        return view;
    }


    public void backAccess(View v) {
        getActivity().onBackPressed();
    }
}