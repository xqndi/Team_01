package at.tu.graz.coffee.ui.comment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import at.tu.graz.coffee.R
import at.tu.graz.coffee.model.CoffeeData
import at.tu.graz.coffee.model.Review
import at.tu.graz.coffee.ui.coffee_detail.CoffeeDetailFragmentArgs
import at.tu.graz.coffee.ui.home.HomeAdapter

class CommentFragment : Fragment() {
    private val viewModel: CommentViewModel by viewModels()
    private val args: CoffeeDetailFragmentArgs by navArgs()
    private var reviewsList  = mutableListOf<Review>()

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        (activity as AppCompatActivity).supportActionBar?.title = "Comments"

        val root = inflater.inflate(R.layout.fragment_comment, container, false)

        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val coffeeName = view.findViewById<TextView>(R.id.comment_coffee_name)

        val coffee = viewModel.getCoffee(args.coffeeId) ?: return
        coffeeName.text = coffee.name

        reviewsList = (viewModel.getCoffee(args.coffeeId)?.reviews) as MutableList<Review>

        val listView: ListView = view.findViewById(R.id.comment_listview)
        listView.adapter = CommentAdapter(requireContext(), reviewsList)
    }
}