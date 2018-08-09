package com.jaspiersin.gradient.DAO;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.jaspiersin.gradient.Entities.Event;

import java.util.List;

@Dao
public interface EventDao {

    @Query("SELECT * FROM events")
    List<Event> getAll();

    @Query("SELECT * FROM events WHERE note LIKE :note and rating LIKE :rating")
    Event findByNote(String note, int rating);

    @Query("SELECT COUNT(*) FROM events")
    int countEvents();

    @Insert
    void insertAll(Event... events);

    @Delete
    void delete(Event event);

}
