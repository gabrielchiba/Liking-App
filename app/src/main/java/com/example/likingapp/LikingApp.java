package com.example.likingapp;

import android.app.Application;

import com.example.likingapp.migrations.CreateHeroMigration;
import com.example.likingapp.migrations.CreateOwnUserMigration;
import com.example.likingapp.migrations.CreatePersonMigration;
import com.example.likingapp.models.DaoMaster;
import com.example.likingapp.models.DaoSession;
import com.example.likingapp.models.OwnUser;
import com.example.likingapp.utils.DbOpenHelper;

import se.emilsjolander.sprinkles.Sprinkles;

public class LikingApp extends Application {
    private DaoSession mDaoSession;

    @Override
    public void onCreate() {
        super.onCreate();

        mDaoSession = new DaoMaster(
                new DbOpenHelper(this, "greendao.db").getWritableDb()).newSession();

        // USER CREATION FOR DEMO PURPOSE
        if(mDaoSession.getOwnUserDao().loadAll().size() == 0){
            mDaoSession.getOwnUserDao().insert(new OwnUser(1L, "Jo", "ao", "jo.ao", "joao@feg.com", false, "123"));
        }

        Sprinkles sprinkles = Sprinkles.init(getApplicationContext());

        sprinkles.addMigration(new CreateOwnUserMigration());
        sprinkles.addMigration(new CreatePersonMigration());
        sprinkles.addMigration(new CreateHeroMigration());
    }

    public DaoSession getDaoSession() {
        return mDaoSession;
    }
}
