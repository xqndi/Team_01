package at.tu.graz.coffee.model
import android.content.Context
import androidx.lifecycle.MutableLiveData
import at.tu.graz.coffee.controller.AppDatabase

object CoffeeData {
    fun getCoffeeList(idArray: IntArray?) : MutableList<Coffee> {
        val coffeeList: MutableList<Coffee> = mutableListOf()

        // TODO: Change this
//        coffees.forEach{
//            if(idArray?.contains(it.coffeeId) == true) {
//                coffeeList.add(it)
//            }
//        }

        return coffeeList
    }

    fun getStoresOfAllCoffees() : ArrayList<String> {
        val coffeeStores: ArrayList<String> = ArrayList()

        // TODO: Change this

//        coffees.forEach{
//            if(it.storeToBuyFrom !in coffeeStores) {
//                coffeeStores.add(it.storeToBuyFrom)
//            }
//        }
        return coffeeStores
    }

    fun filterCoffee(rangeTotal: List<Float>, rangeTaste: List<Float>, rangeCost: List<Float>,
                     rangeAvailability: List<Float>, selectedStore: String, searchText: String) : List<Int> {
        val filteredCoffees: MutableList<Int> = mutableListOf()

        // TODO: Change this
//        coffees.forEach{
//            if(it.evaluationTotal >= rangeTotal[0] && it.evaluationTotal <= rangeTotal[1] &&
//                it.evaluationTaste >= rangeTaste[0] && it.evaluationTaste <= rangeTaste[1] &&
//                it.evaluationCost >= rangeCost[0] && it.evaluationCost <= rangeCost[1] &&
//                it.evaluationAvailability >= rangeAvailability[0] &&
//                it.evaluationAvailability <= rangeAvailability[1] &&
//                (it.storeToBuyFrom == selectedStore || selectedStore == "") &&
//                (it.name.contains(searchText, ignoreCase = true) || searchText == "" ||
//                        checkReviews(it, searchText))){
//
//                filteredCoffees.add(it.coffeeId)
//            }
//        }
        return filteredCoffees
    }

    fun checkReviews(coffee: Coffee, searchText: String) : Boolean {
        /*coffee.reviews.forEach{
            if(it.comment.contains(searchText, ignoreCase = true)) {
                return true
            }
        }*/
        return false
    }
}