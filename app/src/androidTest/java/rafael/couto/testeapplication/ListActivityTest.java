package rafael.couto.testeapplication;

import android.support.test.espresso.action.ViewActions;

import org.junit.Test;

import static android.support.test.espresso.Espresso.*;
import static android.support.test.espresso.matcher.ViewMatchers.*;
import static android.support.test.espresso.matcher.RootMatchers.withDecorView;
import static android.support.test.espresso.action.ViewActions.*;
import static android.support.test.espresso.assertion.ViewAssertions.*;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;

/**
 * Created by rafael.couto on 26/06/2018.
 */

public class ListActivityTest extends BaseUITest {
    @Test
    public void test(){
        onView(withId(R.id.rvItems));
    }
}
