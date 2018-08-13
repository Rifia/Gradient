package com.jaspiersin.gradient;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "events")
public class Event {
    @PrimaryKey
    private int uid;

    @ColumnInfo(name = "note")
    private String note;

    @ColumnInfo(name = "rating")
    private String rating;

    public Event(){}

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "Event{" +
                "uid=" + uid +
                ", note='" + note + '\'' +
                ", rating=" + rating +
                '}';
    }
}
