package ch.bbcag.gosweatmate.dal.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

import ch.bbcag.gosweatmate.dal.entities.LogEntrie;

@Dao
public interface LogEntriesDao {
    @Query("SELECT * FROM log_entrie")
    List<LogEntrie> getAll();

    @Query("SELECT * FROM log_entrie le WHERE le.log_id=:id")
    List<LogEntrie> getAllByLogId(long id);

    @Insert
    void insertAll(LogEntrie... logentries);

    @Delete
    void delete(LogEntrie logentries);
}
