package at.tu.graz.coffee.ui.coffee_detail

import androidx.lifecycle.ViewModel
import at.tu.graz.coffee.model.Coffee
import at.tu.graz.coffee.model.CoffeeType

class CoffeeDetailViewModel : ViewModel() {

    fun getCoffee(id: Int): Coffee {
        //TODO select Coffee with the given id from the local data
        return Coffee("Test Coffee", 5.99, "Amazon", CoffeeType.ARABICA, 1000.0, 3, "Very good in the Morning")
    }
}