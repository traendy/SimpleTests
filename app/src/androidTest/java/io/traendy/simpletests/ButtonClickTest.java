package io.traendy.simpletests;

import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;


import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.clearText;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class ButtonClickTest {

    private String mStringToBetyped;
    private String emptyString;

    @Rule
    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule<>(
            MainActivity.class);

    @Before
    public void initValidString() {
        // Specify a valid string.
        mStringToBetyped = "Espresso";
        emptyString = "";
    }

    @Test
    public void changeText_sameActivity() {
        // Type text and then press the button.
        onView(withId(R.id.editText))
                .perform(typeText(mStringToBetyped), closeSoftKeyboard());
        onView(withId(R.id.button)).perform(click());

        // Check that the text was changed.
        onView(withId(R.id.textView))
                .check(matches(withText(mStringToBetyped)));
    }

    @Test
    public void deleteText_sameActivity(){
        onView(withId(R.id.editText))
                .perform(clearText(), closeSoftKeyboard());
        onView(withId(R.id.button)).perform(click());
        onView(withId(R.id.editText))
                .check(matches(withText(emptyString)));
        onView(withId(R.id.textView))
                .check(matches(withText(emptyString)));

    }

    @Test
    public void textGeneratorButton_sameActivity(){
        onView(withId(R.id.button2))
                .perform(click());
        onView(withId(R.id.textView))
                .check(matches(withText("Welt!")));
    }
}

