package at.tu.graz.coffee


import android.view.View
import android.view.ViewGroup
import androidx.test.espresso.Espresso.onData
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.filters.LargeTest
import androidx.test.rule.ActivityTestRule
import androidx.test.runner.AndroidJUnit4
import org.hamcrest.Description
import org.hamcrest.Matcher
import org.hamcrest.Matchers.*
import org.hamcrest.TypeSafeMatcher
import org.hamcrest.core.IsInstanceOf
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@LargeTest
@RunWith(AndroidJUnit4::class)
class DetailPageTest {

    @Rule
    @JvmField
    var mActivityTestRule = ActivityTestRule(MainActivity::class.java)

    @Test
    fun detailPageTest() {
        val constraintLayout = onData(anything())
            .inAdapterView(
                allOf(
                    withId(R.id.home_listview),
                    childAtPosition(
                        withClassName(`is`("androidx.constraintlayout.widget.ConstraintLayout")),
                        0
                    )
                )
            )
            .atPosition(0)
        constraintLayout.perform(click())

        val textView = onView(
            allOf(
                withId(R.id.txt_price), withText("9,00 €"),
                withParent(withParent(IsInstanceOf.instanceOf(android.widget.TableLayout::class.java))),
                isDisplayed()
            )
        )
        textView.check(matches(withText("9,00 €")))

        val textView2 = onView(
            allOf(
                withId(R.id.txt_quantity), withText("1,00 kg"),
                withParent(withParent(IsInstanceOf.instanceOf(android.widget.TableLayout::class.java))),
                isDisplayed()
            )
        )
        textView2.check(matches(withText("1,00 kg")))

        val textView3 = onView(
            allOf(
                withId(R.id.txt_strength), withText("1"),
                withParent(withParent(IsInstanceOf.instanceOf(android.widget.TableLayout::class.java))),
                isDisplayed()
            )
        )
        textView3.check(matches(withText("1")))

        val textView4 = onView(
            allOf(
                withId(R.id.txt_strength), withText("1"),
                withParent(withParent(IsInstanceOf.instanceOf(android.widget.TableLayout::class.java))),
                isDisplayed()
            )
        )
        textView4.check(matches(withText("1")))

        val textView5 = onView(
            allOf(
                withId(R.id.txt_strength), withText("1"),
                withParent(withParent(IsInstanceOf.instanceOf(android.widget.TableLayout::class.java))),
                isDisplayed()
            )
        )
        textView5.check(matches(withText("1")))
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
