package com.bridgelabz.moodanalyser;

import java.util.Objects;

public class MoodAnalyser {

    String message;
    // Default Constructor
    public MoodAnalyser() {

    }
    // Parameterized Constructor
    public MoodAnalyser(String message) {
        this.message = message;
    }
    // Method for analyzing the mood
    public String analyseMood() throws MoodAnalysisException {
      try {
          if (this.message.equals(""))
              throw new MoodAnalysisException(MoodAnalysisException.ExceptionType.EMPTY, "Empty Mood");
          if (this.message.contains("Sad"))
              return "Sad";
          if (this.message.contains("Happy"))
              return "Happy";
          return "Happy";
      }
      catch (NullPointerException nullPointerException) {
          throw new MoodAnalysisException(MoodAnalysisException.ExceptionType.NULL, "Invalid Message");
      }
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || !(obj instanceof MoodAnalyser)) return false;
        MoodAnalyser that = (MoodAnalyser) obj;
        return Objects.equals(message, that.message);
    }
}
