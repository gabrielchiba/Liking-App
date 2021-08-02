package com.example.likingapp.model_view_presenter.fragment_personal_list;

import android.content.Intent;
import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.likingapp.R;
import com.example.likingapp.databinding.FragmentPersonalListBinding;
import com.example.likingapp.model_view_presenter.people_list.PeopleListActivity;
import com.example.likingapp.model_view_presenter.simple_api_call.SimpleAPICallActivity;

public class PersonalListFragment extends Fragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        FragmentPersonalListBinding binding = DataBindingUtil.inflate(inflater, R.layout.fragment_personal_list, container, false);

        long userID = getActivity().getIntent().getLongExtra("registeredUserID", 0);

        View view = binding.getRoot();
        binding.buttonMyList.setOnClickListener(v -> personalListAccess(v, userID));
        binding.buttonBack.setOnClickListener(this::backAccess);
        return view;
    }

    public void personalListAccess(View v, long id) {
        Intent i = new Intent(getActivity(), PeopleListActivity.class);
        i.putExtra("registeredUserID", id);
        startActivity(i);
    }

    public void backAccess(View v) {
        getActivity().onBackPressed();
    }
}