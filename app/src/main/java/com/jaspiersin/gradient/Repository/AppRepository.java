package com.jaspiersin.gradient.Repository;


import android.arch.lifecycle.LiveData;
import android.content.Context;
import android.util.Log;

import com.jaspiersin.gradient.DAO.EventDao;
import com.jaspiersin.gradient.DBCreator.DatabaseCreator;
import com.jaspiersin.gradient.Entities.Event;

import java.util.List;

public class AppRepository {

    private final EventDao eventDao;

    public AppRepository(Context context){
        eventDao = DatabaseCreator.getAppDatabase(context).eventDatabase();
    }

    public void addEvent(Event p){
        eventDao.insert(p);
    }
    public LiveData<List<Event>> getAllEvents(){
        return eventDao.getAll();
    }

}
