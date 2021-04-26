package at.tu.graz.coffee.ui.home

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import at.tu.graz.coffee.model.Coffee
import at.tu.graz.coffee.model.CoffeeType
import at.tu.graz.coffee.R

class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel
    private var coffeeList = mutableListOf<Coffee>()

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        homeViewModel =
                ViewModelProvider(this).get(HomeViewModel::class.java)

        val root = inflater.inflate(R.layout.fragment_home, container, false)


        //create dummy data
        fillCoffeeliest()


        val listView:ListView = root.findViewById<ListView>(R.id.home_listview)
        listView.adapter = CostumeAdapter(requireContext(), coffeeList)
        return root
    }

    private fun fillCoffeeliest(){

        coffeeList.add(Coffee("Caffe Crema", 9.00, "Supermarket",
                CoffeeType.NONE, 1.00,1," ",
                R.drawable.spar_premium_caffe_crema ))
        coffeeList.add(Coffee("Barista Espresso", 3.50, "Supermarket",
                CoffeeType.NONE, 1.00,1," ",
                R.drawable.tchibo_barista_espresso ))
        coffeeList.add(Coffee("Black and White", 5.0, "Supermarket",
                CoffeeType.NONE, 1.00,1," ",
                R.drawable.tchibo_black_and_white ))
        coffeeList.add(Coffee("Caffe Crema", 9.00, "Supermarket",
                CoffeeType.NONE, 1.00,1," ",
                R.drawable.spar_premium_caffe_crema ))
        coffeeList.add(Coffee("Barista Espresso", 3.50, "Supermarket",
                CoffeeType.NONE, 1.00,1," ",
                R.drawable.tchibo_barista_espresso ))
        coffeeList.add(Coffee("Black and White", 5.0, "Supermarket",
                CoffeeType.NONE, 1.00,1," ",
                R.drawable.tchibo_black_and_white ))
        coffeeList.add(Coffee("Caffe Crema", 9.00, "Supermarket",
                CoffeeType.NONE, 1.00,1," ",
                R.drawable.spar_premium_caffe_crema ))
        coffeeList.add(Coffee("Barista Espresso", 3.50, "Supermarket",
                CoffeeType.NONE, 1.00,1," ",
                R.drawable.tchibo_barista_espresso ))
        coffeeList.add(Coffee("Black and White", 5.0, "Supermarket",
                CoffeeType.NONE, 1.00,1," ",
                R.drawable.tchibo_black_and_white ))
        coffeeList.add(Coffee("Black and White", 5.0, "Supermarket",
                CoffeeType.NONE, 1.00,1," ",
                R.drawable.tchibo_black_and_white ))
    }

    private class CostumeAdapter(context:Context, coffeeList:List<Coffee>): BaseAdapter() {
        private val mContext:Context
        private val mcoffeeList:List<Coffee>
        init{
            this.mContext = context
            this.mcoffeeList = coffeeList
        }
        override fun getCount(): Int {
            return 10
        }

        override fun getItem(p0: Int): Any {
            return "Test from getItem()"
        }

        override fun getItemId(position: Int): Long {
            return position.toLong()
        }

        override fun getView(position: Int, convertView: View?, viewGroup: ViewGroup?): View {
            val layoutInflater = LayoutInflater.from(mContext)
            val homeRow = layoutInflater.inflate(R.layout.home_row, viewGroup, false)
            val nameTextView = homeRow.findViewById<TextView>(R.id.home_textView_name)
            nameTextView.text = mcoffeeList[position].name
            val ratingTextView = homeRow.findViewById<TextView>(R.id.home_textView_rating)
            //TODO: rating is not implemented yet, so we use price to show the stars in the rating
            ratingTextView.text = mcoffeeList[position].price.toString()
            val imageView = homeRow.findViewById<ImageView>(R.id.home_imageView)
            imageView.setImageDrawable(mContext.resources.getDrawable(mcoffeeList[position].picture))
            val ratingBar = homeRow.findViewById<RatingBar>(R.id.home_ratingBar)
            ratingBar.rating = mcoffeeList[position].price.toFloat()
            return homeRow
        }

    }



}

