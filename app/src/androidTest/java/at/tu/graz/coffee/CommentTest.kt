package at.tu.graz.coffee


import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.filters.LargeTest
import androidx.test.rule.ActivityTestRule
import androidx.test.runner.AndroidJUnit4
import org.hamcrest.Description
import org.hamcrest.Matcher
import org.hamcrest.Matchers.`is`
import org.hamcrest.Matchers.allOf
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
        val recyclerView = onView(
            allOf(
                withId(R.id.home_listview),
                childAtPosition(
                    withClassName(`is`("androidx.constraintlayout.widget.ConstraintLayout")),
                    0
                )
            )
        )
        recyclerView.perform(actionOnItemAtPosition<ViewHolder>(0, click()))

        val materialButton = onView(
            allOf(
                withId(R.id.btn_comments), withText("Comments"),
                childAtPosition(
                    childAtPosition(
                        withClassName(`is`("android.widget.ScrollView")),
                        0
                    ),
                    3
                )
            )
        )
        materialButton.perform(scrollTo(), click())

        val textInputEditText = onView(
            allOf(
                withId(R.id.comment_text_field),
                childAtPosition(
                    childAtPosition(
                        withClassName(`is`("androidx.core.widget.NestedScrollView")),
                        0
                    ),
                    7
                ),
                isDisplayed()
            )
        )
        textInputEditText.perform(replaceText("Comment"), closeSoftKeyboard())

        val materialButton2 = onView(
            allOf(
                withId(R.id.btn_comment_submit), withText("Submit"),
                childAtPosition(
                    childAtPosition(
                        withClassName(`is`("androidx.core.widget.NestedScrollView")),
                        0
                    ),
                    8
                ),
                isDisplayed()
            )
        )
        materialButton2.perform(click())

        val textView = onView(
            allOf(
                withId(R.id.comment_comment), withText("Comment"),
                withParent(withParent(withId(R.id.comment_listview))),
                isDisplayed()
            )
        )
        textView.check(matches(withText("Comment")))

        val ratingBar = onView(
            allOf(
                withId(R.id.comment_taste),
                withParent(withParent(withId(R.id.comment_listview))),
                isDisplayed()
            )
        )
        ratingBar.check(matches(isDisplayed()))

        val ratingBar2 = onView(
            allOf(
                withId(R.id.comment_cost),
                withParent(withParent(withId(R.id.comment_listview))),
                isDisplayed()
            )
        )
        ratingBar2.check(matches(isDisplayed()))

        val ratingBar3 = onView(
            allOf(
                withId(R.id.comment_availability),
                withParent(withParent(withId(R.id.comment_listview))),
                isDisplayed()
            )
        )
        ratingBar3.check(matches(isDisplayed()))

        val ratingBar4 = onView(
            allOf(
                withId(R.id.comment_availability),
                withParent(withParent(withId(R.id.comment_listview))),
                isDisplayed()
            )
        )
        ratingBar4.check(matches(isDisplayed()))
    }

    private fun childAtPosition(
        parentMatcher: Matcher<View>, position: Int
    ): Matcher<View> {

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
