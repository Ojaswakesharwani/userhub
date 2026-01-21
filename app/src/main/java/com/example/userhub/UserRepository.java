package com.example.userhub;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserRepository {

    private ApiService apiService;

    public UserRepository() {

        apiService = RetrofitClient
                .getRetrofit()
                .create(ApiService.class);
    }

    public LiveData<List<User>> getUsers() {

        MutableLiveData<List<User>> liveData = new MutableLiveData<>();

        apiService.getUsers().enqueue(new Callback<List<User>>() {

            @Override
            public void onResponse(Call<List<User>> call, Response<List<User>> response) {

                if (response.isSuccessful()) {
                    liveData.setValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<List<User>> call, Throwable t) {

                liveData.setValue(null);
            }
        });

        return liveData;
    }
}

