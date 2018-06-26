package rafael.couto.testeapplication;

import org.junit.Test;

import static android.support.test.espresso.Espresso.*;
import static android.support.test.espresso.matcher.ViewMatchers.*;
import static android.support.test.espresso.assertion.ViewAssertions.*;

/**
 * Created by rafael.couto on 25/06/2018.
 */

public class HomeActivityTest extends BaseUITest{

    @Test
    public void widgetPresenceTest(){
        onView(withId(R.id.btnForm)).check(matches(isDisplayed()));
        onView(withId(R.id.btnForm)).check(matches(withText("Form")));

        onView(withId(R.id.btnList)).check(matches(isDisplayed()));
        onView(withId(R.id.btnList)).check(matches(withText("List")));
    }
}
