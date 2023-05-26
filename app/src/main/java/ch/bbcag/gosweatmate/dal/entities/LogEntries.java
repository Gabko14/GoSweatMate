package ch.bbcag.gosweatmate.dal.entities;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.sql.Time;
import java.sql.Timestamp;

@Entity(tableName = "log_entries")
public class LogEntries {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    private long id;

    @ColumnInfo(name = "log_id")
    private long logId;

    @ColumnInfo(name = "workout_has_exercise_id")
    private long workoutHasExerciseId;

    @ColumnInfo(name = "set_number")
    private long setNumber;

    @ColumnInfo(name = "weight")
    private long weight;

    @ColumnInfo(name = "repetitions")
    private long repetitions;

    @ColumnInfo(name = "time_recorded")
    private Timestamp timeRecorded;

}
