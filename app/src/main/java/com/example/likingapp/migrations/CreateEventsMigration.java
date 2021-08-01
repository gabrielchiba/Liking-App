package com.example.likingapp.migrations;

import android.database.sqlite.SQLiteDatabase;

import se.emilsjolander.sprinkles.Migration;

public class CreateEventsMigration extends Migration {
    @Override
    protected void doMigration(SQLiteDatabase db) {
        db.execSQL(
                " CREATE TABLE IF NOT EXISTS events ( " +
                        " id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                        " name TEXT, "  +
                        " resourceURI TEXT, " +
                        " user_id INTEGER, " +
                        " hero_id INTEGER, " +
                        " FOREIGN KEY (user_id) REFERENCES own_user(id), " +
                        " FOREIGN KEY (hero_id) REFERENCES hero(hero_id)" +
                        " ) "
        );
    }
}
