package at.tu.graz.coffee.controller

import androidx.room.*
import at.tu.graz.coffee.model.Coffee
import at.tu.graz.coffee.model.CoffeeWithReviews
import at.tu.graz.coffee.model.Review
import kotlinx.coroutines.flow.Flow

@Dao
interface CoffeeDAO {
    @Transaction
    @Query("SELECT * FROM coffee")
    fun getAll(): Flow<List<CoffeeWithReviews>>

    @Transaction
    @Query("SELECT * FROM coffee WHERE coffeeId LIKE :id")
    fun getById(id: Int): Flow<CoffeeWithReviews>

    @Insert
    fun insertCoffee(coffee: Coffee): Long

    @Update
    fun updateCoffee(coffee: Coffee): Int

    @Transaction
    fun addCoffeeWithReviews(coffee: Coffee, reviews: List<Review>){
        val listId = insertCoffee(coffee)
        reviews.forEach{it.coffeeCreatorId = listId.toInt() }
        insertReviewList(reviews)
    }

    @Insert
    fun insertReviewList(reviews: List<Review>)

    /*
    @Query("SELECT * FROM coffee WHERE coffeeId IN (:coffeeIds)")
    fun loadAllByIds(coffeeIds: IntArray): List<Coffee>

    @Query("SELECT * FROM coffee WHERE name LIKE :name LIMIT 1")
    fun findByName(name: String): Coffee

    @Insert
    fun insertAll(vararg coffees: CoffeeWithReviews)*/
}