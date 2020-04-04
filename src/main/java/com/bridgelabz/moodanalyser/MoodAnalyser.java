package com.bridgelabz.moodanalyser;

public class MoodAnalyser {
    // Method for analyzing the mood
    public String analyseMood(String message) {
        if (message.contains("Sad"))
            return "Sad";
        else
            return "Happy";
    }
}
