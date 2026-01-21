package com.example.userhub;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.userhub.model.User;

public class SharedUserViewModel extends ViewModel {

    private MutableLiveData<User> selectedUser = new MutableLiveData<>();

    public void setUser(User user) {
        selectedUser.setValue(user);
    }

    public LiveData<User> getUser() {
        return selectedUser;
    }
}
