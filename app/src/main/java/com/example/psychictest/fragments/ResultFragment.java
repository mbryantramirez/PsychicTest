package com.example.psychictest.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.psychictest.MainActivity;
import com.example.psychictest.R;

public class ResultFragment extends Fragment {
    private static final String RESULT_PARAM = "result";
    private String result;
    private int right_guesses;
    private int click_counts;

    public ResultFragment() {
        // Required empty public constructor
    }

    public static ResultFragment newInstance(String result, int click_counts, int right_guesses) {
        ResultFragment fragment = new ResultFragment();
        Bundle args = new Bundle();
        args.putString(RESULT_PARAM, result);
        args.putInt(MainActivity.CLICK_COUNT, click_counts);
        args.putInt(MainActivity.RIGHT_GUESSES, right_guesses);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            result = getArguments().getString(RESULT_PARAM);
            click_counts = getArguments().getInt(MainActivity.CLICK_COUNT);
            right_guesses = getArguments().getInt(MainActivity.RIGHT_GUESSES);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_result, container, false);

        TextView resultView = rootView.findViewById(R.id.result);
        TextView averageView = rootView.findViewById(R.id.average);

        float average;
        if(click_counts > 0 || right_guesses > 0){
            average =  (float) right_guesses / (float) click_counts;
        }else{
            average = 0;
        }
        String average1 = "Average " + average * 100 + "%";

        averageView.setText(average1);
        resultView.setText(result);

        return rootView;
    }

}
