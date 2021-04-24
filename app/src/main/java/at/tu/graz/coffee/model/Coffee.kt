package at.tu.graz.coffee.model

data class Coffee(val name: String,
                  val price: Double,
                  val storeToBuyFrom: String,
                  val coffeeType: CoffeeType,
                  val quantity: Double = -1.0,
                  val strength: Int = -1,
                  val additionalInformation: String = "") {

    var evaluationTotal: Double = 0.0
    var evaluationTaste: Double = 0.0
    var evaluationCost: Double = 0.0
    var evaluationAvailability: Double = 0.0

    val reviews: MutableList<Review> = mutableListOf()

    fun addReview(review: Review) {
        reviews.add(review)
        calculateNewEvaluation()
    }

    private fun calculateNewEvaluation() {
        evaluationTaste = 0.0
        evaluationCost = 0.0
        evaluationAvailability = 0.0

        for(review in reviews) {
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
