package com.jaspiersin.gradient.Database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import android.provider.SyncStateContract;

import com.jaspiersin.gradient.DAO.EventDao;
import com.jaspiersin.gradient.Entities.Event;

@Database(entities = {Event.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {

    public  abstract EventDao eventDao();

    private static AppDatabase INSTANCE;


    public static AppDatabase getInstance(Context context) {
        if (INSTANCE == null) {
            INSTANCE = buildDatabaseInstance(context);
        }
        return INSTANCE;
    }

    public static AppDatabase buildDatabaseInstance(Context context){
        return Room.databaseBuilder(
                context, AppDatabase.class, "events")
                .allowMainThreadQueries().build();
    }

//    public static void cleanUp() {
//        INSTANCE = null;
//    }


}
