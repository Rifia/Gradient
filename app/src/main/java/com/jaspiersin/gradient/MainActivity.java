package com.jaspiersin.gradient;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends Activity {
    class Item{
        String note;
        int rating;

        public Item(String note, int rating) {
            this.note = note;
            this.rating = rating;
        }
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        final EditText note = (EditText) findViewById(R.id.note);
        final EditText rating = (EditText) findViewById(R.id.rating);
        final Button add = (Button) findViewById(R.id.add);
        final ListView items = (ListView) findViewById(R.id.items);
        final ItemsAdapter adapter = new ItemsAdapter();
        items.setAdapter(adapter);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                adapter.add(new Item(note.getText().toString(), Integer.valueOf(rating.getText().toString())));

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
