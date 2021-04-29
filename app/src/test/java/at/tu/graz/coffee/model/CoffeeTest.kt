package at.tu.graz.coffee.model

import junit.framework.TestCase

class CoffeeTest : TestCase() {

    private val coffee: Coffee = Coffee(1,
        "My coffee",
        5.99,
        "Amazon",
        CoffeeType.MIXED,
        1.0,
        3,
        "Very good",
        "rocket_coffee")

    fun testAddReview() {
        val firstReview = Review(5, 5, 2, "First Review")
        val secondReview = Review(6, 6, 3, "Second Review")
        val thirdReview = Review(7, 7, 4, "Third Review")

        coffee.addReview(firstReview)
        coffee.addReview(secondReview)
        coffee.addReview(thirdReview)

        assertEquals(firstReview, coffee.reviews[coffee.reviews.size - 3])
        assertEquals(secondReview, coffee.reviews[coffee.reviews.size - 2])
        assertEquals(thirdReview, coffee.reviews[coffee.reviews.size - 1])

        assertEquals(6.0, coffee.evaluationTaste, 0.1)
        assertEquals(6.0, coffee.evaluationCost, 0.1)
        assertEquals(3.0, coffee.evaluationAvailability, 0.1)
        assertEquals(5.0, coffee.evaluationTotal, 0.1)
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

    fun testGetEvaluation() {
        coffee.reviews.clear()
        assertEquals(0.0, coffee.evaluationTotal)
    }

    fun testGetReviews() {
        coffee.reviews.clear()

        assertEquals(0, coffee.reviews.size)

        val review = Review(5, 5, 5, "Review")

        coffee.addReview(review)

        assertEquals(1, coffee.reviews.size)
        assertEquals(review, coffee.reviews[0])
    }

    fun testGetImage() {
        assertEquals("rocket_coffee", coffee.image)
    }

    fun testGetId() {
        assertEquals(1, coffee.id)
    }
}