package com.example.likingapp.models;

import se.emilsjolander.sprinkles.Model;
import se.emilsjolander.sprinkles.annotations.AutoIncrement;
import se.emilsjolander.sprinkles.annotations.Column;
import se.emilsjolander.sprinkles.annotations.Key;
import se.emilsjolander.sprinkles.annotations.Table;

@Table("person")
public class Person extends Model {

    @Key
    @AutoIncrement
    @Column("id")
    public long id;

    @Column("user_id")
    public long user_id;

    @Column("name")
    public String name;

    @Column("last_name")
    public String lastName;

    @Column("birthday")
    public String birthday;

    @Column("phone")
    public String phone;

    @Column("cpf")
    public String cpf;

    @Column("email")
    public String email;
}
