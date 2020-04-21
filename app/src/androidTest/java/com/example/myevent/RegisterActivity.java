package com.example.myevent;

import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;


import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.typeText;
import junit.extensions.ActiveTestSuite;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

import androidx.test.espresso.ViewAction;

@RunWith(AndroidJUnit4.class)
@LargeTest

public class RegisterActivity {
    private String surename;
    private String name;
    private String email;
    private String password;

    @Rule
    public ActivityTestRule<MainActivity> activityRule
            = new ActivityTestRule<>(MainActivity.class);

    @Before
    public void initValidString() {
        surename = "Priyanka Sonia";
        name = "sonia";
        email = "sonia@mail";
        password = "123";

    }
    @Test
    public void typeTextSurename() {
        onView(withId(R.id.surename)).perform(typeText(surename),closeSoftKeyboard());
    }
    @Test
    public void typeTextName() {
        onView(withId(R.id.name)).perform(typeText(name), closeSoftKeyboard());
    }
    @Test
    public void typeTextEmail() {
        onView(withId(R.id.email)).perform(typeText(email), closeSoftKeyboard());
    }
    @Test
    public void typeTextPassword() {
        onView(withId(R.id.Pass)).perform(typeText(password), closeSoftKeyboard());







    }

}
