package com.example.likingapp.migrations;

import android.database.sqlite.SQLiteDatabase;

import se.emilsjolander.sprinkles.Migration;

public class CreateHeroMigration extends Migration {
    @Override
    protected void doMigration(SQLiteDatabase db) {
        db.execSQL(
                " CREATE TABLE IF NOT EXISTS hero ( " +
                        " id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                        " hero_id INTEGER, "  +
                        " name TEXT, "  +
                        " description TEXT, "  +
                        " modified TEXT, "  +
                        " thumbnail_url TEXT, " +
                        " resourceURI TEXT, " +
                        " user_id INTEGER, " +
                        " FOREIGN KEY (user_id) REFERENCES own_user(id)" +
                        " ) "
        );
    }
}
