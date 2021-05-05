package at.tu.graz.coffee.ui.home

import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onData
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.ViewAssertion
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import junit.framework.TestCase
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import at.tu.graz.coffee.MainActivity
import at.tu.graz.coffee.R
import at.tu.graz.coffee.model.Coffee
import org.hamcrest.CoreMatchers.allOf
import org.junit.Test
import org.junit.runner.RunWith
import java.util.regex.Pattern.matches

@RunWith(AndroidJUnit4ClassRunner::class)
class HomeFragmentTest : TestCase()
{
    @Test
    fun test_isActivityInView() {
        //launching activity
        val activityScenario = ActivityScenario.launch(MainActivity::class.java)
        //checks if starting app shows right screen
        onView(withId(R.id.home_listview)).check(matches(isDisplayed()))
        //instead of isDisplayed: withEffectiveVisibility(Visibility.VISIBLE) -> also for GONE, INVISIBLE
    }

    @Test
    fun test_areObjectsVisible() {
        //loading HomeFragment
        launchFragmentInContainer<HomeFragment>()
        //checks if title of coffee is displayed
        onView(allOf(ViewMatchers.withId(R.id.home_textView_name), isDisplayed()))
        //checks if rating bar gets displayed
        onView(allOf(ViewMatchers.withId(R.id.home_ratingBar), isDisplayed()))
        //checks if image gets displayed
        onView(allOf(ViewMatchers.withId(R.id.home_imageView), isDisplayed()))
        //checks if rating text gets displayed
        onView(allOf(ViewMatchers.withId(R.id.home_textView_rating), isDisplayed()))
    }
}

