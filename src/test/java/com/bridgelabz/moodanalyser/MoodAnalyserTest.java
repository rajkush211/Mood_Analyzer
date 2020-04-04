package com.bridgelabz.moodanalyser;

import org.junit.Assert;
import org.junit.Test;

public class MoodAnalyserTest {

    MoodAnalyser moodAnalyser = new MoodAnalyser();
    // Test for testing Sad mood
    @Test
    public void givenMessage_whenSad_shouldReturnSad() {
        String mood = moodAnalyser.analyseMood("Today I am Sad");
        Assert.assertEquals("Sad", mood);
    }
    // Test for testing Happy mood
    @Test
    public void givenMessage_whenHappy_shouldReturnHappy() {
        String mood = moodAnalyser.analyseMood("Today I am Happy");
        Assert.assertEquals("Happy", mood);
    }
    // Test for testing Any other mood

    @Test
    public void givenMessage_whenAny_shouldReturnHappy() {
        String mood = moodAnalyser.analyseMood("I am in Any Mood");
        Assert.assertEquals("Happy", mood);
    }
}
