package com.example.likingapp.model_view_presenter.fragment_api_call;

import android.content.Intent;
import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.likingapp.R;
import com.example.likingapp.databinding.FragmentApiCallBinding;
import com.example.likingapp.model_view_presenter.personal_list.PersonalListActivity;


public class APICallFragment extends Fragment {

    public static Fragment newInstance() {
        APICallFragment mFragment = new APICallFragment();
        return mFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        FragmentApiCallBinding binding = DataBindingUtil.inflate(inflater, R.layout.fragment_api_call, container, false);

        long userID = getActivity().getIntent().getLongExtra("registeredUserID", 0);

        View view = binding.getRoot();
        binding.buttonMyList.setOnClickListener(v -> personalListAccess(v, userID));
        binding.buttonBack.setOnClickListener(this::backAccess);
        return view;
    }

    public void personalListAccess(View v, long id) {
        Intent i = new Intent(getActivity(), PersonalListActivity.class);
        i.putExtra("registeredUserID", id);
        startActivity(i);
    }

    public void backAccess(View v) {
        getActivity().onBackPressed();
    }
}