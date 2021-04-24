package at.tu.graz.coffee.model

import at.tu.graz.coffee.model.Review
import junit.framework.TestCase
import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ReviewTest {

    @Test
    fun TasteTest() {
       val r = Review(10,10,10);
        assertEquals(r.taste, 10);
    }
    @Test
    fun CostTest() {
        val r = Review(10,10,10);
        assertEquals(r.cost, 10);
    }
    @Test
    fun AvailabilityTest() {
        val r = Review(10,10,10);
        assertEquals(r.availability, 10);
    }
}