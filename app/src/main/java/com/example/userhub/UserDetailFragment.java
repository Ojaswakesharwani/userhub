package com.example.userhub;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class UserDetailFragment extends Fragment {
    TextView name, email, username , phone;
    TextView street, suite, city, zipcode, lat, lon;


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
        phone = view.findViewById(R.id.phone);

        street = view.findViewById(R.id.street);
        suite = view.findViewById(R.id.suit);
        city = view.findViewById(R.id.city);
        zipcode = view.findViewById(R.id.zipcode);


        SharedUserViewModel sharedViewModel =
                new ViewModelProvider(requireActivity())
                        .get(SharedUserViewModel.class);

        sharedViewModel.getUser().observe(getViewLifecycleOwner(), user -> {

            name.setText("Name : "+user.getName());
            email.setText("Email : "+user.getEmail());
            username.setText("Username : "+user.getUsername());
            phone.setText("Phone : "+user.getPhone());

            street.setText("Street : "+user.getAddress().getStreet());
            suite.setText("Suite : "+user.getAddress().getSuite());
            city.setText("City : "+user.getAddress().getCity());
            zipcode.setText("Zipcode : "+user.getAddress().getZipcode());



        });
    }
}