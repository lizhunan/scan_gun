package com.ctrl.db;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.ctrl.bean.TracePoint;
import com.ctrl.bean.TraceProblem;
import com.ctrl.dao.TracePointDao;
import com.ctrl.dao.TraceProblemsDao;
import com.ctrl.dao.UserDao;

/**
 * Created by lizhunan on 2020/3/5
 */
@Database(entities = {TracePoint.class, TraceProblem.class}, version = 1)
public abstract class UserDatabase extends RoomDatabase {

    public abstract TracePointDao tracePointDao();

    public abstract TraceProblemsDao traceProblemsDao();

    public abstract UserDao userDao();

}
