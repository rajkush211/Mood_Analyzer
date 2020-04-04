package com.bridgelabz.moodanalyser;

public class MoodAnalyser {
    // Method for analyzing the mood
    public String analyseMood(String message) {
        if (message.contains("Sad"))
            return "Sad";
        if (message.contains("Happy"))
            return "Happy";
        return "Invalid mood";
    }
}
