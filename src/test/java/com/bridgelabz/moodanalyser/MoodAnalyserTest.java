package com.bridgelabz.moodanalyser;

import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class MoodAnalyserTest {
    // Test for testing Sad mood
    @Test
    public void givenMessage_whenSad_shouldReturnSad() throws MoodAnalysisException {
        MoodAnalyser moodAnalyser = new MoodAnalyser("Today I am Sad");
        Assert.assertEquals("Sad", moodAnalyser.analyseMood());
    }

    // Test for testing Happy mood
    @Test
    public void givenMessage_whenHappy_shouldReturnHappy() throws MoodAnalysisException {
        MoodAnalyser moodAnalyser = new MoodAnalyser("Today I am Happy");
        Assert.assertEquals("Happy", moodAnalyser.analyseMood());
    }

    // Test for testing Any other mood
    @Test
    public void givenMessage_whenAny_shouldReturnHappy() throws MoodAnalysisException {
        MoodAnalyser moodAnalyser = new MoodAnalyser("I am in Any Mood");
        Assert.assertEquals("Happy", moodAnalyser.analyseMood());
    }

    // Test for testing Null mood
    @Test
    public void givenMessage_whenNULL_shouldThrowMoodAnalysisException() throws MoodAnalysisException {
        try {
            MoodAnalyser moodAnalyser = new MoodAnalyser(null);
            moodAnalyser.analyseMood();
        } catch (MoodAnalysisException moodAnalysisException) {
            Assert.assertEquals("Invalid Message", moodAnalysisException.getMessage());
        }
    }

    // Test for testing Empty Mood
    @Test
    public void givenMessage_whenEmpty_shouldThrowMoodAnalysisException() throws MoodAnalysisException {
        try {
            MoodAnalyser moodAnalyser = new MoodAnalyser("");
            moodAnalyser.analyseMood();
        } catch (MoodAnalysisException moodAnalysisException) {
            Assert.assertEquals("Empty Mood", moodAnalysisException.getMessage());
        }
    }

    // Test for testing MoodAnalyser class name should return MoodAnalyser object checking if both are equal
    @Test
    public void givenMoodAnalyserClassName_whenProper_shouldReturnObject() throws IllegalAccessException, InstantiationException, InvocationTargetException, MoodAnalysisException {
        MoodAnalyser moodAnalyser = new MoodAnalyser();
        Constructor<?> moodAnalyserConstructor = MoodAnalyserFactory.getConstructor("com.bridgelabz.moodanalyser.MoodAnalyser");
        MoodAnalyser moodAnalyserObj = MoodAnalyserFactory.createMoodAnalyserObject(moodAnalyserConstructor);
        boolean check = moodAnalyser.equals(moodAnalyserObj);
        Assert.assertEquals(true, check);
    }

    // Test for testing When Passing improper class name should throw CLASS_NOT_FOUND Exception
    @Test
    public void givenMoodAnalyserClassName_whenImproper_shouldThrowMoodAnalysisException() throws IllegalAccessException, InstantiationException, InvocationTargetException, MoodAnalysisException {
        try {
            Constructor<?> moodAnalyserConstructor = MoodAnalyserFactory.getConstructor("MobileAnalyser");
        } catch (MoodAnalysisException e) {
            Assert.assertEquals(MoodAnalysisException.ExceptionType.CLASS_NOT_FOUND, e.type);
        }
    }

    // Test for testing When passing wrong constructor parameter should throw NO_SUCH_METHOD Exception
    @Test
    public void givenMoodAnalyserClassName_whenConstructorNotProper_shouldThrowMoodAnalysisException() throws IllegalAccessException, InstantiationException,InvocationTargetException, MoodAnalysisException {
        try {
            Constructor<?> moodAnalyserConstructor = MoodAnalyserFactory.getConstructor("com.bridgelabz.moodanalyser.MoodAnalyser", Integer.class);
        } catch (MoodAnalysisException e) {
            Assert.assertEquals(MoodAnalysisException.ExceptionType.NO_SUCH_METHOD, e.type);
        }
    }

    // Test for testing MoodAnalyser parameter constructor when created through MoodAnalyserFactory class then check if two objects are equal
    @Test
    public void givenMoodAnalyserWithParameterConstructor_whenProper_shouldReturnObject() throws IllegalAccessException, InstantiationException, InvocationTargetException, MoodAnalysisException {
        MoodAnalyser moodAnalyser = new MoodAnalyser("I am in Happy mood");
        Constructor<?> moodAnalyserConstructor = null;
        try {
            moodAnalyserConstructor = MoodAnalyserFactory.getConstructor("com.bridgelabz.moodanalyser.MoodAnalyser", String.class);
        } catch (MoodAnalysisException e) {
            e.printStackTrace();
        }
        MoodAnalyser moodAnalyserObject = MoodAnalyserFactory.createMoodAnalyserObject(moodAnalyserConstructor, "I am in Happy mood");
        boolean check = moodAnalyser.equals(moodAnalyserObject);
        Assert.assertEquals(true, check);
    }

    // Test for testing when giving Improper class name should throw MoodAnalysisException
    @Test
    public void givenMoodAnalyserWithParameterConstructor_whenImproperClassName_shouldThrowMoodAnalysisException() throws IllegalAccessException, InstantiationException, InvocationTargetException, MoodAnalysisException {
        try {
            Constructor<?> moodAnalyserConstructor = MoodAnalyserFactory.getConstructor("MobileAnalyser", String.class);
        } catch (MoodAnalysisException e) {
            Assert.assertEquals(MoodAnalysisException.ExceptionType.CLASS_NOT_FOUND, e.type);
        }
    }

    // Test for testing when giving wrong constructor parameter should throw No_SUCH_METHOD Exception
    @Test
    public void givenMoodAnalyserWithParameterConstructor_whenWrongParameter_shouldThrowMoodAnalysisException() throws InvocationTargetException, InstantiationException, IllegalAccessException, MoodAnalysisException {
        try {
            Constructor<?> moodAnalyserConstructor = MoodAnalyserFactory.getConstructor("com.bridgelabz.moodanalyser.MoodAnalyser", Integer.class, String.class);
        } catch (MoodAnalysisException e) {
            Assert.assertEquals(MoodAnalysisException.ExceptionType.NO_SUCH_METHOD, e.type);
        }

    }
}
