package at.tu.graz.coffee.model
import android.content.Context
import at.tu.graz.coffee.MainActivity

object CoffeeData {
    private val reviews : List<Review> = listOf(
/*        Review(1, 2,10,  "Just a comment"),
        Review(10, 3,4,  "Another comment"),
        Review(6, 5,5,  "1"),
        Review(1, 1,1,  "2"),
        Review(6, 6,2,  "3"),
        Review(1, 7,5,  "4"),
        Review(3, 4,7,  "5")*/
    )
    private val coffees : List<Coffee> = listOf(
        Coffee("Caffe Crema", 9.00, "Supermarket",
            CoffeeType.NONE, 1.00,1," ",
            "spar_premium_caffe_crema", reviews as MutableList<Review>
        ),
        Coffee("Barista Espresso", 3.50, "Amazon",
            CoffeeType.NONE, 1.00,1," ",
            "tchibo_barista_espresso"),
        Coffee("Black and White", 5.0, "Billa",
            CoffeeType.NONE, 1.00,1," ",
            "tchibo_black_and_white",reviews as MutableList<Review> ),
        Coffee("Caffe Crema", 9.00, "Spar",
            CoffeeType.NONE, 1.00,1," ",
            "spar_premium_caffe_crema",reviews as MutableList<Review> ),
        Coffee("Barista Espresso", 3.50, "Supermarket",
            CoffeeType.NONE, 1.00,1," ",
            "tchibo_barista_espresso",reviews as MutableList<Review> ),
        Coffee("Black and White", 5.0, "Amazon",
            CoffeeType.NONE, 1.00,1," ",
            "tchibo_black_and_white",reviews as MutableList<Review> ),
        Coffee("Caffe Crema", 9.00, "Billa",
            CoffeeType.NONE, 1.00,1," ",
            "spar_premium_caffe_crema" ,reviews as MutableList<Review>),
        Coffee("Barista Espresso", 3.50, "Spar",
            CoffeeType.NONE, 1.00,1," ",
            "tchibo_barista_espresso",reviews as MutableList<Review> ),
        Coffee("Black and White", 5.0, "Supermarket",
            CoffeeType.NONE, 1.00,1," ",
            "tchibo_black_and_white",reviews as MutableList<Review> ),
        Coffee("Black and White", 5.0, "Supermarket",
            CoffeeType.NONE, 1.00,1," ",
            "tchibo_black_and_white" ,reviews as MutableList<Review>),
    )

    fun storeCoffeeInDatabase(){

    }

    fun getCoffees() : List<Coffee> {
        return coffees;
    }

    fun getCoffee(id: Int) : Coffee? {
        val coffeeList = coffees.filter{it.coffeeId == id}

        if(coffeeList.isNullOrEmpty()) {
            return null;
        }
        return coffeeList[0]
    }

    fun getCoffeeList(idArray: IntArray?) : MutableList<Coffee> {
        val coffeeList: MutableList<Coffee> = mutableListOf()

        coffees.forEach{
            if(idArray?.contains(it.coffeeId) == true) {
                coffeeList.add(it)
            }
        }

        return coffeeList
    }

    fun getStoresOfAllCoffees() : ArrayList<String> {
        val coffeeStores: ArrayList<String> = ArrayList()

        coffees.forEach{
            if(it.storeToBuyFrom !in coffeeStores) {
                coffeeStores.add(it.storeToBuyFrom)
            }
        }
        return coffeeStores
    }

    fun filterCoffee(rangeTotal: List<Float>, rangeTaste: List<Float>, rangeCost: List<Float>,
                     rangeAvailability: List<Float>, selectedStore: String, searchText: String) : List<Int> {
        val filteredCoffees: MutableList<Int> = mutableListOf()

        coffees.forEach{
            if(it.evaluationTotal >= rangeTotal[0] && it.evaluationTotal <= rangeTotal[1] &&
                it.evaluationTaste >= rangeTaste[0] && it.evaluationTaste <= rangeTaste[1] &&
                it.evaluationCost >= rangeCost[0] && it.evaluationCost <= rangeCost[1] &&
                it.evaluationAvailability >= rangeAvailability[0] &&
                it.evaluationAvailability <= rangeAvailability[1] &&
                (it.storeToBuyFrom == selectedStore || selectedStore == "") &&
                (it.name.contains(searchText, ignoreCase = true) || searchText == "")){

                filteredCoffees.add(it.coffeeId)
            }
        }
        return filteredCoffees
    }
}