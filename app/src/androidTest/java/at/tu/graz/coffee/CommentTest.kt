package at.tu.graz.coffee


import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import androidx.test.espresso.Espresso.onData
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.NoMatchingViewException
import androidx.test.espresso.ViewAssertion
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.filters.LargeTest
import androidx.test.rule.ActivityTestRule
import androidx.test.runner.AndroidJUnit4
import org.hamcrest.Description
import org.hamcrest.Matcher
import org.hamcrest.Matchers.*
import org.hamcrest.TypeSafeMatcher
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@LargeTest
@RunWith(AndroidJUnit4::class)
class CommentTest {

    @Rule
    @JvmField
    var mActivityTestRule = ActivityTestRule(MainActivity::class.java)

    @Test
    fun commentTest() {
        val constraintLayout = onData(anything())
            .inAdapterView(allOf(withId(R.id.home_listview),
                childAtPosition(
                    withClassName(`is`("androidx.constraintlayout.widget.ConstraintLayout")),
                    0)))
            .atPosition(0)
        constraintLayout.perform(click())

        val materialButton = onView(
            allOf(withId(R.id.btn_comments), withText("Comments"),
                childAtPosition(
                    childAtPosition(
                        withClassName(`is`("android.widget.ScrollView")),
                        0),
                    3)))
        materialButton.perform(scrollTo(), click())

        val textInputEditText = onView(
            allOf(withId(R.id.comment_text_field),
                childAtPosition(
                    childAtPosition(
                        withClassName(`is`("androidx.core.widget.NestedScrollView")),
                        0),
                    7),
                isDisplayed()))
        textInputEditText.perform(replaceText("test"), closeSoftKeyboard())

        val materialButton2 = onView(
            allOf(withId(R.id.btn_comment_submit), withText("Submit"),
                childAtPosition(
                    childAtPosition(
                        withClassName(`is`("androidx.core.widget.NestedScrollView")),
                        0),
                    8),
                isDisplayed()))
        onView(withId(R.id.comment_listview)).check(ListViewItemCountAssertion(7))

        materialButton2.perform(click())
        onView(withId(R.id.comment_listview)).check(ListViewItemCountAssertion(8))

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
    class ListViewItemCountAssertion(private val expectedCount: Int) : ViewAssertion {
        override fun check(view: View, noViewFoundException: NoMatchingViewException?) {
            if (noViewFoundException != null) {
                throw noViewFoundException
            }
            val listView = view as ListView

            assertThat(listView.count, `is`(expectedCount))
        }
    }
}
