package at.tu.graz.coffee.model

import junit.framework.TestCase

class CoffeeTest : TestCase() {

    private val reviews : List<Review> = listOf(
/*        Review(1, 2,10,  "Just a comment"),
        Review(10, 3,4,  "Another comment"),
        Review(6, 5,5,  "1"),
        Review(1, 1,1,  "2"),
        Review(6, 6,2,  "3"),
        Review(1, 7,5,  "4"),
        Review(3, 4,7,  "5")*/
    )
    private val reviews_: MutableList<Review> = reviews.toMutableList()
    private val coffee: Coffee = Coffee(
        "My coffee",
        5.99,
        "Amazon",
        CoffeeType.MIXED,
        1.0,
        3,
        "Very good",
        "rocket_coffee"
        //, reviews_
    )


    fun testReview() {

        assertEquals(reviews[0], coffee.reviews[0])
        assertEquals(reviews[1], coffee.reviews[1])
        assertEquals(reviews[2], coffee.reviews[2])


        coffee.evaluationCost = 6.0
        coffee.evaluationTaste = 6.0
        coffee.evaluationAvailability = 3.0
        coffee.evaluationTotal = 5.0

        assertEquals(6.0, coffee.evaluationTaste, 0.1)
        assertEquals(6.0, coffee.evaluationCost, 0.1)
        assertEquals(3.0, coffee.evaluationAvailability, 0.1)
        assertEquals(5.0, coffee.evaluationTotal, 0.1)

        assertEquals(coffee.reviews.size, 7)

        assertEquals(coffee.reviews[0].availability, 10);
        assertEquals(coffee.reviews[1].taste, 10);
        assertEquals(coffee.reviews[2].comment, "1");
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
        assertEquals(4.285714285714286, coffee.evaluationTotal)
    }

    fun testGetReviews() {
        coffee.reviews.clear()

        assertEquals(0, coffee.reviews.size)

        val review = Review(5, 5, 5, "Review",0)

        coffee.addReview(review)

        assertEquals(1, coffee.reviews.size)
        assertEquals(review, coffee.reviews[0])
    }

    fun testGetImage() {
        assertEquals("rocket_coffee", coffee.image)
    }

    fun testGetId() {
        assertEquals(1, coffee.coffeeId)
    }
}