package com.example.android.rpldanandroid;

import androidx.test.espresso.Espresso;
import androidx.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;

import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

public class HomepageTest {

    @Rule
    public ActivityTestRule<Homepage> activityRule = new ActivityTestRule<>(Homepage.class);

    @Test
    public void IntentButtonKategoriExhibition() {
        Espresso.onView(withId(R.id.bt_art))
                .perform(click());
    }

    @Test
    public void IntentButtonSignOut() {
        Espresso.onView(withId(R.id.bt_signout))
                .perform(click());

    }
}