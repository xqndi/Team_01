package at.tu.graz.coffee.ui.comment

import androidx.lifecycle.ViewModel
import at.tu.graz.coffee.model.Coffee
import at.tu.graz.coffee.model.CoffeeData

class CommentViewModel : ViewModel() {
    fun getCoffee(id: Int):Coffee? {
        return CoffeeData.getCoffee(id)
    }
}