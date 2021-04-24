package at.tu.graz.coffee.ui.coffee_detail

import android.content.res.Resources
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import at.tu.graz.coffee.R

class CoffeeDetailFragment : Fragment() {
    private val viewModel: CoffeeDetailViewModel by viewModels()
    private val args: CoffeeDetailFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val res: Resources = resources

        val coffee = viewModel.getCoffee(args.coffeeId)

        val name = view.findViewById<TextView>(R.id.txt_coffee_name)
        name.text = coffee.name

        val totalEvaluation = view.findViewById<TextView>(R.id.txt_total_evaluation)
        totalEvaluation.text = coffee.evaluationTotal.toString()

        val tasteEvaluation = view.findViewById<TextView>(R.id.txt_taste_evaluation)
        tasteEvaluation.text = coffee.evaluationTaste.toString()

        val costEvaluation = view.findViewById<TextView>(R.id.txt_cost_evaluation)
        costEvaluation.text = coffee.evaluationCost.toString()

        val availabilityEvaluation = view.findViewById<TextView>(R.id.txt_availability_evaluation)
        availabilityEvaluation.text = coffee.evaluationAvailability.toString()

        val coffeeType = view.findViewById<TextView>(R.id.txt_coffee_type)
        coffeeType.text = coffee.coffeeType.text

        val storeToBuyFrom = view.findViewById<TextView>(R.id.txt_store_to_buy_from)
        storeToBuyFrom.text = coffee.storeToBuyFrom

        val price = view.findViewById<TextView>(R.id.txt_price)
        price.text = String.format(res.getString(R.string.price), coffee.price)

        val quantity = view.findViewById<TextView>(R.id.txt_quantity)
        quantity.text = String.format(res.getString(R.string.quantity), coffee.quantity)

        val strength = view.findViewById<TextView>(R.id.txt_strength)
        strength.text = coffee.strength.toString()

        val additionalInformation = view.findViewById<TextView>(R.id.txt_additional_information)
        additionalInformation.text = coffee.additionalInformation
    }
}