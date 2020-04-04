package com.bridgelabz.moodanalyser;

public class MoodAnalyser {

    String message;
    // Parameterized Constructor
    public MoodAnalyser(String message) {
        this.message = message;
    }
    // Method for analyzing the mood
    public String analyseMood() {
        if (message.contains("Sad"))
            return "Sad";
        else
            return "Happy";
    }
}
