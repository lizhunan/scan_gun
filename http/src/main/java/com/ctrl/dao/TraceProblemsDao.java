package com.ctrl.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.ctrl.bean.TraceProblem;

import java.util.List;

/**
 * Created by lizhunan on 2020/3/17
 */
@Dao
public interface TraceProblemsDao {

    @Query("SELECT * FROM traceproblem")
    List<TraceProblem> selectAll();

    @Insert
    void insert(TraceProblem... traceProblems);

    @Delete
    void delete(TraceProblem... traceProblems);

    @Query("DELETE FROM traceproblem")
    void deleteAll();
}
