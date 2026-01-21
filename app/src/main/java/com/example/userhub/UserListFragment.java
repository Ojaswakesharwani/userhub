package com.example.userhub;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

public class UserListFragment extends Fragment {

    RecyclerView recyclerView;
    ProgressBar progressBar;

    UserViewModel apiViewModel;
    SharedUserViewModel sharedViewModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_user_list, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {

        recyclerView = view.findViewById(R.id.recyclerView);
        progressBar = view.findViewById(R.id.progressBar);

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        apiViewModel = new ViewModelProvider(this).get(UserViewModel.class);

        sharedViewModel = new ViewModelProvider(requireActivity())
                .get(SharedUserViewModel.class);

        progressBar.setVisibility(View.VISIBLE);

        apiViewModel.getUsers().observe(getViewLifecycleOwner(), users -> {

            progressBar.setVisibility(View.GONE);

            if (users != null) {

                UserAdapter adapter =
                        new UserAdapter(users, user -> {

                            sharedViewModel.setUser(user);

                            getParentFragmentManager()
                                    .beginTransaction()
                                    .replace(R.id.fragment_container,
                                            new UserDetailFragment())
                                    .addToBackStack(null)
                                    .commit();
                        });

                recyclerView.setAdapter(adapter);

            } else {

                Toast.makeText(getContext(),
                        "API Error", Toast.LENGTH_SHORT).show();
            }
        });
    }
}