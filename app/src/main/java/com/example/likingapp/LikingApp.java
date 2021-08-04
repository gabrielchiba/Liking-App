package com.example.likingapp;

import android.app.Application;

import com.example.likingapp.migrations.CreateComicsMigration;
import com.example.likingapp.migrations.CreateEventsMigration;
import com.example.likingapp.migrations.CreateHeroMigration;
import com.example.likingapp.migrations.CreateOwnUserMigration;
import com.example.likingapp.migrations.CreatePersonMigration;
import com.example.likingapp.migrations.CreateSeriesMigration;
import com.example.likingapp.migrations.CreateStoriesMigration;

import se.emilsjolander.sprinkles.Sprinkles;

public class LikingApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        Sprinkles sprinkles = Sprinkles.init(getApplicationContext());

        sprinkles.addMigration(new CreateOwnUserMigration());
        sprinkles.addMigration(new CreatePersonMigration());
        sprinkles.addMigration(new CreateHeroMigration());

        sprinkles.addMigration(new CreateComicsMigration());
        sprinkles.addMigration(new CreateSeriesMigration());
        sprinkles.addMigration(new CreateStoriesMigration());
        sprinkles.addMigration(new CreateEventsMigration());
    }
}
