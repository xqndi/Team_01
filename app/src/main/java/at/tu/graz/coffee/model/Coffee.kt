package at.tu.graz.coffee.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Coffee(
    @PrimaryKey val id: Int,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "price") val price: Double,
    @ColumnInfo(name = "store_to_buy_from") val storeToBuyFrom: String,
    @ColumnInfo(name = "coffee_type") val coffeeType: CoffeeType,
    @ColumnInfo(name = "quantity") val quantity: Double = -1.0,
    @ColumnInfo(name = "strength") val strength: Int = -1,
    @ColumnInfo(name = "additional_information") val additionalInformation: String = "",
    @ColumnInfo(name = "image") val image: String
) {

    var evaluationTotal: Double = 0.0
    var evaluationTaste: Double = 0.0
    var evaluationCost: Double = 0.0
    var evaluationAvailability: Double = 0.0

    var reviews: MutableList<Review> = mutableListOf()

    fun addReview(review: Review) {
        reviews.add(review)
        calculateNewEvaluation()
    }

    constructor(
        id: Int,
        name: String,
        price: Double,
        storeToBuyFrom: String,
        coffeeType: CoffeeType,
        quantity: Double = -1.0,
        strength: Int = -1,
        additionalInformation: String = "",
        image: String,
        reviews: MutableList<Review>
    ) : this(
        id,
        name,
        price,
        storeToBuyFrom,
        coffeeType,
        quantity,
        strength,
        additionalInformation,
        image
    ) {
        this.reviews = reviews
        calculateNewEvaluation()
    }

    fun calculateNewEvaluation() {
        evaluationTaste = 0.0
        evaluationCost = 0.0
        evaluationAvailability = 0.0

        for (review in reviews) {
            evaluationTaste += review.taste
            evaluationCost += review.cost
            evaluationAvailability += review.availability
        }

        evaluationTaste /= reviews.size
        evaluationCost /= reviews.size
        evaluationAvailability /= reviews.size

        evaluationTotal = (evaluationTaste + evaluationCost + evaluationAvailability) / 3.0
    }
}