package com.example.likingapp;

import android.app.Application;

import com.example.likingapp.migrations.CreateHeroMigration;
import com.example.likingapp.migrations.CreateOwnUserMigration;
import com.example.likingapp.migrations.CreatePersonMigration;

import se.emilsjolander.sprinkles.Sprinkles;

public class LikingApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        Sprinkles sprinkles = Sprinkles.init(getApplicationContext());

        sprinkles.addMigration(new CreateOwnUserMigration());
        sprinkles.addMigration(new CreatePersonMigration());
        sprinkles.addMigration(new CreateHeroMigration());
    }
}
