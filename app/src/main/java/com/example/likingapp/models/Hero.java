package com.example.likingapp.models;

import com.google.gson.annotations.SerializedName;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.Generated;

//import se.emilsjolander.sprinkles.Model;
//import se.emilsjolander.sprinkles.annotations.AutoIncrement;
//import se.emilsjolander.sprinkles.annotations.Column;
//import se.emilsjolander.sprinkles.annotations.Key;
//import se.emilsjolander.sprinkles.annotations.Table;

@Entity(nameInDb = "hero")
public class Hero {

    @Id(autoincrement = true)
    public long real_id;

    @Property(nameInDb = "user_id")
    public long user_id;

    @Property(nameInDb = "hero_id")
    public long id;

    @Property(nameInDb = "name")
    public String name;

    @Property(nameInDb = "description")
    public String description;

    @Property(nameInDb = "modified")
    public String modified;

    @Property(nameInDb = "thumbnail_url")
    public String thumbnail_url;

    @Property(nameInDb = "resource_uri")
    public String resourceURI;

    @Generated(hash = 1789810684)
    public Hero(long real_id, long user_id, long id, String name,
            String description, String modified, String thumbnail_url,
            String resourceURI) {
        this.real_id = real_id;
        this.user_id = user_id;
        this.id = id;
        this.name = name;
        this.description = description;
        this.modified = modified;
        this.thumbnail_url = thumbnail_url;
        this.resourceURI = resourceURI;
    }

    @Generated(hash = 2034257870)
    public Hero() {
    }

    public long getReal_id() {
        return this.real_id;
    }

    public void setReal_id(long real_id) {
        this.real_id = real_id;
    }

    public long getUser_id() {
        return this.user_id;
    }

    public void setUser_id(long user_id) {
        this.user_id = user_id;
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

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getModified() {
        return this.modified;
    }

    public void setModified(String modified) {
        this.modified = modified;
    }

    public String getThumbnail_url() {
        return this.thumbnail_url;
    }

    public void setThumbnail_url(String thumbnail_url) {
        this.thumbnail_url = thumbnail_url;
    }

    public String getResourceURI() {
        return this.resourceURI;
    }

    public void setResourceURI(String resourceURI) {
        this.resourceURI = resourceURI;
    }

    public Thumbnail thumbnail;

    public Content comics;
    public Content series;
    public Content stories;
    public Content events;

}
