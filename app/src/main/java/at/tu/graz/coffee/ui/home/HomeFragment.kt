package at.tu.graz.coffee.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.annotation.Nullable
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import at.tu.graz.coffee.R
import at.tu.graz.coffee.model.Coffee
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
        val listView:ListView = root.findViewById(R.id.home_listview)

        listView.adapter = HomeAdapter(requireContext(), coffeeList)


        // FIXME: 23.05.21  
        val coffeeListObserver: Observer<List<Coffee>> = listOf<Coffee>() : Observer<List<Coffee>>() {
            fun onChanged(@Nullable newName: String?) {
                // Update the UI, in this case, a TextView.
                mNameTextView.setText(newName)
            }
        }


        mWordViewModel.getAllWords().observe(this, object : Observer<List<Word?>?>() {
            fun onChanged(@Nullable words: List<Word?>?) {
                // Update the cached copy of the words in the adapter.
                adapter.setWords(words)
            }
        })

        var localCoffeeList = CoffeeData.getCoffees(context)
        coffeeList =


        return root
    }
}
