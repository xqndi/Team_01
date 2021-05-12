package at.tu.graz.coffee.controller

import androidx.room.Database
import androidx.room.RoomDatabase
import at.tu.graz.coffee.model.Coffee
import at.tu.graz.coffee.model.Review

@Database(entities = [Coffee::class, Review::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun coffeeDAO(): CoffeeDAO
    abstract fun reviewDAO(): ReviewDAO
}
