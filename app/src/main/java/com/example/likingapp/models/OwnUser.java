package com.example.likingapp.models;

//import se.emilsjolander.sprinkles.Model;
//import se.emilsjolander.sprinkles.annotations.AutoIncrement;
//import se.emilsjolander.sprinkles.annotations.Column;
//import se.emilsjolander.sprinkles.annotations.Key;
//import se.emilsjolander.sprinkles.annotations.Table;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.Generated;

@Entity(nameInDb = "own_user")
public class OwnUser {

    @Id(autoincrement = true)
    public long id;

    @Property(nameInDb = "name")
    public String name;

    @Property(nameInDb = "last_name")
    public String lastName;

    @Property(nameInDb = "login")
    public String login;

    @Property(nameInDb = "email")
    public String email;

    @Property(nameInDb = "save_credentials")
    public boolean saveCredentials;

    @Property(nameInDb = "password")
    public String password;

    @Generated(hash = 414767830)
    public OwnUser(long id, String name, String lastName, String login,
            String email, boolean saveCredentials, String password) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.login = login;
        this.email = email;
        this.saveCredentials = saveCredentials;
        this.password = password;
    }

    @Generated(hash = 114268391)
    public OwnUser() {
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLogin() {
        return this.login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean getSaveCredentials() {
        return this.saveCredentials;
    }

    public void setSaveCredentials(boolean saveCredentials) {
        this.saveCredentials = saveCredentials;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
