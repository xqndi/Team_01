package at.tu.graz.coffee


import androidx.test.espresso.DataInteraction
import androidx.test.espresso.ViewInteraction
import androidx.test.filters.LargeTest
import androidx.test.rule.ActivityTestRule
import androidx.test.runner.AndroidJUnit4
import android.view.View
import android.view.ViewGroup
import android.view.ViewParent

import androidx.test.InstrumentationRegistry.getInstrumentation
import androidx.test.espresso.Espresso.onData
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.Espresso.pressBack
import androidx.test.espresso.Espresso.openActionBarOverflowOrOptionsMenu
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.*
import androidx.test.espresso.matcher.ViewMatchers.*

import at.tu.graz.coffee.R

import org.hamcrest.Description
import org.hamcrest.Matcher
import org.hamcrest.TypeSafeMatcher
import org.hamcrest.core.IsInstanceOf
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

import org.hamcrest.Matchers.allOf
import org.hamcrest.Matchers.anything
import org.hamcrest.Matchers.`is`

@LargeTest
@RunWith(AndroidJUnit4::class)
class ChangeToRussianTest {

    @Rule
    @JvmField
    var mActivityTestRule = ActivityTestRule(MainActivity::class.java)

    @Test
    fun changeToRussianTest() {
         // Added a sleep statement to match the app's execution delay.
 // The recommended way to handle such scenarios is to use Espresso idling resources:
  // https://google.github.io/android-testing-support-library/docs/espresso/idling-resource/index.html
Thread.sleep(250)

        val overflowMenuButton = onView(
allOf(withContentDescription("More options"),
childAtPosition(
childAtPosition(
withId(R.id.toolbar),
2),
0),
isDisplayed()))
        overflowMenuButton.perform(click())

         // Added a sleep statement to match the app's execution delay.
 // The recommended way to handle such scenarios is to use Espresso idling resources:
  // https://google.github.io/android-testing-support-library/docs/espresso/idling-resource/index.html
Thread.sleep(250)

        val materialTextView = onView(
allOf(withId(R.id.title), withText("Settings"),
childAtPosition(
childAtPosition(
withId(R.id.content),
0),
0),
isDisplayed()))
        materialTextView.perform(click())

        val materialRadioButton = onView(
allOf(withId(R.id.language_second_radio), withText("Russian"),
childAtPosition(
childAtPosition(
withClassName(`is`("androidx.constraintlayout.widget.ConstraintLayout")),
0),
1),
isDisplayed()))
        materialRadioButton.perform(click())

        val materialButton = onView(
allOf(withId(R.id.settings_apply_button), withText("Apply"),
childAtPosition(
childAtPosition(
withId(R.id.nav_host_fragment),
0),
1),
isDisplayed()))
        materialButton.perform(click())

        val appCompatImageButton = onView(
allOf(withContentDescription("Открыть панель навигации"),
childAtPosition(
allOf(withId(R.id.toolbar),
childAtPosition(
withClassName(`is`("com.google.android.material.appbar.AppBarLayout")),
0)),
1),
isDisplayed()))
        appCompatImageButton.perform(click())
        }

    private fun childAtPosition(
            parentMatcher: Matcher<View>, position: Int): Matcher<View> {

        return object : TypeSafeMatcher<View>() {
            override fun describeTo(description: Description) {
                description.appendText("Child at position $position in parent ")
                parentMatcher.describeTo(description)
            }

            public override fun matchesSafely(view: View): Boolean {
                val parent = view.parent
                return parent is ViewGroup && parentMatcher.matches(parent)
                        && view == parent.getChildAt(position)
            }
        }
    }
    }
