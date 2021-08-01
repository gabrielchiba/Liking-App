package com.example.likingapp.models;

public class Hero {
    private int id;
    private String name;
    private String description;
    private String modified;
    private Thumbnail thumbnail;
    private String resourceURI;
    private Content comics;
    private Content series;
    private Content stories;
    private Content events;

    public Hero(Hero hero) {
        this.id = hero.id;
        this.name = hero.name;
        this.description = hero.description;
        this.modified = hero.modified;
        this.thumbnail = hero.thumbnail;
        this.resourceURI = hero.resourceURI;
        this.comics = hero.comics;
        this.series = hero.series;
        this.stories = hero.stories;
        this.events = hero.events;
    }

    public Hero(int id, String name, String description, String modified, Thumbnail thumbnail,
                String resourceURI, Content comics, Content series, Content stories, Content events) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.modified = modified;
        this.thumbnail = thumbnail;
        this.resourceURI = resourceURI;
        this.comics = comics;
        this.series = series;
        this.stories = stories;
        this.events = events;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getModified() {
        return modified;
    }

    public void setModified(String modified) {
        this.modified = modified;
    }

    public Thumbnail getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(Thumbnail thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getResourceURI() {
        return resourceURI;
    }

    public void setResourceURI(String resourceURI) {
        this.resourceURI = resourceURI;
    }

    public Content getComics() {
        return comics;
    }

    public void setComics(Content comics) {
        this.comics = comics;
    }

    public Content getSeries() {
        return series;
    }

    public void setSeries(Content series) {
        this.series = series;
    }

    public Content getStories() {
        return stories;
    }

    public void setStories(Content stories) {
        this.stories = stories;
    }

    public Content getEvents() {
        return events;
    }

    public void setEvents(Content events) {
        this.events = events;
    }
}
