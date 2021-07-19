package com.example.likingapp.utils;

import android.app.Application;
import android.database.sqlite.SQLiteDatabase;

import com.example.likingapp.migrations.CreateOwnUserMigration;

import java.sql.Date;

import se.emilsjolander.sprinkles.Migration;
import se.emilsjolander.sprinkles.Sprinkles;

public class LikingApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        Sprinkles sprinkles = Sprinkles.init(getApplicationContext());

        sprinkles.addMigration(new CreateOwnUserMigration());
    }
}
