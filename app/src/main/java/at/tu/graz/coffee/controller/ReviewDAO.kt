package at.tu.graz.coffee.controller

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import at.tu.graz.coffee.model.Review

interface ReviewDAO {
    @Query("SELECT * FROM review")
    fun getAll(): List<Review>

    @Query("SELECT * FROM coffee WHERE id IN (:reviewIds)")
    fun loadAllByIds(reviewIds: IntArray): List<Review>

    @Query("SELECT * FROM review WHERE comment LIKE :comment LIMIT 1")
    fun findByName(comment: String): Review

    @Insert
    fun insertAll(vararg reviews: Review)

    @Delete
    fun delete(reviews: Review)
}