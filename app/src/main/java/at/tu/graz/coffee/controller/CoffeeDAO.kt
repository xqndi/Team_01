package at.tu.graz.coffee.controller

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import at.tu.graz.coffee.model.Coffee

@Dao
interface CoffeeDAO {
    @Query("SELECT * FROM coffee")
    fun getAll(): List<Coffee>

    @Query("SELECT * FROM coffee WHERE id IN (:coffeeIds)")
    fun loadAllByIds(coffeeIds: IntArray): List<Coffee>

    @Query("SELECT * FROM coffee WHERE name LIKE :name LIMIT 1")
    fun findByName(name: String): Coffee

    @Insert
    fun insertAll(vararg coffees: Coffee)

    @Delete
    fun delete(coffees: Coffee)


}