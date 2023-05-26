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
    private String timeRecordedTimeStamp;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getLogId() {
        return logId;
    }

    public void setLogId(long logId) {
        this.logId = logId;
    }

    public long getWorkoutHasExerciseId() {
        return workoutHasExerciseId;
    }

    public void setWorkoutHasExerciseId(long workoutHasExerciseId) {
        this.workoutHasExerciseId = workoutHasExerciseId;
    }

    public long getSetNumber() {
        return setNumber;
    }

    public void setSetNumber(long setNumber) {
        this.setNumber = setNumber;
    }

    public long getWeight() {
        return weight;
    }

    public void setWeight(long weight) {
        this.weight = weight;
    }

    public long getRepetitions() {
        return repetitions;
    }

    public void setRepetitions(long repetitions) {
        this.repetitions = repetitions;
    }

    public String getTimeRecordedTimeStamp() {
        return timeRecordedTimeStamp;
    }

    public void setTimeRecordedTimeStamp(String timeRecordedTimeStamp) {
        this.timeRecordedTimeStamp = timeRecordedTimeStamp;
    }
}
