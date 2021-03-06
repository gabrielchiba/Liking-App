package com.example.likingapp.models;

import com.google.gson.annotations.SerializedName;

import se.emilsjolander.sprinkles.Model;
import se.emilsjolander.sprinkles.annotations.AutoIncrement;
import se.emilsjolander.sprinkles.annotations.Column;
import se.emilsjolander.sprinkles.annotations.Key;
import se.emilsjolander.sprinkles.annotations.Table;

@Table("hero")
public class Hero extends Model {

    @Key
    @AutoIncrement
    @Column("id")
    public long real_id;

    @Column("user_id")
    public long user_id;

    @Column("hero_id")
    public long id;

    @Column("name")
    public String name;

    @Column("description")
    public String description;

    @Column("modified")
    public String modified;

    @Column("thumbnail_url")
    public String thumbnail_url;

    @Column("resourceURI")
    public String resourceURI;

    public Thumbnail thumbnail;

    public Content comics;
    public Content series;
    public Content stories;
    public Content events;

}
