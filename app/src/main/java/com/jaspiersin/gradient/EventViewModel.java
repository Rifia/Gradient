package com.jaspiersin.gradient;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;

import java.util.List;

public class EventViewModel extends AndroidViewModel {
    private AppRepository mRepository;
    private LiveData<List<Event>> mAllEvents;

    public EventViewModel(Application application){
        super(application);
        mRepository = new AppRepository(application);
        mAllEvents = mRepository.getAllEvents();
    }

    public LiveData<List<Event>> getAllEvents(){
        return mAllEvents;
    }

    public void insert(Event event){
        mRepository.insert(event);
    }
}
