package com.jaspiersin.gradient;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import static com.jaspiersin.gradient.Resources.textContent;

public class NoteActivity extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note);

        final EditText note = findViewById(R.id.note);
        final Button next = findViewById(R.id.next_button);



        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent a = new Intent(NoteActivity.this, RatingActivity.class);
                textContent = note.getText().toString();

                startActivity(a);
            }
        });




    }

}
