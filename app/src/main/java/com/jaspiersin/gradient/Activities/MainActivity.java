package com.jaspiersin.gradient.Activities;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.jaspiersin.gradient.R;

import static com.jaspiersin.gradient.Resources.rateContent;
import static com.jaspiersin.gradient.Resources.textContent;

public class MainActivity extends Activity {
    class Item{
        String note;
        int rating;

        Item(String note, int rating) {
            this.note = note;
            this.rating = rating;
        }
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        final Button add = findViewById(R.id.add);
        final ListView items =  findViewById(R.id.items);
        final ItemsAdapter adapter = new ItemsAdapter();
        items.setAdapter(adapter);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                adapter.add(new Item(textContent, Integer.valueOf(rateContent)));
            }
        });

      }
      private class ItemsAdapter extends ArrayAdapter<Item> {
        public ItemsAdapter() {
            super(MainActivity.this, R.layout.item);
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            final View view = getLayoutInflater().inflate(R.layout.item, null);
            final Item item = getItem(position);
            ((TextView) view.findViewById(R.id.note)).setText(item.note);
            ((TextView) view.findViewById(R.id.rating)).setText(String.valueOf(item.rating));
            return view;
        }
    }
}
