package at.tu.graz.coffee.controller

import androidx.room.*
import at.tu.graz.coffee.model.Coffee
import at.tu.graz.coffee.model.CoffeeWithReviews
import at.tu.graz.coffee.model.Review

@Dao
interface CoffeeDAO {
    @Transaction
    @Query("SELECT * FROM coffee")
    fun getAll(): List<CoffeeWithReviews>

    @Insert
    fun insertCoffee(coffee: Coffee): Long

    @Insert
    fun insertReviewList(reviews: List<Review>)

    @Transaction
    fun addCoffeeWithReviews(coffee: Coffee, reviews: List<Review>){
        val listId = insertCoffee(coffee)
        reviews.forEach{it.coffeeCreatorId = listId.toInt() }
        insertReviewList(reviews)
    }
/*
    @Query("SELECT * FROM coffee WHERE coffeeId IN (:coffeeIds)")
    fun loadAllByIds(coffeeIds: IntArray): List<Coffee>

    @Query("SELECT * FROM coffee WHERE name LIKE :name LIMIT 1")
    fun findByName(name: String): Coffee

    @Insert
    fun insertAll(vararg coffees: CoffeeWithReviews)

    @Delete
    fun delete(coffees: Coffee)*/


}