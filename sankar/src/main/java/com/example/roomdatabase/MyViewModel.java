package com.example.roomdatabase;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class MyViewModel extends AndroidViewModel {

    public LiveData<List<Student>> studentData;
    public LiveData<List<Faculty>> facultyData;
    MyRepository repository;

    public MyViewModel(@NonNull Application application) {
        super(application);
        repository = new MyRepository(application);
        studentData = repository.readStudent();
        facultyData = repository.readFaculty();

    }


    public void insertStudent(Student student){
        repository.insertStudent(student);
    }

    public void insertFaculty(Faculty faculty){
        repository.insertFaculty(faculty);
    }

    public LiveData<List<Student>> readStudent(){
        return studentData;
    }
    public LiveData<List<Faculty>> readFaculty(){
        return facultyData;
    }

}
