package com.jaspiersin.gradient.Activities;

import android.app.Activity;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;

import com.jaspiersin.gradient.Entities.Event;
import com.jaspiersin.gradient.R;
import com.jaspiersin.gradient.Views.EventViewModel;

import static com.jaspiersin.gradient.Resources.rateContent;
import static com.jaspiersin.gradient.Resources.textContent;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        final Button add = findViewById(R.id.add);


        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Event event = new Event(textContent, Integer.valueOf(rateContent));


            }
        });
    }
}
