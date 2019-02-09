package com.example.psychictest.model;

public class PsychicAverage {
    private int rightGuesses;
    private int clickCount;

    public PsychicAverage(int rightGuesses, int clickCount){
        this.rightGuesses = rightGuesses;
        this.clickCount = clickCount;
    }

    public int getRightGuesses() {
        return rightGuesses;
    }

    public void setRightGuesses(int rightGuesses) {
        this.rightGuesses = rightGuesses;
    }

    public int getClickCount() {
        return clickCount;
    }

    public void setClickCount(int clickCount) {
        this.clickCount = clickCount;
    }

}
