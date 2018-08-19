package com.jaspiersin.gradient;


import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import java.util.List;

public class AppRepository {

    private EventDao mEventDao;
    private LiveData<List<Event>> mAllEvents;

    public AppRepository(Application application) {
        AppDatabase db = AppDatabase.getDatabase(application);
        mEventDao = db.eventDao();
        mAllEvents = mEventDao.getAllEvents();
    }

    public void insert(Event event){
        new insertAsyncTask(mEventDao).execute(event);
    }

    public void delete(Event event){
        new deleteAsyncTask(mEventDao).execute(event);
    }

    public LiveData<List<Event>> getAllEvents(){
        return mAllEvents;
    }

    public void deleteAll(){
        new deleteAllEventsAsyncTask(mEventDao).execute();
    }





    private class insertAsyncTask extends AsyncTask<Event, Void, Void> {

        public insertAsyncTask(EventDao mEventDao) {
        }

        @Override
        protected Void doInBackground(final Event... events) {

            mEventDao.insert(events[0]);
            return null;
        }
    }

    private class deleteAsyncTask extends AsyncTask<Event, Void, Void> {

        public deleteAsyncTask(EventDao mEventDao) {
        }

        @Override
        protected Void doInBackground(final Event... events) {

            mEventDao.delete(events[0]);
            return null;
        }
    }

    private static class deleteAllEventsAsyncTask extends AsyncTask<Void, Void, Void> {
        private EventDao mAsyncTaskDao;

        deleteAllEventsAsyncTask(EventDao dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            mAsyncTaskDao.deleteAll();
            return null;
        }
    }




}
