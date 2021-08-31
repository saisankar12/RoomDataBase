package com.example.roomdatabase;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;


import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {Student.class,Faculty.class}, version = 2)
public abstract class MyDataBase extends RoomDatabase {

    public static MyDataBase dataBase;

    public abstract MyDao myDao();

    static final ExecutorService databaseWriteExecuter =
            Executors.newFixedThreadPool(2);



    public static synchronized MyDataBase getDataBase(final Context context){

        if (dataBase == null){
            dataBase = Room.databaseBuilder(context,MyDataBase.class,"MYDB")
                    .fallbackToDestructiveMigration().build();
        }

        return dataBase;
    }
}
