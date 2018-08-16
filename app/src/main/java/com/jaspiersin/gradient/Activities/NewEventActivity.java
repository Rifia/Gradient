package com.jaspiersin.gradient.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.jaspiersin.gradient.R;

public class NewEventActivity extends AppCompatActivity {
    public static final String EXTRA_REPLY = "com.example.android.wordlistsql.REPLY";

    private EditText mEditEventView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_event);
        mEditEventView = findViewById(R.id.edit_event);
        final Button button = findViewById(R.id.button_save);

        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent replyIntent = new Intent();
                if (TextUtils.isEmpty(mEditEventView.getText())) {
                    setResult(RESULT_CANCELED, replyIntent);
                } else {
                    String event = mEditEventView.getText().toString();
                    replyIntent.putExtra(EXTRA_REPLY, event);
                    setResult(RESULT_OK, replyIntent);
                }
                finish();
            }
        });
    }
}
