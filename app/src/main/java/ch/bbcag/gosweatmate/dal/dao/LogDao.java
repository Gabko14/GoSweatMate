package ch.bbcag.gosweatmate.dal.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

import ch.bbcag.gosweatmate.dal.entities.Log;


@Dao
public interface LogDao {
    @Query("SELECT * FROM log")
    List<Log> getAll();

    @Insert
    void insertAll(Log... logs);

    @Delete
    void delete(Log logs);
}
