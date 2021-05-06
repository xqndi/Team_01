package at.tu.graz.coffee.ui.filter_result

import androidx.lifecycle.ViewModel
import at.tu.graz.coffee.model.Coffee
import at.tu.graz.coffee.model.CoffeeData

class FilterResultViewModel : ViewModel() {

    fun getCoffees(idArray: IntArray?): MutableList<Coffee> {
        return CoffeeData.getCoffeeList(idArray)
    }
}