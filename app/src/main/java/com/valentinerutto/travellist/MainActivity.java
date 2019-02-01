package com.valentinerutto.travellist;

import android.os.Bundle;
import android.support.design.bottomappbar.BottomAppBar;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        BottomAppBar bottomAppBar = findViewById(R.id.fab);
//        bottomAppBar.replaceMenu(R.menu.menu);
//        bottomAppBar.setNavigationOnClickListener{
//            // do something interesting on navigation click
//        }

    }
}