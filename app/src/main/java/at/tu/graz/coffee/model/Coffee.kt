package at.tu.graz.coffee.model

data class Coffee(
    val id: Int,
    val name: String,
    val price: Double,
    val storeToBuyFrom: String,
    val coffeeType: CoffeeType,
    val quantity: Double = -1.0,
    val strength: Int = -1,
    val additionalInformation: String = "",
    val image: String
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