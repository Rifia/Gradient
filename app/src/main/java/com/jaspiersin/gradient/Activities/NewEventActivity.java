package com.jaspiersin.gradient.Activities;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.jaspiersin.gradient.Event;
import com.jaspiersin.gradient.EventViewModel;
import com.jaspiersin.gradient.R;

public class NewEventActivity extends AppCompatActivity {

    private EventViewModel mEventViewModel;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_event);

        mEventViewModel = ViewModelProviders.of(this).get(EventViewModel.class);
        final EditText note = findViewById(R.id.et_note);
        final EditText rating = findViewById(R.id.et_rating);

        findViewById(R.id.btn_add).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!note.getText().toString().trim().isEmpty() &&
                        !rating.toString().trim().isEmpty()){

                String noteString = note.getText().toString().trim();
                String ratingString = rating.getText().toString().trim();

                Event event = new Event(noteString, ratingString);
                mEventViewModel.insert(event);
                finish();
            } else {
                    Toast.makeText(getApplicationContext(), "Field is Empty", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
