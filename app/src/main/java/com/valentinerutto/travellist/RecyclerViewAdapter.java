//package com.valentinerutto.travellist;
//
//import android.content.Context;
//import android.support.annotation.NonNull;
//import android.support.v7.widget.RecyclerView;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.EditText;
//import android.widget.TextView;
//
//import java.util.ArrayList;
//
//public class RecyclerViewAdapter  extends RecyclerView.Adapter {
//    ArrayList<taskItem> tasklist;
//    protected Context context;
////    public RecyclerViewAdapter(Context context, ArrayList<taskItem> tasklist) {
////        this.tasklist = tasklist;
////        this.context = context;
////    }
//    @NonNull
//    @Override
//    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
//
//        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.todo_row, viewGroup, false);
//        SimpleItemViewHolder pvh = new SimpleItemViewHolder(v);
//        return pvh;
//    }
//
//
//    @Override
//    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
//        SimpleItemViewHolder viewHolder = (SimpleItemViewHolder) holder;
//        viewHolder.position = position;
//        taskItem todo = tasklist.get(position);
//        ((SimpleItemViewHolder) holder).title.setText(todo.getTask());
//    }
//
//    public final  class SimpleItemViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
//        TextView title,date,task;
//        public int position;
//        public SimpleItemViewHolder(View itemView) {
//            super(itemView);
//            itemView.setOnClickListener(this);
//            title = (TextView) itemView.findViewById(R.id.country);
//            task = (TextView) itemView.findViewById(R.id.task);
//            date = (TextView) itemView.findViewById(R.id.date);
//        }
//
//        @Override
//        public void onClick(View view) {
//
//        }}
//
//    @Override
//    public int getItemCount() {
//        return tasklist.size();
//    }
//}

