package ch.bbcag.gosweatmate.dal.dao;

import androidx.room.Dao;
import androidx.room.Query;

import java.util.List;

import ch.bbcag.gosweatmate.dal.entities.Workout;
import ch.bbcag.gosweatmate.dal.entities.WorkoutHasExercise;

@Dao
public interface WorkoutHasExerciseDao {

//    @Query("SELECT w.name, e.name FROM workout_has_exercise whs JOIN workout w ON whs.workoutId=w.id JOIN exercise e ON whs.exerciseId=e.id")
//    List<WorkoutHasExercise> getAllWithJoins();

    @Query("SELECT w.name, whs.exerciseId FROM workout_has_exercise whs JOIN workout w ON whs.workoutId=w.id")
    List<WorkoutHasExercise> getAllWithWorkoutJoins();

    @Query("SELECT * FROM workout_has_exercise whs")
    List<WorkoutHasExercise> getAll();
}
