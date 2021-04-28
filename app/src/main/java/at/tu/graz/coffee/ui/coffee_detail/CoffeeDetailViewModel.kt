package at.tu.graz.coffee.ui.coffee_detail

import androidx.lifecycle.ViewModel
import at.tu.graz.coffee.model.Coffee
import at.tu.graz.coffee.model.CoffeeData
import at.tu.graz.coffee.model.CoffeeType
import at.tu.graz.coffee.model.Review

class CoffeeDetailViewModel : ViewModel() {

    fun getCoffee(id: Int): Coffee? {
        return CoffeeData.getCoffee(id)
    }
}