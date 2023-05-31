package ch.bbcag.gosweatmate.dal.dao;

import android.widget.ListView;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

import ch.bbcag.gosweatmate.dal.entities.Workout;

@Dao
public interface WorkoutDao {
    @Query("SELECT * FROM workout")
    List<Workout> getAll();

    @Insert
    long[] insertAll(Workout... workouts);
}
