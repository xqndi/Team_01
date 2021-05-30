package at.tu.graz.coffee.controller

import androidx.room.*
import at.tu.graz.coffee.model.Review
import kotlinx.coroutines.flow.Flow

@Dao
interface ReviewDAO {
    @Query("SELECT * FROM review")
    fun getAll(): List<Review>

/*    @Query("SELECT * FROM coffee WHERE id IN (:reviewIds)")
    fun loadAllByIds(reviewIds: IntArray): List<Review>

    @Query("SELECT * FROM review WHERE comment LIKE :comment LIMIT 1")
    fun findByName(comment: String): Review*/

    @Insert
    fun insertAll(reviews: List<Review>)

    @Delete
    fun delete(reviews: Review)
}