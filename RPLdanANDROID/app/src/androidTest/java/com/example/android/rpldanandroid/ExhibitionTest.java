package com.example.android.rpldanandroid;

import androidx.test.espresso.Espresso;
import androidx.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;

import static androidx.test.espresso.action.ViewActions.click;

public class ExhibitionTest {


    @Rule
    public ActivityTestRule<Exhibiton> activityRule = new ActivityTestRule<>(Exhibiton.class);

    @Test
    public void IntentButtonDetailEvent(){
        Espresso.onView(withId(R.id.bt_next3))
                .perform(click());
    }

    @Test
    public void IntentButtonBackToHomepage(){
        Espresso.onView(withId(R.id.bt_close))
                .perform(click());
    }

}





