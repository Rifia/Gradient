package com.jaspiersin.gradient.Database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.jaspiersin.gradient.DAO.EventDao;
import com.jaspiersin.gradient.Entities.Event;

@Database(entities = {Event.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {

    public  abstract EventDao eventDao();

    private static AppDatabase INSTANCE;


    public static AppDatabase getAppDatabase(Context context) {
        if (INSTANCE == null) {
            INSTANCE =
                    Room.databaseBuilder(context.getApplicationContext(),
                            AppDatabase.class, "events").allowMainThreadQueries().build();
            //вынеси потом в отдельный поток
        }
        return INSTANCE;
    }

//    public static void destroyInstance() {
//        INSTANCE = null;
//    }


}
