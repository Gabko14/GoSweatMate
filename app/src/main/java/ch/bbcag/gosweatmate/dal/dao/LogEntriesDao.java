package ch.bbcag.gosweatmate.dal.dao;

import androidx.room.Dao;
import androidx.room.Query;

import java.util.List;

import ch.bbcag.gosweatmate.dal.entities.Workout;

@Dao
public interface LogEntriesDao {
    @Query("SELECT * FROM log_entries")
    List<Workout> getAll();

    @Query("SELECT * FROM log_entries le WHERE le.log_id=:id")
    List<Workout> getAllByLogId(long id);
}
