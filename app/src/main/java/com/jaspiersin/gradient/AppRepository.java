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

    public LiveData<List<Event>> getAllEvents(){
        return mAllEvents;
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


}
