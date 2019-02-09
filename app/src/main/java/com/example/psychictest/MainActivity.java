package com.example.psychictest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.psychictest.database.PsychicTestDBHelper;
import com.example.psychictest.fragments.MainFragment;

public class MainActivity extends AppCompatActivity {
    public static final String CLICK_COUNT = "click_count";
    public static final String RIGHT_GUESSES = "right_guesses";
    public static int click_count = 0;
    public static int right_guesses = 0;
    public static PsychicTestDBHelper psychicAverage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getApplicationContext().deleteDatabase(PsychicTestDBHelper.DATABASE_NAME);

        getSupportFragmentManager().beginTransaction()
                .add(R.id.fragment, MainFragment.newInstace())
                .addToBackStack(null)
                .commit();
    }

}
