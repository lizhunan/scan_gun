package com.ctrl.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.ctrl.bean.TracePoint;

import java.util.List;

/**
 * Created by lizhunan on 2020/3/5
 */
@Dao
public interface TracePointDao {

    @Query("SELECT * FROM tracepoint")
    List<TracePoint> selectAll();

    @Query("SELECT * FROM tracepoint LIMIT 200 OFFSET :index")
    List<TracePoint> selectBlack(int index);

    @Insert
    void insertAll(List<TracePoint> points);

    @Insert
    void insert(TracePoint... point);

    @Delete()
    void delete(TracePoint... points);

    @Query("DELETE FROM tracepoint")
    void deleteAll();
}
