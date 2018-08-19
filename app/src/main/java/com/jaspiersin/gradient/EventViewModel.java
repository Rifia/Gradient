package com.jaspiersin.gradient;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import java.util.List;

public class EventViewModel extends AndroidViewModel {

    private AppRepository mRepository;
    private LiveData<List<Event>> mEvents;

    public EventViewModel(@NonNull Application application){
        super(application);
        mRepository = new AppRepository(application);
        mEvents = mRepository.getAllEvents();
    }

    public LiveData<List<Event>> getAllEvents(){
        return mEvents;
    }

    public void insert(Event event){
        mRepository.insert(event);
    }

    public void delete(Event event){
        mRepository.delete(event);
    }

    public void deleteAll(){mRepository.deleteAll();}
}
