package at.tu.graz.coffee.ui.coffee_detail

import android.content.res.Resources
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
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

        val coffee = viewModel.getCoffee(args.coffeeId) ?: return

        val imgCoffee = view.findViewById<ImageView>(R.id.img_coffee)
        imgCoffee?.setImageResource(resources.getIdentifier(coffee.image,
            "drawable", activity?.packageName))

        val name = view.findViewById<TextView>(R.id.txt_coffee_name)
        name.text = coffee.name

        setEvaluation(coffee.evaluationTotal, "total")
        setEvaluation(coffee.evaluationTaste, "taste")
        setEvaluation(coffee.evaluationCost, "cost")
        setEvaluation(coffee.evaluationAvailability, "availability")

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

        val reviewButton = view.findViewById<Button>(R.id.btn_comments)
        reviewButton.setOnClickListener {
            val action = CoffeeDetailFragmentDirections.actionOpenDetails(coffee.coffeeId)
            Navigation.findNavController(view).navigate(action)
        }
    }

    private fun setEvaluation(value: Double, type: String) {
        for(i in 1..value.toInt()) {
            val imgStar = view?.findViewById<ImageView>(resources.getIdentifier(
                "img_" + type + "_star_$i", "id", activity?.packageName))

            imgStar?.setImageResource(R.drawable.star_full)
        }

        val imgStar = view?.findViewById<ImageView>(resources.getIdentifier(
            "img_" + type + "_star_${value.toInt() + 1}", "id", activity?.packageName))

        val decimal = value - value.toInt()
        if(decimal in 0.2..0.8) {
            imgStar?.setImageResource(R.drawable.star_half)
        } else if(decimal >= 0.8){
            imgStar?.setImageResource(R.drawable.star_full)
        }
    }
}