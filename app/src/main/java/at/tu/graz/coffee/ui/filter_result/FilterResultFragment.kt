package at.tu.graz.coffee.ui.filter_result

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import at.tu.graz.coffee.R
import at.tu.graz.coffee.model.Coffee


class FilterResultFragment : Fragment() {

    private val args: FilterResultFragmentArgs by navArgs()
    private lateinit var filterResultViewModel: FilterResultViewModel
    private var coffeeList = mutableListOf<Coffee>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        filterResultViewModel =
            ViewModelProvider(this).get(FilterResultViewModel::class.java)

        val root = inflater.inflate(R.layout.fragment_filter_result, container, false)

        // FIXME: 23.05.21
//        coffeeList = filterResultViewModel.getCoffees(args.filteredCoffeeList)

        val listView:ListView = root.findViewById(R.id.filter_result_listview)
        val empty = root.findViewById(R.id.empty) as TextView
        listView.emptyView = empty
        listView.adapter = FilterResultAdapter(requireContext(), coffeeList)
        return root
    }
}