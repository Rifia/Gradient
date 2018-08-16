package com.jaspiersin.gradient;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity(tableName = "events")
public class Event {

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "note")
    private String note;

    public Event(@NonNull String note) {
        this.note = note;
    }

    @NonNull
    public String getNote() {
        return note;
    }
}
