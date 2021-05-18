package at.tu.graz.coffee.controller

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import at.tu.graz.coffee.model.Coffee
import at.tu.graz.coffee.model.CoffeeWithReviews
import at.tu.graz.coffee.model.Review

@Database(entities = [Coffee::class, Review::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun coffeeDAO(): CoffeeDAO
    abstract fun reviewDAO(): ReviewDAO

    companion object {
        var TEST_MODE = false
        private val databaseName = "coffeeDatabase"

        private var db: AppDatabase? = null
        private var dbInstanceCoffee: CoffeeDAO? = null
        private var dbInstanceReview: ReviewDAO? = null

        fun getCoffeeInstance(context: Context): CoffeeDAO {
            if (dbInstanceCoffee == null) {
                if (TEST_MODE) {
                    db = Room.inMemoryDatabaseBuilder(context, AppDatabase::class.java).allowMainThreadQueries().build()
                    dbInstanceCoffee = db?.coffeeDAO()
                } else {
                    db = Room.databaseBuilder(context, AppDatabase::class.java, databaseName).build()
                    dbInstanceCoffee = db?.coffeeDAO()
                }
            }
            return dbInstanceCoffee!!;
        }

        fun getReviewInstance(context: Context): ReviewDAO {
            if (dbInstanceReview == null) {
                if (TEST_MODE) {
                    db = Room.inMemoryDatabaseBuilder(context, AppDatabase::class.java).allowMainThreadQueries().build()
                    dbInstanceReview = db?.reviewDAO()
                } else {
                    db = Room.databaseBuilder(context, AppDatabase::class.java, databaseName).build()
                    dbInstanceReview = db?.reviewDAO()
                }
            }
            return dbInstanceReview!!;
        }

        private fun close() {
            db?.close()
        }
    }
}
