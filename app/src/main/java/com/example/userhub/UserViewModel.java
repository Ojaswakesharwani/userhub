package com.example.userhub;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.userhub.model.User;

import java.util.List;

public class UserViewModel extends ViewModel {

    private UserRepository repository;

    public UserViewModel() {

        repository = new UserRepository();
    }

    public LiveData<List<User>> getUsers() {

        return repository.getUsers();
    }
}
