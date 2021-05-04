package at.tu.graz.coffee.ui.filter

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import at.tu.graz.coffee.R
import at.tu.graz.coffee.model.CoffeeData
import com.google.android.material.slider.RangeSlider


class FilterFragment : Fragment() {

    private lateinit var filterViewModel: FilterViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        filterViewModel =
            ViewModelProvider(this).get(FilterViewModel::class.java)
        return inflater.inflate(R.layout.fragment_filter, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val sliderTotal: RangeSlider = view.findViewById(R.id.slider_total)
        val sliderTaste: RangeSlider = view.findViewById(R.id.slider_taste)
        val sliderCost: RangeSlider = view.findViewById(R.id.slider_cost)
        val sliderAvailability: RangeSlider = view.findViewById(R.id.slider_availability)

        sliderTotal.setValues(0f, 10f)
        sliderTaste.setValues(0f, 10f)
        sliderCost.setValues(0f, 10f)
        sliderAvailability.setValues(0f, 10f)

        val filterButton: Button = view.findViewById(R.id.btn_filter)
        filterButton.setOnClickListener {
            val rangeTotal = sliderTotal.values
            val rangeTaste = sliderTaste.values
            val rangeCost = sliderCost.values
            val rangeAvailability = sliderAvailability.values

            val filteredCoffees = CoffeeData.filterCoffee(rangeTotal, rangeTaste, rangeCost,
                rangeAvailability)

            //TODO SHow Filtered-List (Should to be done in the Search-Issue
        }
    }
}