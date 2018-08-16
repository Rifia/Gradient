package com.jaspiersin.gradient.Activities;

import android.app.Activity;
import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.RoomDatabase;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.jaspiersin.gradient.AppDatabase;
import com.jaspiersin.gradient.Event;
import com.jaspiersin.gradient.EventDao;
import com.jaspiersin.gradient.EventListAdapter;
import com.jaspiersin.gradient.R;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        RecyclerView recyclerView = findViewById(R.id.items);
        final EventListAdapter adapter = new EventListAdapter(this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }


}
