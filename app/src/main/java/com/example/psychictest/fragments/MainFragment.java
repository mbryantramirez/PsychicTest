package com.example.psychictest.fragments;


import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.psychictest.R;


public class MainFragment extends Fragment {
    private Spinner spinner;
    private String selection;


    public MainFragment() {
        // Required empty public constructor
    }

    public static MainFragment newInstace(){
        return new MainFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(
                R.layout.fragment_main,
                container,
                false);

        Button button = rootView.findViewById(R.id.submit_button);

        spinner = rootView.findViewById(R.id.theme_spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                rootView.getContext(),
                R.array.spinner_list,
                 android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item );
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0:
                        Log.d("TAG", parent.getItemAtPosition(position).toString());
                        selection = parent.getItemAtPosition(position).toString();
                        break;
                    case 1:
                        Log.d("TAG", parent.getItemAtPosition(position).toString());
                        selection = parent.getItemAtPosition(position).toString();
                        break;
                    case 2:
                        Log.d("TAG", parent.getItemAtPosition(position).toString());
                        selection = parent.getItemAtPosition(position).toString();
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment, ChoiceFragment.newInstance(selection.toLowerCase()))
                        .addToBackStack(null)
                        .commit();
            }
        });




        Log.d("TAG", spinner.getSelectedItem().toString());
        return rootView;
    }


}
