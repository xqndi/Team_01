package at.tu.graz.coffee.ui.home

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.ListView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import at.tu.graz.coffee.Coffee
import at.tu.graz.coffee.R

class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        homeViewModel =
                ViewModelProvider(this).get(HomeViewModel::class.java)

        val root = inflater.inflate(R.layout.fragment_home, container, false)
        var coffeeList = mutableListOf<Coffee>()
        coffeeList.add(Coffee("Caffe Crema", "9.7", R.drawable.spar_premium_caffe_crema))
        coffeeList.add(Coffee("Barista Espresso", "8.7", R.drawable.tchibo_barista_espresso))
        coffeeList.add(Coffee("Black and White", "7.7", R.drawable.tchibo_black_and_white))

        val listView:ListView = root.findViewById<ListView>(R.id.home_listview)
        listView.adapter = CostumeAdapter(requireContext(), coffeeList)
        return root
    }

    private class CostumeAdapter(context:Context, coffeeList:List<Coffee>): BaseAdapter() {
        private val mContext:Context
        private val mcoffeeList:List<Coffee>
        init{
            this.mContext = context
            this.mcoffeeList = coffeeList
        }
        override fun getCount(): Int {
            return 3
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
            ratingTextView.text = mcoffeeList[position].rating
            val imageView = homeRow.findViewById<ImageView>(R.id.home_imageView)
            imageView.setImageDrawable(mContext.resources.getDrawable(mcoffeeList[position].image))
            return homeRow
        }

    }



}

