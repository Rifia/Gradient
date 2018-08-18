package com.jaspiersin.gradient;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.jaspiersin.gradient.Activities.R;

import java.util.List;

public class EventListAdapter extends RecyclerView.Adapter<EventListAdapter.EventViewHolder>{

    private List<Event> mEvents;

    public EventListAdapter(@NonNull List<Event> events){
        mEvents = events;
    }

    @Override
    public EventViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView = inflater.inflate(R.layout.item_event, parent, false);
        return new EventViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(EventViewHolder holder, int position) {

        holder.eventNote.setText(mEvents.get(position).getNote());
        holder.eventRating.setText(mEvents.get(position).getRating());
        holder.eventDate.setText(mEvents.get(position).getDate());
    }

    @Override
    public int getItemCount(){
        return mEvents.size();
    }

    public void setEvents(List<Event> events){
        mEvents = events;
        notifyDataSetChanged();
    }

    class EventViewHolder extends RecyclerView.ViewHolder{
        private TextView eventNote;
        private TextView eventRating;
        private TextView eventDate;

        private EventViewHolder(View itemView){
            super(itemView);
            eventNote = itemView.findViewById(R.id.tv_note);
            eventRating = itemView.findViewById(R.id.tv_rating);
            eventDate = itemView.findViewById(R.id.tv_date);
        }
    }

}
