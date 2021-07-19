package com.example.likingapp.migrations;

import android.database.sqlite.SQLiteDatabase;

import se.emilsjolander.sprinkles.Migration;

public class CreateOwnUserMigration extends Migration {

    @Override
    protected void doMigration(SQLiteDatabase db) {
        db.execSQL(
                " CREATE TABLE own_user ( " +
                        " id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                        " name TEXT, "  +
                        " last_name TEXT, "  +
                        " login TEXT, "  +
                        " email TEXT, " +
                        " save_credentials INTEGER, " +
                        " password TEXT " +
                        " ) "
        );
    }
}
