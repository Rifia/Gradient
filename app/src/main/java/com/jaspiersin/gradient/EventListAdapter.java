package com.jaspiersin.gradient;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class EventListAdapter extends RecyclerView.Adapter<EventListAdapter.EventViewHolder>{

    class EventViewHolder extends RecyclerView.ViewHolder{
        private final TextView eventItemView;

        private EventViewHolder(View itemView){
            super(itemView);
            eventItemView = itemView.findViewById(R.id.textView);
        }
    }

    private final LayoutInflater mInflater;
    private List<Event> mEvents;

    public EventListAdapter(Context context){
        mInflater = LayoutInflater.from(context);
    }

    @Override
    public EventViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = mInflater.inflate(R.layout.recyclerview_item, parent, false);
        return new EventViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(EventViewHolder holder, int position) {
       // if (mEvents != null){
            Event current = mEvents.get(position);
       // }else{
            holder.eventItemView.setText(current.getNote());
       // }
    }
    public void setEvents(List<Event> events){
        mEvents = events;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount(){
        if(mEvents != null)
            return  mEvents.size();
        else return 0;
    }
}
