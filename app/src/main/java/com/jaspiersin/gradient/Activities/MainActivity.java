package com.jaspiersin.gradient.Activities;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;

import com.jaspiersin.gradient.Database.AppDatabase;
import com.jaspiersin.gradient.Entities.Event;
import com.jaspiersin.gradient.R;

import static com.jaspiersin.gradient.Resources.rateContent;
import static com.jaspiersin.gradient.Resources.textContent;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        final Button add = findViewById(R.id.add);
        final AppDatabase appDatabase = AppDatabase.getInstance(MainActivity.this);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Event event = new Event(textContent, Integer.valueOf(rateContent));


            }
        });
    }
}
