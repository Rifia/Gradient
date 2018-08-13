package com.jaspiersin.gradient.Activities;

import android.arch.lifecycle.LifecycleActivity;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.jaspiersin.gradient.Event;
import com.jaspiersin.gradient.R;
import com.jaspiersin.gradient.EventViewModel;

import java.util.List;

import static com.jaspiersin.gradient.Resources.rateContent;
import static com.jaspiersin.gradient.Resources.textContent;

public class MainActivity extends LifecycleActivity {
    private EventViewModel eventViewModel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        eventViewModel = ViewModelProviders.of(this).get(EventViewModel.class);
        final Button add = findViewById(R.id.add);


        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addPerson(view);
            }
        });
    }

    private void observerEventListResults(LiveData<List<Event>> eventsLive) {
        //observer LiveData
        eventsLive.observe(this, new Observer<List<Event>>() {
            @Override
            public void onChanged(@Nullable List<Event> event) {
                if(event == null){
                    return;
                }
                Toast.makeText(MainActivity.this, "Number of event objects in the response: "+event.size(), Toast.LENGTH_LONG).show();
            }
        });
    }

    public void getAllEvets(View view){
        LiveData<List<Event>> allEvents = eventViewModel.getAllEvents();
        observerEventListResults(allEvents);
    }

    public void addPerson(View view){
        if(textContent == null){
            Toast.makeText(this, "Please enter text", Toast.LENGTH_LONG).show();
            return;
        }
        eventViewModel.addEvent(createEvent());
    }
    private Event createEvent(){
        Event p = new Event();
        p.setNote(textContent);
        p.setRating(rateContent);
        return  p;
    }

}
