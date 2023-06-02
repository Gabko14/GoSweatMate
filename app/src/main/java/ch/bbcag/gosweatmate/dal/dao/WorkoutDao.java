package ch.bbcag.gosweatmate.dal.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

import ch.bbcag.gosweatmate.dal.entities.Workout;

@Dao
public interface WorkoutDao {
    @Query("SELECT * FROM workout")
    List<Workout> getAll();

    @Query("SELECT * FROM workout w WHERE w.id=:id")
    Workout getById(int id);

    @Query("DELETE FROM workout WHERE workout.id = :id")
    void deleteById(int id);

    @Insert
    void insertAll(Workout... workouts);

    @Delete
    void delete(Workout workouts);
}
