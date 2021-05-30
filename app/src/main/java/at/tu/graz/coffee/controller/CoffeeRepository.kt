package at.tu.graz.coffee.controller

import androidx.annotation.WorkerThread
import at.tu.graz.coffee.model.Coffee
import at.tu.graz.coffee.model.CoffeeWithReviews
import at.tu.graz.coffee.model.Review
import kotlinx.coroutines.flow.Flow

class CoffeeRepository(private val coffeeDAO: CoffeeDAO, private val reviewDAO: ReviewDAO) {

    val allCoffees: Flow<List<CoffeeWithReviews>> = coffeeDAO.getAll()

    fun getCoffee(id: Int): Flow<CoffeeWithReviews> {
        return coffeeDAO.getById(id)
    }

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun insert(coffee: Coffee) {
        coffeeDAO.insertCoffee(coffee)
    }

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun insertReview(coffee: CoffeeWithReviews, reviews: List<Review>) {
        reviewDAO.insertAll(reviews)
        calculateNewEvaluation(coffee)
    }

    fun calculateNewEvaluation(coffee: CoffeeWithReviews) {
        var evaluationTaste = 0.0
        var evaluationCost = 0.0
        var evaluationAvailability = 0.0
        val reviews = coffee.reviews

        for (review in reviews) {
            evaluationTaste += review.taste
            evaluationCost += review.cost
            evaluationAvailability += review.availability
        }

        coffee.coffee.evaluationTaste = evaluationTaste / reviews.size
        coffee.coffee.evaluationCost = evaluationCost / reviews.size
        coffee.coffee.evaluationAvailability = evaluationAvailability / reviews.size

        coffee.coffee.evaluationTotal =
            (coffee.coffee.evaluationTaste + coffee.coffee.evaluationCost + coffee.coffee.evaluationAvailability) / 3.0

        coffeeDAO.updateCoffee(coffee.coffee)
    }
}