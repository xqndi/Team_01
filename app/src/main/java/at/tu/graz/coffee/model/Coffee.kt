package at.tu.graz.coffee.model

data class Coffee(val name: String,
                  val price: Double,
                  val storeToBuyFrom: String,
                  val coffeeType: CoffeeType,
                  val quantity: Double = -1.0,
                  val strength: Int = -1,
                  val additionalInformation: String = "",
                  val picture: Int) {

    var evaluation: Int = 0
    val reviews: MutableList<String> = mutableListOf() //TODO Replace String with Review Class

    fun addReview(review: String) {
        reviews.add(review)

        calculateNewEvaluation()
    }

    private fun calculateNewEvaluation() {
        //TODO got through review list and calculate average evaluation
        evaluation = 0
    }
}
