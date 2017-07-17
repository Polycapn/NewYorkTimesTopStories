package com.example.lelouch.newyorktimestopstories.View;

import android.content.Intent;
import android.support.test.espresso.contrib.RecyclerViewActions;
import android.support.test.rule.ActivityTestRule;

import com.example.lelouch.newyorktimestopstories.R;

import org.junit.Rule;
import org.junit.Test;

import static android.support.test.InstrumentationRegistry.getInstrumentation;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

/**
 */
public class TopStoriesActivityTest {



    @Rule
    public final ActivityTestRule<TopStoriesActivity> mActivityRule = new ActivityTestRule<>(TopStoriesActivity.class);

    @Test
    public void listItemClickShouldLaunchFragment(){
        //Launch activity under test
        Intent intent = new Intent(getInstrumentation().getContext(), TopStoriesActivity.class);
        mActivityRule.launchActivity(intent);

        //perform click on first item in top stories recycler view
        onView(withId(R.id.recyclerView))
                .perform(RecyclerViewActions.actionOnItemAtPosition(0, click()));

        //confirm webview fragment was successfully launched
        onView(withId(R.id.webView)).check(matches(isDisplayed()));
    }


}