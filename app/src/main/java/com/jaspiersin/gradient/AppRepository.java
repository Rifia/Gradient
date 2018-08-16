package com.jaspiersin.gradient;


import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import java.util.List;

public class AppRepository {

    private EventDao eventDao;
    private LiveData<List<Event>> allEvents;

    public LiveData<List<Event>> getAllEvents(){
        return allEvents;
    }

    public void insert(Event event){
        new insertAsyncTask(eventDao).execute(event);
    }

    private static class insertAsyncTask extends AsyncTask<Event, Void, Void> {

        private EventDao mAsyncTaskDao;

        insertAsyncTask(EventDao dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final Event... params) {
            mAsyncTaskDao.insert(params[0]);
            return null;
        }
    }

    public AppRepository(Application application) {
        AppDatabase db = AppDatabase.getDatabase(application);
        eventDao = db.eventDao();
        allEvents = eventDao.getAll();
    }
}
