package com.mlc.android_test;


import android.content.Context;
import android.content.Intent;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import androidx.test.filters.LargeTest;
import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.rule.ActivityTestRule;
import androidx.test.runner.AndroidJUnit4;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class TextShowTextActivity {

    private static final String MESSAGE = "12312";

    @Rule
    public ActivityTestRule<ShowTextActivity> activityRule
            = new ActivityTestRule<ShowTextActivity>(ShowTextActivity.class, false, true){
        @Override
        protected Intent getActivityIntent() {
//            Context targetContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
//            Intent result = new Intent(targetContext, ShowTextActivity.class);
            Intent result = new Intent();
            result.putExtra(ShowTextActivity.KEY_EXTRA_MESSAGE, MESSAGE);
            return result;
        }
    };

    @Test
    public void listGoesOverTheFold() {
        onView(withText(MESSAGE)).check(matches(isDisplayed()));
    }

}
