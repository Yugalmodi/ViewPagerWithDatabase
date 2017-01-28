package com.techpalle.viewpagerwithdatabaseexample;


import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SimpleCursorAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentTwo extends Fragment {
    ListView listView;
    Cursor cursor;
    SimpleCursorAdapter simpleCursorAdapter;

    public FragmentTwo() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_fragment_two, container, false);
        listView = (ListView) v.findViewById(R.id.list_view);
        MainActivity mainActivity = (MainActivity) getActivity();
        cursor = mainActivity.myDatabase.queryStudent();
        simpleCursorAdapter  = new SimpleCursorAdapter(getActivity(),R.layout.row1, cursor,
                new String[]{"_id", "name", "subject", "email"},
                new int[]{R.id.text_view_no1, R.id.text_view_name1, R.id.text_view_subject1, R.id.text_view_email1});
        listView.setAdapter(simpleCursorAdapter);
        return v;
    }
}
