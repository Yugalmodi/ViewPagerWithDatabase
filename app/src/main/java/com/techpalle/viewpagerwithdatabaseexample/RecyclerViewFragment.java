package com.techpalle.viewpagerwithdatabaseexample;


import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class RecyclerViewFragment extends Fragment {
    RecyclerView  recyclerView;
    Cursor cursor;
    ArrayList<Student> al;
    MyAdapter myAdapter;
    Student student;

    public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder>{
        public MyAdapter(){
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View v = getActivity().getLayoutInflater().inflate(R.layout.row1, parent, false);
            ViewHolder viewHolder = new ViewHolder(v);
            return viewHolder;
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            student = al.get(position);
            holder.textViewID.setText(student.getId());
            holder.textViewName.setText(student.getName());
            holder.textViewSubject.setText(student.getSubject());
            holder.textViewEmail.setText(student.getEmail());
        }

        @Override
        public int getItemCount() {
            return al.size();
        }

        public class ViewHolder extends RecyclerView.ViewHolder {
            public TextView textViewID, textViewName, textViewSubject, textViewEmail;
            public ViewHolder(View itemView) {
                super(itemView);
                textViewID = (TextView) itemView.findViewById(R.id.text_view_no1);
                textViewName = (TextView) itemView.findViewById(R.id.text_view_name1);
                textViewSubject = (TextView) itemView.findViewById(R.id.text_view_subject1);
                textViewEmail = (TextView) itemView.findViewById(R.id.text_view_email1);
            }
        }
    }

    public RecyclerViewFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_recycler_view, container, false);
        recyclerView = (RecyclerView) v.findViewById(R.id.recycle_view);
        al = new ArrayList<Student>();
        MainActivity mainActivity = (MainActivity) getActivity();
        cursor = mainActivity.myDatabase.queryStudent();
        if(cursor!=null){
            while(cursor.moveToNext()){
                student = new Student();
                student.setId(String.valueOf(cursor.getInt(cursor.getColumnIndex("_id"))));
                student.setName(cursor.getString(cursor.getColumnIndex("name")));
                student.setSubject(cursor.getString(cursor.getColumnIndex("subject")));
                student.setEmail(cursor.getString(cursor.getColumnIndex("email")));
                al.add(student);
            }
        }
        myAdapter = new MyAdapter();
        recyclerView.setAdapter(myAdapter);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);
        return v;
    }
}
