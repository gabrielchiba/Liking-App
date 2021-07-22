package com.example.likingapp.migrations;

import android.database.sqlite.SQLiteDatabase;

import se.emilsjolander.sprinkles.Migration;

public class CreatePersonMigration extends Migration {

    @Override
    protected void doMigration(SQLiteDatabase db) {
        db.execSQL(
                " CREATE TABLE IF NOT EXISTS person ( " +
                        " id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                        " name TEXT, "  +
                        " last_name TEXT, "  +
                        " birthday TEXT, "  +
                        " phone TEXT, " +
                        " cpf TEXT, " +
                        " email TEXT, " +
                        " user_id INTEGER, " +
                        " FOREIGN KEY (user_id) REFERENCES own_user(id)" +
                        " ) "
        );
    }
}
