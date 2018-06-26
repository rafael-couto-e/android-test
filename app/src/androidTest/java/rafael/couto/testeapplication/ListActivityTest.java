package rafael.couto.testeapplication;

import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.support.test.espresso.UiController;
import android.support.test.espresso.ViewAction;
import android.support.test.espresso.matcher.BoundedMatcher;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.junit.Test;

import static android.support.test.espresso.Espresso.*;
import static android.support.test.espresso.core.internal.deps.dagger.internal.Preconditions.checkNotNull;
import static android.support.test.espresso.matcher.ViewMatchers.*;
import static android.support.test.espresso.action.ViewActions.*;
import static android.support.test.espresso.assertion.ViewAssertions.*;
import static android.support.test.espresso.matcher.RootMatchers.*;
import static android.support.test.espresso.contrib.RecyclerViewActions.*;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;

/**
 * Created by rafael.couto on 26/06/2018.
 */

public class ListActivityTest extends BaseUITest {
    @Test
    public void test(){
        onView(withId(R.id.btnList)).perform(click());

        String toastText = "ListModel{" +
                "name='" + "Three" + '\'' +
                ", age='" + "3" + '\'' +
                '}';

        onView(withId(R.id.rvItems)).check(matches(atPosition(2, hasDescendant(withText("Three")))));
        onView(withId(R.id.rvItems)).check(matches(atPosition(2, hasDescendant(withText("3")))));
        onView(withId(R.id.rvItems)).check(matches(atPosition(2, hasDescendant(withId(R.id.btnRemove)))));

        onView(withId(R.id.rvItems)).perform(actionOnItemAtPosition(2, clickOnChildWithId(R.id.btnRemove)));

        onView(withText(toastText)).inRoot(withDecorView(not(is(mainActivity.getActivity().getWindow().getDecorView())))).check(matches(isDisplayed()));

        onView(withId(R.id.rvItems)).perform(actionOnItemAtPosition(2, click()));

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        toastText = "ListModel{" +
                "name='" + "Four" + '\'' +
                ", age='" + "4" + '\'' +
                '}';

        onView(withId(R.id.rvItems)).check(matches(atPosition(2, hasDescendant(withText("Four")))));
        onView(withId(R.id.rvItems)).check(matches(atPosition(2, hasDescendant(withText("4")))));
        onView(withId(R.id.rvItems)).perform(actionOnItemAtPosition(2, clickOnChildWithId(R.id.btnRemove)));

        onView(withText(toastText)).inRoot(withDecorView(not(is(mainActivity.getActivity().getWindow().getDecorView())))).check(matches(isDisplayed()));
    }

    public static Matcher<View> atPosition(final int position, @NonNull final Matcher<View> itemMatcher) {
        checkNotNull(itemMatcher);

        return new BoundedMatcher<View, RecyclerView>(RecyclerView.class) {
            @Override
            public void describeTo(Description description) {
                description.appendText("has item at position " + position + ": ");
                itemMatcher.describeTo(description);
            }

            @Override
            protected boolean matchesSafely(final RecyclerView view) {
                RecyclerView.ViewHolder viewHolder = view.findViewHolderForAdapterPosition(position);
                // has no item on such position
                return viewHolder != null && itemMatcher.matches(viewHolder.itemView);
            }
        };
    }

    public static ViewAction clickOnChildWithId(final int id){
        return new ViewAction() {
            @Override
            public Matcher<View> getConstraints() {
                return null;
            }

            @Override
            public String getDescription() {
                return "Click on a child view with specified id.";
            }

            @Override
            public void perform(UiController uiController, View view) {
                View v = view.findViewById(id);
                v.performClick();
            }
        };
    }
}