package com.jaspiersin.gradient.Utils;

import com.jaspiersin.gradient.Database.AppDatabase;
import com.jaspiersin.gradient.Entities.Event;

public class DatabaseInitializer {

    private static Event addEvent(final AppDatabase db, Event event) {
        db.eventDao().insertAll(event);
        return event;
    }

}
