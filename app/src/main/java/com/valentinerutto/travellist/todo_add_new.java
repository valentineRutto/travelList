package com.valentinerutto.travellist;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;

public class todo_add_new extends AppCompatActivity {
    FloatingActionButton fab;
    EditText task,taskdate;
    Spinner country;
    DatePicker datePicker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_todo_add_new);
   fab = findViewById(R.id.fab_Add);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveTodo();
            }
        });
    }

    private void saveTodo() {
        task=findViewById(R.id.task_name);
        taskdate=findViewById(R.id.task_date);
//        make datepicker visible on taskdateclick
        datePicker=findViewById(R.id.datepicker);



    }

}
