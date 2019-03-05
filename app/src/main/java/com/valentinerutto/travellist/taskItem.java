package com.valentinerutto.travellist;

import java.io.Serializable;
import java.util.HashMap;

public class taskItem implements Serializable {
private String task,country,date;
    public taskItem() {

    }

    public String getDate() {
        return date;
    }

    public String getCountry() {
        return country;
    }

    public String getTask() {
        return task;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public HashMap<String,String> toFirebaseObject(){
        HashMap<String,String> todo = new HashMap<String, String>();
        todo.put("task",task);
        return todo;
    }

}
