package at.tu.graz.coffee.ui.comment

import android.content.Context
import android.media.Rating
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.RatingBar
import android.widget.TextView
import android.widget.Toast
import androidx.navigation.compose.navArgument
import at.tu.graz.coffee.R
import at.tu.graz.coffee.model.Coffee
import at.tu.graz.coffee.model.Review
import org.w3c.dom.Text

class CommentAdapter(context: Context, reviewList:List<Review>): BaseAdapter() {
    private val mContext: Context = context
    private val mReviewList: List<Review> = reviewList

    override fun getCount(): Int {
        return mReviewList.size
    }

    override fun getItem(p0: Int): Any {
        return mReviewList[p0]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, viewGroup: ViewGroup?): View {
        val rowView: View
        val layoutInflater = LayoutInflater.from(mContext)
        rowView = layoutInflater.inflate(R.layout.comment_row, viewGroup, false)

        val comment = rowView.findViewById<TextView>(R.id.comment_comment)
        val cost = rowView.findViewById<RatingBar>(R.id.comment_cost)
        val availability = rowView.findViewById<RatingBar>(R.id.comment_availability)
        val taste = rowView.findViewById<RatingBar>(R.id.comment_taste)
        comment.text = mReviewList[position].comment
        cost.rating = mReviewList[position].cost.toFloat()
        taste.rating = mReviewList[position].taste.toFloat()
        availability.rating = mReviewList[position].availability.toFloat()

        return rowView
    }
}