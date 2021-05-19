package at.tu.graz.coffee.ui.add_coffee

import android.app.Activity
import android.app.Activity.RESULT_OK
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import at.tu.graz.coffee.R
import at.tu.graz.coffee.model.CoffeeType
import kotlinx.android.synthetic.main.fragment_add_coffee.*
import kotlinx.android.synthetic.main.fragment_filter_result.*


class AddCoffeeFragment : Fragment() {

    private lateinit var addCoffeeViewModel: AddCoffeeViewModel

    private var uriPicture: Uri? = null

    private val pictureSelector = 100

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

        button_addCoffee.setOnClickListener{
            if(coffee_name.text.isEmpty()) {
                mandatory_field.visibility = View.VISIBLE
                coffee_name.setBackgroundColor(Color.RED)
            }
            else {
                mandatory_field.visibility = View.GONE
                coffee_name.setBackgroundColor(Color.WHITE)
            }
            if(coffee_shop.text.isEmpty()) {
                mandatory_field.visibility = View.VISIBLE
                coffee_shop.setBackgroundColor(Color.RED)
            }
            else {
                mandatory_field.visibility = View.GONE
                coffee_shop.setBackgroundColor(Color.WHITE)
            }
            if(coffee_price.text.isEmpty()) {
                mandatory_field.visibility = View.VISIBLE
                coffee_price.setBackgroundColor(Color.RED)
            }
            else {
                mandatory_field.visibility = View.GONE
                coffee_price.setBackgroundColor(Color.WHITE)
            }
            if(imageView.drawable == null) {
                mandatory_field.visibility = View.VISIBLE
                button_addPicture.setBackgroundColor(Color.RED)
            }
            else {
                mandatory_field.visibility = View.GONE
                button_addPicture.setBackgroundColor(resources.getColor(R.color.purple_500))
            }
        }

        button_addPicture.setOnClickListener{
            val phonePictures = Intent(Intent.ACTION_PICK,
                    MediaStore.Images.Media.INTERNAL_CONTENT_URI)
                    startActivityForResult(phonePictures, pictureSelector)
        }

        // Finally, data bind the spinner object with adapter
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
    override fun onActivityResult(neededPart: Int, outcomePart: Int, info: Intent?) {
        super.onActivityResult(neededPart, outcomePart, info)

        if (neededPart == pictureSelector) {
            if (outcomePart == RESULT_OK) {
                uriPicture = info?.data
                imageView.setImageURI(uriPicture)
            }
        }
    }
}