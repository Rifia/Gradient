package com.jaspiersin.gradient.Database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.jaspiersin.gradient.DAO.EventDao;
import com.jaspiersin.gradient.Entities.Event;

@Database(entities = {Event.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public  abstract EventDao eventDao();
}
