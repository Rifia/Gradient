package com.jaspiersin.gradient;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import static com.jaspiersin.gradient.Resources.rateContent;

public class RatingActivity extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rating);
        final EditText rating = (EditText) findViewById(R.id.rating);
        final Button finish = (Button) findViewById(R.id.finish);
        finish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(RatingActivity.this, MainActivity.class);
                 rateContent = rating.getText().toString();
                startActivity(i);
            }
        });
    }

}
