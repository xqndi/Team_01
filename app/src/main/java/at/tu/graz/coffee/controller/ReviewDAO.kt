package at.tu.graz.coffee.controller

import androidx.room.*
import at.tu.graz.coffee.model.Review
import kotlinx.coroutines.flow.Flow

@Dao
interface ReviewDAO {
    @Query("SELECT * FROM review")
    fun getAll(): List<Review>

    @Insert
    fun insertAll(reviews: List<Review>)

    @Delete
    fun delete(reviews: Review)
}