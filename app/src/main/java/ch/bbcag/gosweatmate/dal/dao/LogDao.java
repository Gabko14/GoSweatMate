package ch.bbcag.gosweatmate.dal.dao;

import androidx.room.Dao;
import androidx.room.Query;

import java.util.List;

import ch.bbcag.gosweatmate.dal.entities.Log;


@Dao
public interface LogDao {
    @Query("SELECT * FROM log")
    List<Log> getAll();
}
