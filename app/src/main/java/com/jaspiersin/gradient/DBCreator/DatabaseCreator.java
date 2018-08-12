package com.jaspiersin.gradient.DBCreator;

import android.arch.persistence.room.Room;
import android.content.Context;

import com.jaspiersin.gradient.Database.AppDatabase;

public class DatabaseCreator {

    private static AppDatabase INSTANCE;
    private  static  final Object LOCK = new Object();


    public static AppDatabase getAppDatabase(Context context) {
        if (INSTANCE == null) {
            synchronized (LOCK) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context, AppDatabase.class, "events").build();
                }
            }
        }
        return INSTANCE;
    }
}
