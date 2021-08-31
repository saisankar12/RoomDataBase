package com.example.roomdatabase;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Faculty {

    @PrimaryKey @NonNull
    String FacultyID;
    String Name;
    String MailID;
    String PhoneNumber;
    String Depertment;
    String language;
    String gender;

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @NonNull
    public String getFacultyID() {
        return FacultyID;
    }

    public void setFacultyID(@NonNull String facultyID) {
        FacultyID = facultyID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getMailID() {
        return MailID;
    }

    public void setMailID(String mailID) {
        MailID = mailID;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        PhoneNumber = phoneNumber;
    }

    public String getDepertment() {
        return Depertment;
    }

    public void setDepertment(String depertment) {
        Depertment = depertment;
    }
}
