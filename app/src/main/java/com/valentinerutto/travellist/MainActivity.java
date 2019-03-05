package com.valentinerutto.travellist;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.bottomappbar.BottomAppBar;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
RecyclerViewAdapter adapter;
ArrayList<taskItem> todolist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        FloatingActionButton floatingActionButton = findViewById(R.id.fab);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,todo_add_new.class);
                startActivity(intent);
            }
        });

//        bottomAppBar.replaceMenu(R.menu.menu);
//        bottomAppBar.setNavigationOnClickListener{
//            // do something interesting on navigation click
//        }
        todolist = new ArrayList<>();

        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(llm);
        adapter = new RecyclerViewAdapter();
        recyclerView.setAdapter(adapter);

        adapter.notifyDataSetChanged();
    }

    @Override
    protected void onResume() {
        super.onResume();
        FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();

        firebaseDatabase.getReference("todoList").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                todolist.clear();

                Log.w("TodoApp", "getUser:onCancelled " + dataSnapshot.toString());
                Log.w("TodoApp", "count = " + String.valueOf(dataSnapshot.getChildrenCount()) + " values " + dataSnapshot.getKey());


                for (DataSnapshot data : dataSnapshot.getChildren()){
                    taskItem task = data.getValue(com.valentinerutto.travellist.taskItem.class);
                    todolist.add(task);
                }

                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.w("TodoApp","getUser:onCancelled",databaseError.toException());
            }
        });
    }
    private class RecyclerViewAdapter  extends RecyclerView.Adapter {
        protected Context context;
        //    public RecyclerViewAdapter(Context context, ArrayList<taskItem> tasklist) {
//        this.tasklist = tasklist;
//        this.context = context;
//    }
        @NonNull
        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

            View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.recycler_view_item, viewGroup, false);
            SimpleItemViewHolder pvh = new SimpleItemViewHolder(v);
            return pvh;
        }


        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
            SimpleItemViewHolder viewHolder = (SimpleItemViewHolder) holder;
            viewHolder.position = position;
            taskItem todo = todolist.get(position);
            ((SimpleItemViewHolder) holder).country.setText(todo.getCountry());
            ((SimpleItemViewHolder) holder).date.setText(todo.getDate());
            ((SimpleItemViewHolder) holder).task.setText(todo.getTask());
        }

        public final  class SimpleItemViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
            TextView country,date,task;
            public int position;
            public SimpleItemViewHolder(View itemView) {
                super(itemView);
                itemView.setOnClickListener(this);
                country = (TextView) itemView.findViewById(R.id.txt_country);
                task = (TextView) itemView.findViewById(R.id.txt_task);
                date = (TextView) itemView.findViewById(R.id.txt_date);
            }

            @Override
            public void onClick(View view) {
                Intent newIntent = new Intent(MainActivity.this,todo_add_new.class);
                newIntent.putExtra("todo", todolist.get(position));
                MainActivity.this.startActivity(newIntent);
            }}

        @Override
        public int getItemCount() {
            return todolist.size();
        }
    }


}