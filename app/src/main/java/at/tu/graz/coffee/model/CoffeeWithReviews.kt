package at.tu.graz.coffee.model

import androidx.room.Embedded
import androidx.room.Relation


data class CoffeeWithReviews (
        @Embedded val coffee: Coffee,
        @Relation(
                parentColumn = "coffeeId",
                entityColumn = "coffeeCreatorId",
                entity = Review::class
        )
        val reviews: List<Review>
){
}