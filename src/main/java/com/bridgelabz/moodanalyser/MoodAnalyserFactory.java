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

    public static MoodAnalyser createMoodAnalyserObject(Constructor<?> moodAnalyserConstructor, Object... message) throws IllegalAccessException, InvocationTargetException, InstantiationException {
        return (MoodAnalyser)moodAnalyserConstructor.newInstance(message);
    }

    public static Object createMethod(MoodAnalyser moodAnalyserObject, String methodName) throws MoodAnalysisException, IllegalAccessException, InvocationTargetException {
        try {
            Method method = moodAnalyserObject.getClass().getMethod(methodName);
            Object result = method.invoke(moodAnalyserObject);
            return result;
        } catch (NoSuchMethodException e) {
            throw new MoodAnalysisException(MoodAnalysisException.ExceptionType.NO_SUCH_METHOD, "Method not found");
        }
    }
}
