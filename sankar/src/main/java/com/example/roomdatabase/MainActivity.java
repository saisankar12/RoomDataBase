package com.example.roomdatabase;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView rv;
    FloatingActionButton fab;
    static MyViewModel myViewModel1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rv = findViewById(R.id.recycler);
        fab = findViewById(R.id.fab);
        /*MyViewModel myViewModel = new ViewModelProvider(this,
                new ViewmodelFactory(getApplication())).get(MyViewModel.class);
*/
         myViewModel1 = ViewModelProviders.of(this).get(MyViewModel.class);


        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, InsertActivity.class));
            }
        });

        myViewModel1.readStudent().observe(this, new Observer<List<Student>>() {
            @Override
            public void onChanged(List<Student> students) {
                rv.setLayoutManager(new LinearLayoutManager(MainActivity.this));
                rv.setAdapter(new DataAdapter(MainActivity.this,students));
            }
        });
        /*myViewModel1.readFaculty().observe(this, new Observer<List<Faculty>>() {
            @Override
            public void onChanged(List<Faculty> faculties) {

            }
        });*/
    }

}