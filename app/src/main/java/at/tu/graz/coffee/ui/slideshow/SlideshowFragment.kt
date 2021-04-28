package at.tu.graz.coffee.ui.slideshow

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.RadioButton
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import at.tu.graz.coffee.R
import at.tu.graz.coffee.javaHelper.EmailSender
import at.tu.graz.coffee.ui.home.HomeViewModel
import kotlinx.android.synthetic.main.fragment_support.*
import kotlinx.android.synthetic.main.fragment_support.view.*
import java.util.Properties
import android.widget.Toast
class SlideshowFragment : Fragment() {

    private lateinit var btn: Button
    private lateinit var emailToSend: String
    private var username = "johntusha04@gmail.com"
    private var password = "Teutonia1863!jg"
    private lateinit var slideshowViewModel: SlideshowViewModel
    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        slideshowViewModel =
                ViewModelProvider(this).get(SlideshowViewModel::class.java)

        return inflater.inflate(R.layout.fragment_support, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // Instead of view.findViewById(R.id.hello) as TextView
        btn_sendEmail?.setOnClickListener {
            var id: Int = radio_group.checkedRadioButtonId

            if (id == rdbtn_Owner.id) {
                emailToSend = "johntusha04@gmail.com"
            };
            else
            {
                emailToSend = "john.tusha@student.tugraz.at"
            }
            val EmailSender = EmailSender(txt_supportMsg.text.toString(), emailToSend)
            Toast.makeText(activity,"Email sent successfully!",Toast.LENGTH_SHORT).show()
        }

    }
}