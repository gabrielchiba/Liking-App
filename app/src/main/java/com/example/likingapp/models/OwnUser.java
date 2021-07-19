package com.example.likingapp.models;

import se.emilsjolander.sprinkles.Model;
import se.emilsjolander.sprinkles.annotations.AutoIncrement;
import se.emilsjolander.sprinkles.annotations.Column;
import se.emilsjolander.sprinkles.annotations.Key;
import se.emilsjolander.sprinkles.annotations.Table;

@Table("own_user")
public class OwnUser extends Model {

    @Key
    @AutoIncrement
    @Column("id")
    public long id;

    @Column("name")
    public String name;

    @Column("last_name")
    public String lastName;

    @Column("login")
    public String login;

    @Column("email")
    public String email;

    @Column("save_credentials")
    public boolean saveCredentials;

    @Column("password")
    public String password;
}
