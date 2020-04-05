package com.bridgelabz.moodanalyser;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MoodAnalyserFactory {
    // Default Constructor
    public static Constructor<?> getConstructor(String className, Class<?>... parameter) throws MoodAnalysisException {
        try {
            Class<?> moodAnalyserClass = Class.forName(className);
            return moodAnalyserClass.getConstructor(parameter);
        }
        catch (ClassNotFoundException e) {
            throw new MoodAnalysisException(MoodAnalysisException.ExceptionType.CLASS_NOT_FOUND, "Class not found");
        }
        catch (NoSuchMethodException e) {
            throw new MoodAnalysisException(MoodAnalysisException.ExceptionType.NO_SUCH_METHOD, "Method not found");
        }
    }

    public static MoodAnalyser createMoodAnalyserObject(Constructor<?> moodAnalyserConstructor, Object... moodAnalyserObject) throws IllegalAccessException, InvocationTargetException, InstantiationException {
        return (MoodAnalyser)moodAnalyserConstructor.newInstance(moodAnalyserObject);
    }

    public static Object invokeMethod(Object moodAnalyserObject, String analyseMood) throws MoodAnalysisException, IllegalAccessException, InvocationTargetException {
        try {
            Class objectClass = moodAnalyserObject.getClass();
            Method moodMethod = objectClass.getMethod(analyseMood);
            Object result = moodMethod.invoke(moodAnalyserObject);
            return result;
        } catch (NoSuchMethodException e) {
            throw new MoodAnalysisException(MoodAnalysisException.ExceptionType.NO_SUCH_METHOD, "Method not found");
        }
    }
}
