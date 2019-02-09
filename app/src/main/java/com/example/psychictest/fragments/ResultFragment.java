package com.example.psychictest.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.psychictest.R;

public class ResultFragment extends Fragment {
    private static final String RESULT_PARAM = "result";
    private String result;

    public ResultFragment() {
        // Required empty public constructor
    }

    public static ResultFragment newInstance(String result) {
        ResultFragment fragment = new ResultFragment();
        Bundle args = new Bundle();
        args.putString(RESULT_PARAM, result);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            result = getArguments().getString(RESULT_PARAM);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_result, container, false);

        TextView textView = rootView.findViewById(R.id.result);
        textView.setText(result);
        return rootView;
    }

}
