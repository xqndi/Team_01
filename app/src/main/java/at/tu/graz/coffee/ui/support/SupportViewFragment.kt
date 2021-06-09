package at.tu.graz.coffee.ui.support

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import at.tu.graz.coffee.R
import at.tu.graz.coffee.javaHelper.EmailSender
import kotlinx.android.synthetic.main.fragment_support.*
import android.widget.Toast

class SupportViewFragment : Fragment() {

    private lateinit var btn: Button
    private lateinit var emailToSend: String
    private lateinit var supportViewModel: SupportViewModel
    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        supportViewModel =
                ViewModelProvider(this).get(SupportViewModel::class.java)

        return inflater.inflate(R.layout.fragment_support, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btn_sendEmail?.setOnClickListener {
            var id: Int = radio_group.checkedRadioButtonId

            if (id == rdbtn_Owner.id) {
                emailToSend = "johntusha04@gmail.com"
            };
            else {
                emailToSend = "john.tusha@student.tugraz.at"
            }
            val sender = EmailSender()
            sender.execute(emailToSend, txt_supportMsg.text.toString())

            Toast.makeText(activity, R.string.emailConfirm, Toast.LENGTH_SHORT).show()
        }

    }
}