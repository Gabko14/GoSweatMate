package ch.bbcag.gosweatmate.dal.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;


import ch.bbcag.gosweatmate.dal.dao.LogDao;
import ch.bbcag.gosweatmate.dal.dao.LogEntriesDao;
import ch.bbcag.gosweatmate.dal.dao.WorkoutDao;
import ch.bbcag.gosweatmate.dal.dao.WorkoutHasExerciseDao;
import ch.bbcag.gosweatmate.dal.entities.Exercise;
import ch.bbcag.gosweatmate.dal.entities.Log;
import ch.bbcag.gosweatmate.dal.entities.LogEntries;
import ch.bbcag.gosweatmate.dal.entities.Workout;
import ch.bbcag.gosweatmate.dal.entities.WorkoutHasExercise;

@Database(entities = {Exercise.class, Workout.class, WorkoutHasExercise.class, Log.class, LogEntries.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    private static AppDatabase INSTANCE;

    public static synchronized AppDatabase getInstance(Context context) {
        if (INSTANCE == null) {
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(), AppDatabase.class, "AppDatabase")
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return INSTANCE;
    }

    public abstract WorkoutDao getWorkoutDao();
    public abstract WorkoutHasExerciseDao getWorkoutHasExerciseDao();
    public abstract LogDao getLogDao();
    public abstract LogEntriesDao getLogEntriesDao();
}