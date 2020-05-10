package com.example.myevent;

import android.content.Context;

import androidx.test.InstrumentationRegistry;
import androidx.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;

import static androidx.test.espresso.Espresso.onData;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertEquals;

public class SettingTest {

    @Rule
    public ActivityTestRule mActivityRule = new ActivityTestRule<>(
            Setting.class);

    @Test
    public void useAppContext() throws Exception {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();

        assertEquals("com.example.myevent",
                appContext.getPackageName());
    }

    @Test
    public void iterateSpinnerItems() {
        String[] myArray = mActivityRule.getActivity().getResources()
                .getStringArray(R.array.bahasa_arrays);
        int size = myArray.length;
        for (int i=0; i<size; i++) {
            onView(withId(R.id.spLanguage)).perform(click());
            onData(is(myArray[i])).perform(click());
        }
    }
}


