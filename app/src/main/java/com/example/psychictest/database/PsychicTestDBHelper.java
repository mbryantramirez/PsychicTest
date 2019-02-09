package com.example.psychictest.database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.NonNull;

import com.example.psychictest.model.PsychicAverage;

import java.util.ArrayList;
import java.util.List;


public class PsychicTestDBHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "psychicTest.db";
    private static final String TABLE_NAME = "averageRecorder";
    private static final int SCHEMA_VERSION = 1;

    public PsychicTestDBHelper(@NonNull Context context) {
        super(context, DATABASE_NAME, null, SCHEMA_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE_NAME
                + " (_id INTEGER PRIMARY KEY, " +
                "right_guesses INTEGER, " +
                "click_counts INTEGER);");

    }

    public void updateClickCounts(int count){
        //Updates the click count amount with count parameter
        Cursor cursor = getWritableDatabase().rawQuery("UPDATE " + TABLE_NAME +
                " SET click_counts = " + count + " WHERE click_counts = " + 0 + ";", null);
        cursor.close();
    }

    public void updateRightGuesses(int guesses){
        //Updates the click count amount with count parameter
        Cursor cursor = getWritableDatabase().rawQuery("UPDATE " + TABLE_NAME +
                " SET right_guesses = " + guesses + " WHERE right_guesses = " + 0 + ";", null);
        cursor.close();

    }

    public void addPsychicAverage(PsychicAverage psychicAverage){
        Cursor cursor = getReadableDatabase().rawQuery(
                "SELECT * FROM " + TABLE_NAME +
                        " WHERE right_guesses = " + psychicAverage.getRightGuesses() +
                        " AND click_counts = " + psychicAverage.getClickCount()
                        + ";", null);
        if(cursor.getCount() == 0){
            getWritableDatabase().execSQL("INSERT INTO " + TABLE_NAME +
                    "(right_guesses, click_counts) VALUES(" +
                    psychicAverage.getRightGuesses() + ", " +
                    psychicAverage.getClickCount() + ");");
        }
        cursor.close();
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
