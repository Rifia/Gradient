package com.jaspiersin.gradient;


import android.arch.lifecycle.LiveData;
import android.content.Context;

import com.jaspiersin.gradient.EventDao;
import com.jaspiersin.gradient.DatabaseCreator;
import com.jaspiersin.gradient.Event;

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
