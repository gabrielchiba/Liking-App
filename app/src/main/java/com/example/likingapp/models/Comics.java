package com.example.likingapp.models;

import java.util.List;

import se.emilsjolander.sprinkles.Model;
import se.emilsjolander.sprinkles.annotations.AutoIncrement;
import se.emilsjolander.sprinkles.annotations.Column;
import se.emilsjolander.sprinkles.annotations.Key;
import se.emilsjolander.sprinkles.annotations.Table;

@Table("comics")
public class Comics extends Model {
    @Key
    @AutoIncrement
    @Column("id")
    public long id;

    @Column("user_id")
    public long user_id;

    @Column("hero_id")
    public long hero_id;

    @Column("name")
    public String name;

    @Column("resourceURI")
    public String resourceURI;
}
