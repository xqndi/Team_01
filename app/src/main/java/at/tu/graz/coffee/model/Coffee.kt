package at.tu.graz.coffee.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey

@Entity(tableName = "coffee")
data class Coffee(
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "price") val price: Double,
    @ColumnInfo(name = "store_to_buy_from") val storeToBuyFrom: String,
    @ColumnInfo(name = "coffee_type") val coffeeType: CoffeeType,
    @ColumnInfo(name = "quantity") val quantity: Double = -1.0,
    @ColumnInfo(name = "strength") val strength: Int = -1,
    @ColumnInfo(name = "additional_information") val additionalInformation: String = "",
    @ColumnInfo(name = "image") val image: String
) {
    @PrimaryKey(autoGenerate = true) var coffeeId: Int = 0
    var evaluationTotal: Double = 0.0
    var evaluationTaste: Double = 0.0
    var evaluationCost: Double = 0.0
    var evaluationAvailability: Double = 0.0
}