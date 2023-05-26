package ch.bbcag.gosweatmate.dal.dao;

import androidx.room.Dao;
import androidx.room.Query;

import java.util.List;

import ch.bbcag.gosweatmate.dal.entities.LogEntries;

@Dao
public interface LogEntriesDao {
    @Query("SELECT * FROM log_entries")
    List<LogEntries> getAll();

    @Query("SELECT * FROM log_entries le WHERE le.log_id=:id")
    List<LogEntries> getAllByLogId(long id);
}
