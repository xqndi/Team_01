package at.tu.graz.coffee.ui.coffee_detail

import androidx.lifecycle.ViewModel
import at.tu.graz.coffee.model.Coffee
import at.tu.graz.coffee.model.CoffeeType
import at.tu.graz.coffee.model.Review

class CoffeeDetailViewModel : ViewModel() {

    fun getCoffee(id: Int): Coffee {
        //TODO select Coffee with the given id from the local data
        val coffee = Coffee("Test Coffee", 5.99, "Amazon",
                CoffeeType.ARABICA, 1000.0, 3,
                "Very good in the Morning", imageId = "rocket_coffee")
        coffee.addReview(Review(5,7,9))
        coffee.addReview(Review(4,3,9))
        return coffee
    }
}