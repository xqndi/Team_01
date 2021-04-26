package at.tu.graz.coffee.model

import junit.framework.TestCase

class CoffeeTest : TestCase() {

    private val coffee: Coffee = Coffee("My coffee",
        5.99,
        "Amazon",
        CoffeeType.MIXED,
        1.0,
        3,
        "Very good",
         1)

    //TODO replace String with Review
    fun testAddReview() {
        coffee.addReview("First Review")
        coffee.addReview("Second Review")
        coffee.addReview("Third Review")

        assertEquals("First Review", coffee.reviews[coffee.reviews.size - 3])
        assertEquals("Second Review", coffee.reviews[coffee.reviews.size - 2])
        assertEquals("Third Review", coffee.reviews[coffee.reviews.size - 1])
    }

    fun testTestGetName() {
        assertEquals("My coffee", coffee.name)
    }

    fun testGetPrice() {
        assertEquals(5.99, coffee.price, 0.01)
    }

    fun testGetStoreToBuyFrom() {
        assertEquals("Amazon", coffee.storeToBuyFrom)
    }

    fun testGetCoffeeType() {
        assertEquals(CoffeeType.MIXED, coffee.coffeeType)
    }

    fun testGetQuantity() {
        assertEquals(1.0, coffee.quantity, 0.01)
    }

    fun testGetStrength() {
        assertEquals(3, coffee.strength)
    }

    fun testGetAdditionalInformation() {
        assertEquals("Very good", coffee.additionalInformation)
    }

    //TODO replace with calculated Evaluation
    fun testGetEvaluation() {
        assertEquals(0, coffee.evaluation)
    }

    //TODO replace String with Review
    fun testGetReviews() {
        coffee.reviews.clear()

        assertEquals(0, coffee.reviews.size)

        coffee.addReview("First Review")

        assertEquals(1, coffee.reviews.size)
        assertEquals("First Review", coffee.reviews[0])
    }
}