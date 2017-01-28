package com.techpalle.viewpagerwithdatabaseexample;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentOne extends Fragment {
    EditText editTextName, editTextSubject, editTextEmail;
    Button buttonSave;

    public FragmentOne() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_fragment_one, container, false);
        editTextName = (EditText) v.findViewById(R.id.edit_text_name);
        editTextSubject = (EditText) v.findViewById(R.id.edit_text_subject);
        editTextEmail = (EditText) v.findViewById(R.id.edit_text_email);
        buttonSave = (Button) v.findViewById(R.id.button_save);

        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity mainActivity = (MainActivity) getActivity();
                mainActivity.myDatabase.insertValue(editTextName.getText().toString().trim(), editTextSubject.getText().toString().trim(), editTextEmail.getText().toString().trim());
                editTextName.setText("");editTextSubject.setText("");editTextEmail.setText("");
                editTextName.requestFocus();
                Toast.makeText(getActivity(), "Data Saved", Toast.LENGTH_SHORT).show();
                mainActivity.notifyData();
            }
        });
        return v;
    }
}
