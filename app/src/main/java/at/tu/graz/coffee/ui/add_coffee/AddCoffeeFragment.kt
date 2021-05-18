package at.tu.graz.coffee.ui.add_coffee

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import at.tu.graz.coffee.R
import at.tu.graz.coffee.model.CoffeeType
import kotlinx.android.synthetic.main.fragment_add_coffee.*
import kotlinx.android.synthetic.main.fragment_support.*


class AddCoffeeFragment : Fragment() {

    private lateinit var addCoffeeViewModel: AddCoffeeViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        addCoffeeViewModel =
            ViewModelProvider(this).get(AddCoffeeViewModel::class.java)

        return inflater.inflate(R.layout.fragment_add_coffee, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val adapter = ArrayAdapter(
            requireContext(), // Context
            android.R.layout.simple_spinner_item, // Layout
            CoffeeType.values() // Array
        )
        adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line)

        // Finally, data bind the spinner object with dapter
        spinner?.adapter = adapter;

        // Set an on item selected listener for spinner object
        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>,
                view: View,
                position: Int,
                id: Long
            ) {
                // Display the selected item text on text view
                //text_view.text = "Spinner selected : ${parent.getItemAtPosition(position).toString()}"
            }

            override fun onNothingSelected(parent: AdapterView<*>) {
                // Another interface callback
            }

        }
    }
}