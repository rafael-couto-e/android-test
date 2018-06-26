package rafael.couto.testeapplication;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.runner.RunWith;

/**
 * Created by rafael.couto on 26/06/2018.
 */

@RunWith(AndroidJUnit4.class)
public abstract class BaseUITest {
    @Rule
    public ActivityTestRule<MainActivity> mainActivity = new ActivityTestRule<>(MainActivity.class);
}
