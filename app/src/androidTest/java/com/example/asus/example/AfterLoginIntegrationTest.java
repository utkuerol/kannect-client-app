package com.example.asus.example;

import android.support.test.espresso.intent.rule.IntentsTestRule;
import android.support.test.filters.LargeTest;
import android.support.test.runner.AndroidJUnit4;

import com.example.asus.example.mvvm.View.LoginActivity;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.intent.Intents.intended;
import static android.support.test.espresso.intent.matcher.IntentMatchers.hasComponent;


@RunWith(AndroidJUnit4.class)
@LargeTest
public class AfterLoginIntegrationTest {

    @Rule
    public IntentsTestRule<LoginActivity> rule = new IntentsTestRule<>(
            LoginActivity.class);


    @Before
    public void setup() {

    }

    @Test
    public void onSuccessfulLogin() {

        intended(hasComponent(LoginActivity.class.getName()));

    }
}
