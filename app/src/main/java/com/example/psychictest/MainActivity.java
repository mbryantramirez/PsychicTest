package com.example.psychictest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.psychictest.fragments.MainFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportFragmentManager().beginTransaction()
                .add(R.id.fragment, MainFragment.newInstace())
                .addToBackStack(null)
                .commit();
    }
}
