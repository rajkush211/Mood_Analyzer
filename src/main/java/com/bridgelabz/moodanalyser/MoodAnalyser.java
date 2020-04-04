package com.bridgelabz.moodanalyser;

public class MoodAnalyser {

    String message;
    // Parameterized Constructor
    public MoodAnalyser(String message) {
        this.message = message;
    }
    // Method for analyzing the mood
    public String analyseMood() throws MoodAnalysisException {
      try {
          if (message.contains("Sad"))
              return "Sad";
          else
              return "Happy";
      }
      catch (NullPointerException e) {
          throw new MoodAnalysisException("Invalid Message");
      }
    }
}
