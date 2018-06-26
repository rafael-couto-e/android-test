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
 * Created by rafael.couto on 25/06/2018.
 */

public class WidgetsActivityTest extends BaseUITest{
    @Test
    public void widgetsPresentTest(){
        onView(withId(R.id.btnForm)).perform(click());

        onView(withId(R.id.etName)).perform(scrollTo()).check(matches(isDisplayed()));
        onView(withId(R.id.etSurname)).perform(scrollTo()).check(matches(isDisplayed()));
        onView(withId(R.id.etAge)).perform(scrollTo()).check(matches(isDisplayed()));
        onView(withId(R.id.etAddress)).perform(scrollTo()).check(matches(isDisplayed()));
        onView(withId(R.id.cbNewsletter)).perform(scrollTo()).check(matches(isDisplayed()));
        onView(withId(R.id.cbNewsletter)).perform(scrollTo()).check(matches(withText("Newsletter?")));
        onView(withId(R.id.rgGender)).perform(scrollTo()).check(matches(isDisplayed()));
        onView(withId(R.id.rbFemale)).perform(scrollTo()).check(matches(isDisplayed()));
        onView(withId(R.id.rbMale)).perform(scrollTo()).check(matches(isDisplayed()));
        onView(withId(R.id.rbFemale)).perform(scrollTo()).check(matches(withText("Female")));
        onView(withId(R.id.rbMale)).perform(scrollTo()).check(matches(withText("Male")));
        onView(withId(R.id.spDevices)).perform(scrollTo()).check(matches(isDisplayed()));
        onView(withId(R.id.spDevices)).check(matches(withSpinnerText("One")));
        onView(withId(R.id.swMarried)).perform(scrollTo()).check(matches(isDisplayed()));
        onView(withId(R.id.swMarried)).check(matches(withText("Married?")));
        onView(withId(R.id.btnSave)).perform(scrollTo()).check(matches(isDisplayed()));
    }

    @Test
    public void formSubmitTest(){
        String toastText = "User{" +
                "name='" + "Usuario" + '\'' +
                ", surname='" + "Teste" + '\'' +
                ", age=" + "25" +
                ", address='" + "Endereço Teste" + '\'' +
                ", newsletter=" + "true" +
                ", gender='" + "M" + '\'' +
                ", devices=" + "Four" +
                ", married=" + "true" +
                '}';

        onView(withId(R.id.btnForm)).perform(click());

        onView(withId(R.id.etName)).perform(scrollTo(), typeText("Usuario"));
        onView(withId(R.id.etSurname)).perform(scrollTo(), typeText("Teste"));
        onView(withId(R.id.etAge)).perform(scrollTo(), typeText("25"));
        onView(withId(R.id.etAddress)).perform(scrollTo(), typeText("Endereço Teste"));

        onView(withId(R.id.cbNewsletter)).perform(scrollTo(), click());

        onView(withId(R.id.rbMale)).perform(scrollTo(), click());

        onView(withId(R.id.spDevices)).perform(scrollTo(), click());
        onData(allOf(is(instanceOf(String.class)), is("Four"))).perform(scrollTo(), click());
        //onData(allOf(is(instanceOf(String.class)))).atPosition(3).perform(scrollTo(), click());
        onView(withId(R.id.spDevices)).check(matches(withSpinnerText("Four")));

        onView(withId(R.id.swMarried)).perform(scrollTo(), click());

        onView(withId(R.id.btnSave)).perform(scrollTo(), click(), ViewActions.closeSoftKeyboard());

        onView(withText(toastText)).inRoot(withDecorView(not(is(mainActivity.getActivity().getWindow().getDecorView())))).check(matches(isDisplayed()));
    }
}
