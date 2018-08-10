package com.example.android.testing.integration;

import android.content.Context;
import android.support.test.espresso.contrib.DrawerActions;
import android.support.test.espresso.contrib.NavigationViewActions;
import android.support.test.espresso.contrib.RecyclerViewActions;
import android.support.test.espresso.intent.rule.IntentsTestRule;
import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.runner.AndroidJUnit4;

import com.example.asus.example.R;
import com.example.asus.example.mvvm.View.Navigation_Drawer_Activity;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.contrib.DrawerMatchers.isOpen;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;


@RunWith(AndroidJUnit4.class)
public class FeedIntegrationTest {

    @Rule
    public IntentsTestRule<Navigation_Drawer_Activity> mIntentsRule =
            new IntentsTestRule<>(Navigation_Drawer_Activity.class);

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void scrollToItemBelowFold_checkItsText() {

        /*
            Bob öffnet KAnnect und möchte sein Feed durchschauen. Er sieht die Beiträge seiner Freunde,
            seiner abonnierten Veranstaltungen und seiner gefolgten Gruppen in chronologische Reihenfolge.
            Bob will auf ein Beitrag reagieren , er klickt “Gefällt mir”, weil ein Freund von ihm was Lustiges
            gepostet hat. Er ist die 16.te Person, die den Beitrag mit “Gefällt mir” markiert hat. Außerdem
            kommentiert er den Beitrag, daraufhin merkt er, dass auch diese chronologisch sortiert sind.

            1- click auf personal Feed +
            2- Assert abonnierte Veranstaltungen / gefolgten Gruppen -
            3- auf ein Beitrag clicken +
            4- Gefällt mir klicken +
            5- assert Anzahl of Likes = 16 nach Click von Bob +
         */

        onView(withId(R.id.drawer_layout)).perform(DrawerActions.open());
        onView(withId(R.id.drawer_layout)).check(matches(isOpen()));

        onView(withId(R.id.nav_view)).perform(NavigationViewActions.navigateTo(R.id.nav_feed));

        onView(ViewMatchers.withId(R.id.personalFeedPostRV))
                .perform(RecyclerViewActions.actionOnItemAtPosition(0, click()));

        // Match the text in an item below the fold and check that it's displayed.
        String itemElementText = mIntentsRule.getActivity().getResources().getString(
                R.string.hello);


        onView(withText(itemElementText)).check(matches(withId(R.id.fragmentPostTV)));


        onView(withId(R.id.fragmentThumbsUpIV)).perform(click());

        String numberOfLike = mIntentsRule.getActivity().getResources().getString(
                R.string.numberOfLike);

        onView(withText(numberOfLike)).check(matches(withId(R.id.numberOfLikesTV))); // muss geändert werden : Florian


    }


    @After
    public void tearDown() {

    }
}
