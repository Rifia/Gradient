package com.jaspiersin.gradient;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface EventDao {

    @Query("SELECT * FROM events")
    LiveData<List<Event>> getAll();

//    @Query("SELECT * FROM events WHERE note LIKE :note and rating LIKE :rating")
//    Event findByNote(String note, int rating);

//    @Query("SELECT COUNT(*) FROM events")
//    int countEvents();

    @Insert
    void insert(Event event);

//    @Delete
//    void delete(Event event);

}
