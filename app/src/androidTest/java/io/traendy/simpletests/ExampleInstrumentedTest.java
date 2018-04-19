package io.traendy.simpletests;

import android.content.Context;
import android.os.Looper;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    @Test
    public void useAppContext() {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();

        assertEquals("io.traendy.simpletests", appContext.getPackageName());
    }

    @Test
    public void testTollerTextGenerator() {
        Looper.prepare();
        MainActivity activity = new MainActivity();
        assertEquals("Hallo", activity.tollerTextGenerator(-10));
        assertEquals("Welt!", activity.tollerTextGenerator(10));

    }
}
