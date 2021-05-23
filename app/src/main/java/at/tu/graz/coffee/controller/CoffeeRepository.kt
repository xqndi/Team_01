package at.tu.graz.coffee.controller

import androidx.annotation.WorkerThread
import at.tu.graz.coffee.model.Coffee
import at.tu.graz.coffee.model.CoffeeWithReviews
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
}