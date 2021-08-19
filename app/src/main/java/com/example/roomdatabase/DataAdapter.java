package com.example.roomdatabase;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.DataViewHolder> {
    Context ct;
    List<Student> studentsList;
    public DataAdapter(MainActivity mainActivity, List<Student> students) {
    ct = mainActivity;
    studentsList = students;
    }

    @NonNull
    @Override
    public DataViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new DataViewHolder(LayoutInflater.from(ct).inflate(R.layout.design,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull DataViewHolder holder, int position) {
        Student student = studentsList.get(position);
        holder.tv.setText(student.getStudentID() + "\n"
        +student.getName() +"\n"+ student.getMailID() +"\n" + student.getPhoneNumber() +"\n"
        + student.getGender() + "\n" + student.getLanguage() + "\n" +student.getDepertment() +"\n");
    }

    @Override
    public int getItemCount() {
        return studentsList.size();
    }

    public class DataViewHolder extends RecyclerView.ViewHolder {
        TextView tv;
        public DataViewHolder(@NonNull View itemView) {
            super(itemView);
            tv = itemView.findViewById(R.id.data);
        }
    }
}
