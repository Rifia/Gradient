package com.jaspiersin.gradient.Activities;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.jaspiersin.gradient.DateTimeFormats;
import com.jaspiersin.gradient.Event;
import com.jaspiersin.gradient.EventViewModel;

import java.util.Date;

public class NewEventActivity extends AppCompatActivity {

    private EventViewModel mEventViewModel;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_event);

        mEventViewModel = ViewModelProviders.of(this).get(EventViewModel.class);
        final EditText note = findViewById(R.id.et_note);
        final TextView rating = findViewById(R.id.current_value);
        final SeekBar seekBar = findViewById(R.id.seekBar);


        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                rating.setText(String.valueOf(seekBar.getProgress()));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        findViewById(R.id.btn_add).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    if (!note.getText().toString().trim().isEmpty() /*&& !rating.getText().toString().trim().isEmpty()*/) {
//                        if(Integer.valueOf(rating.getText().toString().trim()) <= 100 &&
//                                Integer.valueOf(rating.getText().toString().trim()) >= 0 ) {

                        String noteString = note.getText().toString().trim();

                        if(rating.getText().toString().trim().isEmpty()) {
                            noteString = "50";
                        }

                        String ratingString = rating.getText().toString().trim();
                        String dateString = DateTimeFormats.shortFormat24h.format(new Date());

                        Event event = new Event(noteString, ratingString, dateString);
                        mEventViewModel.insert(event);
                        finish();
//                    } else {
//                        Toast.makeText(getApplicationContext(), "Rating diapason should be from 0 to 100", Toast.LENGTH_SHORT).show();
//                    }
            } else {
                   Toast.makeText(getApplicationContext(), R.string.empty_note_toast, Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
