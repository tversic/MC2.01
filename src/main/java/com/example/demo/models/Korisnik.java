package com.example.demo.models;

public class Korisnik {

    private String username;
    private String password;

    public Korisnik() {
        super();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Welcome " + username;
    }
}
