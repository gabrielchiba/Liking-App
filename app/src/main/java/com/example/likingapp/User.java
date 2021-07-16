package com.example.likingapp;

public class User {
    private String name, surname, login, pass, email;

    public User(String name, String surname, String login, String pass, String email) {
        this.name = name;
        this.surname = surname;
        this.login = login;
        this.pass = pass;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getEmail() { return email; }

    public void setEmail(String email) { this.email = email; }
}
