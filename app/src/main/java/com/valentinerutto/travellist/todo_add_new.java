package com.valentinerutto.travellist;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;

import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class todo_add_new extends AppCompatActivity {
    FloatingActionButton fab;
    EditText task,taskdate,taskcountry;
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

    void saveTodo() {
        task=findViewById(R.id.task_name);
        taskdate=findViewById(R.id.task_date);
        taskcountry =findViewById(R.id.task_country);
//        make datepicker visible on taskdateclick
        datePicker=findViewById(R.id.datepicker);
        Date date =new Date();
        date.setMonth(datePicker.getMonth());
        date.setYear(datePicker.getYear());
        date.setDate(datePicker.getDayOfMonth());

        SimpleDateFormat format =new SimpleDateFormat("dd/MM/yyyy");
        String dateString = format.format(date);

//        save to firebase Db
        FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
        String key = firebaseDatabase.getReference("todoList").push().getKey();

        taskItem taskItem=new taskItem();
        taskItem.setCountry(taskcountry.getText().toString());
        taskItem.setTask(task.getText().toString());
        taskItem.setTask(dateString);


        Map<String,Object> childUpdates = new HashMap<>();
        childUpdates.put(key,taskItem.toFirebaseObject());
        firebaseDatabase.getReference("todoList").updateChildren(childUpdates, new DatabaseReference.CompletionListener() {
            @Override
            public void onComplete(@Nullable DatabaseError databaseError, @NonNull DatabaseReference databaseReference) {
                if (databaseError == null){
                    finish();
                }
            }
        });



    }

}
