package com.example.realmex

import android.app.Application
import android.database.sqlite.SQLiteOpenHelper
import io.realm.Realm
import io.realm.RealmConfiguration

class MyApplication : Application()
{
    override fun onCreate()
    {
        super.onCreate()
        Realm.init(this)
        var configuration=RealmConfiguration.Builder()
            .name("user.db")
            .schemaVersion(1)
            .deleteRealmIfMigrationNeeded()
            .build()

        Realm.setDefaultConfiguration(configuration)
    }

}