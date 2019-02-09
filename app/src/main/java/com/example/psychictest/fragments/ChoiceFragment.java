package com.example.psychictest.fragments;


import android.media.Image;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.psychictest.MainActivity;
import com.example.psychictest.R;
import com.example.psychictest.database.PsychicTestDBHelper;
import com.example.psychictest.model.PsychicAverage;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ChoiceFragment extends Fragment {

    private static final String THEME_CHOICE = "param";
    private String themeChoice;
    private ImageView image1;
    private ImageView image2;
    private ImageView image3;
    private ImageView image4;
    private List<Integer> imageList = new ArrayList<>();
    private int choice;
    private Random random = new Random();
    private int comparison = random.nextInt(4);


    public ChoiceFragment() {
        // Required empty public constructor
    }

    public static ChoiceFragment newInstance(String themeChoice) {
        ChoiceFragment fragment = new ChoiceFragment();
        Bundle args = new Bundle();
        args.putString(THEME_CHOICE, themeChoice);
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            themeChoice = getArguments().getString(THEME_CHOICE);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
       View rootView = inflater.inflate(R.layout.fragment_choice, container, false);
       image1 = rootView.findViewById(R.id.image1);
       image2 = rootView.findViewById(R.id.image2);
       image3 = rootView.findViewById(R.id.image3);
       image4 = rootView.findViewById(R.id.image4);
       MainActivity.psychicAverage = new PsychicTestDBHelper(rootView.getContext());
       MainActivity.psychicAverage.addPsychicAverage(new PsychicAverage(MainActivity.click_count, MainActivity.right_guesses));
       themeChoiceSelector();
       choiceSelected();
       Log.d("TAG1", "click-count: " + MainActivity.click_count);
       Log.d("TAG1", "right-guesses: " + MainActivity.right_guesses);



       return rootView;
    }

    public void themeChoiceSelector(){
        switch(themeChoice){
            case "cars":
                carsImageCreator();
                break;
            case "movies":
                moviesImageCreator();
                break;
            case "places":
                placesImageCreator();
                break;
        }
    }

    public void carsImageCreator(){
        image1.setBackground(getResources().getDrawable(R.drawable.car1));
        image2.setBackground(getResources().getDrawable(R.drawable.car2));
        image3.setBackground(getResources().getDrawable(R.drawable.car3));
        image4.setBackground(getResources().getDrawable(R.drawable.car4));

        imageList.add(R.drawable.car1);
        imageList.add(R.drawable.car2);
        imageList.add(R.drawable.car3);
        imageList.add(R.drawable.car4);

        image1.setTag(R.drawable.car1);
        image2.setTag(R.drawable.car2);
        image3.setTag(R.drawable.car3);
        image4.setTag(R.drawable.car4);
    }

    public void moviesImageCreator(){
        image1.setBackground(getResources().getDrawable(R.drawable.movie1));
        image2.setBackground(getResources().getDrawable(R.drawable.movie2));
        image3.setBackground(getResources().getDrawable(R.drawable.movie3));
        image4.setBackground(getResources().getDrawable(R.drawable.movie4));

        imageList.add(R.drawable.movie1);
        imageList.add(R.drawable.movie2);
        imageList.add(R.drawable.movie3);
        imageList.add(R.drawable.movie4);

        image1.setTag(R.drawable.movie1);
        image2.setTag(R.drawable.movie2);
        image3.setTag(R.drawable.movie3);
        image4.setTag(R.drawable.movie4);
    }

    public void placesImageCreator(){
        image1.setBackground(getResources().getDrawable(R.drawable.place1));
        image2.setBackground(getResources().getDrawable(R.drawable.place2));
        image3.setBackground(getResources().getDrawable(R.drawable.place3));
        image4.setBackground(getResources().getDrawable(R.drawable.place4));

        imageList.add(R.drawable.place1);
        imageList.add(R.drawable.place2);
        imageList.add(R.drawable.place3);
        imageList.add(R.drawable.place4);

        image1.setTag(R.drawable.place1);
        image2.setTag(R.drawable.place2);
        image3.setTag(R.drawable.place3);
        image4.setTag(R.drawable.place4);
    }

    public void choiceSelected(){
        image1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choice = Integer.parseInt(image1.getTag().toString());
                MainActivity.psychicAverage.updateClickCounts(++MainActivity.click_count);

                if(choice == imageList.get(comparison)){
                    MainActivity.psychicAverage.updateRightGuesses(++MainActivity.right_guesses);
                    getActivity().getSupportFragmentManager().beginTransaction()
                            .replace(R.id.fragment, ResultFragment.newInstance(
                                    "Correct",
                                    MainActivity.click_count,
                                    MainActivity.right_guesses))
                            .addToBackStack(null)
                            .commit();
                }else{
                    getActivity().getSupportFragmentManager().beginTransaction()
                            .replace(R.id.fragment, ResultFragment.newInstance(
                                    "Incorrect",
                                    MainActivity.click_count,
                                    MainActivity.right_guesses))
                            .addToBackStack(null)
                            .commit();
                }

            }
        });
        image2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choice = Integer.parseInt(image2.getTag().toString());
                MainActivity.psychicAverage.updateClickCounts(++MainActivity.click_count);

                if(choice == imageList.get(comparison)){
                    MainActivity.psychicAverage.updateRightGuesses(++MainActivity.right_guesses);
                    getActivity().getSupportFragmentManager().beginTransaction()
                            .replace(R.id.fragment, ResultFragment.newInstance(
                                    "Correct",
                                    MainActivity.click_count,
                                    MainActivity.right_guesses))
                            .addToBackStack(null)
                            .commit();

                }else{
                    getActivity().getSupportFragmentManager().beginTransaction()
                            .replace(R.id.fragment, ResultFragment.newInstance(
                                    "Incorrect",
                                    MainActivity.click_count,
                                    MainActivity.right_guesses))
                            .addToBackStack(null)
                            .commit();
                }

            }
        });
        image3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choice = Integer.parseInt(image3.getTag().toString());
                MainActivity.psychicAverage.updateClickCounts(++MainActivity.click_count);

                if(choice == imageList.get(comparison)){
                    MainActivity.psychicAverage.updateRightGuesses(++MainActivity.right_guesses);
                    getActivity().getSupportFragmentManager().beginTransaction()
                            .replace(R.id.fragment, ResultFragment.newInstance(
                                    "Correct",
                                    MainActivity.click_count,
                                    MainActivity.right_guesses))
                            .addToBackStack(null)
                            .commit();

                }else{
                    getActivity().getSupportFragmentManager().beginTransaction()
                            .replace(R.id.fragment, ResultFragment.newInstance(
                                    "Incorrect",
                                    MainActivity.click_count,
                                    MainActivity.right_guesses))
                            .addToBackStack(null)
                            .commit();
                }
            }
        });
        image4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choice = Integer.parseInt(image4.getTag().toString());
                MainActivity.psychicAverage.updateClickCounts(++MainActivity.click_count);

                if(choice == imageList.get(comparison)){
                    MainActivity.psychicAverage.updateRightGuesses(++MainActivity.right_guesses);
                    getActivity().getSupportFragmentManager().beginTransaction()
                            .replace(R.id.fragment, ResultFragment.newInstance(
                                    "Correct",
                                    MainActivity.click_count,
                                    MainActivity.right_guesses))
                            .addToBackStack(null)
                            .commit();
                }else{
                    getActivity().getSupportFragmentManager().beginTransaction()
                            .replace(R.id.fragment, ResultFragment.newInstance(
                                    "Incorrect",
                                    MainActivity.click_count,
                                    MainActivity.right_guesses))
                            .addToBackStack(null)
                            .commit();
                }

            }
        });
    }


}
