package com.bridgelabz.moodanalyser;

import org.junit.Assert;
import org.junit.Test;

public class MoodAnalyserTest {
    // Test for testing Sad mood
    @Test
    public void givenMessage_whenSad_shouldReturnSad() {
        MoodAnalyser moodAnalyser = new MoodAnalyser("Today I am Sad");
        Assert.assertEquals("Sad", moodAnalyser.analyseMood());
    }
    // Test for testing Happy mood
    @Test
    public void givenMessage_whenHappy_shouldReturnHappy() {
        MoodAnalyser moodAnalyser = new MoodAnalyser("Today I am Happy");
        Assert.assertEquals("Happy", moodAnalyser.analyseMood());
    }
    // Test for testing Any other mood
    @Test
    public void givenMessage_whenAny_shouldReturnHappy() {
        MoodAnalyser moodAnalyser = new MoodAnalyser("I am in Any Mood");
        Assert.assertEquals("Happy", moodAnalyser.analyseMood());
    }
    // Test for testing Null mood
    @Test
    public void givenMessage_whenNULL_shouldReturnHappy() {
        MoodAnalyser moodAnalyser = new MoodAnalyser(null);
        Assert.assertEquals("Happy", moodAnalyser.analyseMood());
    }
}
