package com.jaspiersin.gradient.Views;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import com.jaspiersin.gradient.Entities.Event;
import com.jaspiersin.gradient.Repository.AppRepository;

import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class EventViewModel extends AndroidViewModel {
    private AppRepository appRepository = new AppRepository(this.getApplication());
    private final Executor executor = Executors.newFixedThreadPool(2);

    public EventViewModel(@NonNull Application application){
        super(application);
    }

    public void addEvent(final Event p){
        executor.execute(new Runnable() {
            @Override
            public void run() {
                appRepository.addEvent(p);
            }
        });
    }

    public LiveData<List<Event>> getAllEvents(){
        return appRepository.getAllEvents();
    }
}
