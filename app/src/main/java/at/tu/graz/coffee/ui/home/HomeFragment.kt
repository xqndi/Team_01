package at.tu.graz.coffee.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import at.tu.graz.coffee.model.Coffee
import at.tu.graz.coffee.R
import at.tu.graz.coffee.model.CoffeeData


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

        coffeeList = CoffeeData.getCoffees().toMutableList()

        val listView:ListView = root.findViewById(R.id.home_listview)
        listView.adapter = HomeAdapter(requireContext(), coffeeList)
        return root
    }
}