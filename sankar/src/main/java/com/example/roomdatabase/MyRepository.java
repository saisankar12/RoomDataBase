package com.example.roomdatabase;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

public class MyRepository {

    public LiveData<List<Student>> studentData;
    public LiveData<List<Faculty>> facultyData;

    public MyDataBase myDataBase;

    public MyRepository(Application application) {
        myDataBase = MyDataBase.getDataBase(application);
        studentData = myDataBase.myDao().readStudent();
        facultyData = myDataBase.myDao().readFaculty();
    }

    public void insertStudent(Student student){
        myDataBase.databaseWriteExecuter.execute(new Runnable() {
            @Override
            public void run() {
                myDataBase.myDao().InsertStudent(student);
            }
        });

    }

    public void insertFaculty(Faculty faculty){
        myDataBase.databaseWriteExecuter.execute(new Runnable() {
            @Override
            public void run() {
                myDataBase.myDao().InsertFaculty(faculty);
            }
        });
    }

    public LiveData<List<Student>> readStudent(){
        return studentData;
    }
    public LiveData<List<Faculty>> readFaculty(){
        return facultyData;
    }
}
