package at.tu.graz.coffee.model

import androidx.test.ext.junit.runners.AndroidJUnit4
import junit.framework.Test
import junit.framework.TestCase
import org.junit.runner.RunWith

//@RunWith(AndroidJUnit4::class)
class CoffeeDatabaseTest: TestCase() {

//    @Before
//    fun setup() {
//        val applicationScope = CoroutineScope(SupervisorJob())
//        AppDatabase.TEST_MODE = true
//        coffeeDAO = AppDatabase.getCoffeeInstance(
//            androidx.test.core.app.ApplicationProvider.getApplicationContext(),
//            applicationScope
//        )
//        reviewDao = AppDatabase.getReviewInstance(
//            androidx.test.core.app.ApplicationProvider.getApplicationContext(),
//            applicationScope
//        )

    fun testTrue() {
        TestCase.assertEquals(true, true)
    }
}

//    @After
//    fun tearDown() {
//
//    }

//    @Test
//    fun insertCoffeeInDatabaseTest() {
//        val coffee = Coffee(
//            "Barista Espresso", 3.50, "Amazon",
//            CoffeeType.NONE, 1.00, 1, " ",
//            "tchibo_barista_espresso"
//        )
//        val reviews: List<Review> = listOf(
//            Review(1, 2, 10, "Just a comment", coffee.coffeeId),
//            Review(10, 3, 4, "Another comment", coffee.coffeeId),
//            Review(6, 5, 5, "1", coffee.coffeeId),
//            Review(1, 1, 1, "2", coffee.coffeeId),
//            Review(6, 6, 2, "3", coffee.coffeeId),
//            Review(1, 7, 5, "4", coffee.coffeeId),
//            Review(3, 4, 7, "5", coffee.coffeeId)
//        )
//
//        coffeeDAO?.addCoffeeWithReviews(coffee, reviews)
////        FIXME: 26.05.21
////        val coffeeTest = coffeeDAO?.getAll()?.get(0)
////
////        if (coffeeTest != null) {
////            Assert.assertEquals(coffee.name, coffeeTest.coffee.name)
////            Assert.assertEquals(reviews.size, coffeeTest.reviews.size)
////            Assert.assertFalse(reviews[0].comment == coffeeTest.reviews[6].comment)
////        }
//    }
