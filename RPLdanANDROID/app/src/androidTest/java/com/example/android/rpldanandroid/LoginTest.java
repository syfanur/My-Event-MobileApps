package com.example.android.rpldanandroid;

import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.matcher.ViewMatchers.withId;


@RunWith(AndroidJUnit4.class)
@LargeTest
public class LoginTest {
    private String email;
    private String password;


    @Rule
    public ActivityTestRule<Login> activityRule = new ActivityTestRule<>(Login.class);

    @Before
    public void initValidString() {
        email = "budirayhan85@gmail.com";
        password = "12345";
    }

    @Test
    public void typeTextEmail() {
        onView(withId(R.id.text_email)).perform(typeText(email), closeSoftKeyboard());
    }
    @Test
    public void typeTextPassword() {
        onView(withId(R.id.text_pass)).perform(typeText(password), closeSoftKeyboard());
    }
}