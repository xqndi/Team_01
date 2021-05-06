package at.tu.graz.coffee.ui.coffee_detail

import android.os.Bundle
import androidx.navigation.NavDirections
import at.tu.graz.coffee.R

class CoffeeDetailFragmentDirections private constructor() {
    private data class ActionOpenDetails(
        public val coffeeId: Int = -1
    ) : NavDirections {
        public override fun getActionId(): Int = R.id.commentFragment

        public override fun getArguments(): Bundle {
            val result = Bundle()
            result.putInt("coffeeId", this.coffeeId)
            return result
        }
    }

    public companion object {
        public fun actionOpenDetails(coffeeId: Int = -1): NavDirections = ActionOpenDetails(coffeeId)
    }
}