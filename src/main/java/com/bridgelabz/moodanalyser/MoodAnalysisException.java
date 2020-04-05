package com.bridgelabz.moodanalyser;

public class MoodAnalysisException extends Exception {

    public enum ExceptionType {
        EMPTY, NULL, CLASS_NOT_FOUND, NO_SUCH_METHOD, NO_SUCH_FIELD;
    }

    public ExceptionType type;

    public MoodAnalysisException(ExceptionType type, String message) {
        super(message);
        this.type = type;
    }

}
