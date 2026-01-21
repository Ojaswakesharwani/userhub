package com.example.userhub.model;

public class User {

    private int id;
    private String name;
    private String email;
    private String username;
    private String phone;

    private Address address;

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getUsername() {
        return username;
    }

    public String getPhone() {
        return phone;
    }

    public Address getAddress() {
        return address;
    }
}
