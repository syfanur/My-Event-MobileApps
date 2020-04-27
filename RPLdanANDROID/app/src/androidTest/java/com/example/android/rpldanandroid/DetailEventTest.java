package com.example.android.rpldanandroid;

import androidx.test.espresso.Espresso;
import androidx.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;

import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

public class DetailEventTest {

    @Rule
    public ActivityTestRule<DetailEvent> activityRule = new ActivityTestRule<>(DetailEvent.class);

    @Test
    public void IntentButtonDetailEvent(){
        Espresso.onView(withId(R.id.buttonhadir))
                .perform(click());
    }
}


