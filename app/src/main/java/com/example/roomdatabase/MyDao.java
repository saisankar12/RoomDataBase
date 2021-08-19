package com.example.roomdatabase;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface MyDao {

    @Insert
    public void InsertStudent(Student student);

    @Insert
    public void InsertFaculty(Faculty faculty);

    @Query("SELECT * FROM Student")
    public LiveData<List<Student>> readStudent();

    @Query("SELECT * FROM Faculty")
    public LiveData<List<Faculty>> readFaculty();
}
