package com.jaspiersin.gradient;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;


@Entity(tableName = "events")
public class Event {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    private int mId;

    @ColumnInfo(name = "note")
    private String mNote;

    @ColumnInfo(name = "rating")
    private String mRating;

    @ColumnInfo(name = "date")
    private String mDate;

    public Event(@NonNull String mNote, @NonNull String mRating, String mDate) {
        this.mNote = mNote;
        this.mRating = mRating;
        this.mDate = mDate;
    }

    public int getId() {
        return mId;
    }

    public void setId(int mId) {
        this.mId = mId;
    }

    public String getNote() {
        return mNote;
    }

    public String getRating() {
        return mRating;
    }

    public String getDate() {
        return mDate;
    }

    public void setDate(String mDate) {
        this.mDate = mDate;
    }
}
