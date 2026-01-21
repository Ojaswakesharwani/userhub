package com.example.userhub;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class UserDetailFragment extends Fragment {
    TextView name, email, username;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_user_detail, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {

        name = view.findViewById(R.id.nameText);
        email = view.findViewById(R.id.emailText);
        username = view.findViewById(R.id.usernameText);

        SharedUserViewModel sharedViewModel =
                new ViewModelProvider(requireActivity())
                        .get(SharedUserViewModel.class);

        sharedViewModel.getUser().observe(getViewLifecycleOwner(), user -> {

            name.setText("Name : "+user.getName());
            email.setText("Email : "+user.getEmail());
            username.setText("Username : "+user.getUsername());
        });
    }
}