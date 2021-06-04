package at.tu.graz.coffee.businessLogic

import android.content.Context
import at.tu.graz.coffee.R
import at.tu.graz.coffee.model.CoffeeType

class CoffeeTypeHelper {
    companion object {
        fun getCoffeeTypeStringList(context: Context): List<String> {
            return listOf(
                context.getString(R.string.none),
                context.getString(R.string.robusta),
                context.getString(R.string.arabica),
                context.getString(R.string.mixed)
            )
        }

        fun getCoffeeTypeName(context: Context, coffeeType: CoffeeType): String {
            when (coffeeType) {
                CoffeeType.NONE -> return context.getString(R.string.none)
                CoffeeType.ARABICA -> return context.getString(R.string.arabica)
                CoffeeType.MIXED -> return context.getString(R.string.mixed)
                CoffeeType.ROBUSTA -> return context.getString(R.string.robusta)
            }
        }
    }
}