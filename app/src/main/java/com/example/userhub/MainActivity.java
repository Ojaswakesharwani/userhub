package com.example.userhub;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    ProgressBar progressBar;
    UserViewModel viewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerView);
        progressBar = findViewById(R.id.progressBar);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        viewModel = new ViewModelProvider(this).get(UserViewModel.class);

        progressBar.setVisibility(View.VISIBLE);

        viewModel.getUsers().observe(this, users -> {

            progressBar.setVisibility(View.GONE);

            if (users != null) {

                UserAdapter adapter = new UserAdapter(users);
                recyclerView.setAdapter(adapter);

            } else {

                Toast.makeText(this, "API Error", Toast.LENGTH_SHORT).show();
            }
        });

    }
}