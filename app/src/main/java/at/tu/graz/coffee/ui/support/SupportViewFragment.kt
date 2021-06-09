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

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_support, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btn_sendEmail?.setOnClickListener {
            val id: Int = radio_group.checkedRadioButtonId

            var emailToSend = "john.tusha@student.tugraz.at"
            if (id == rdbtn_Owner.id) {
                emailToSend = "smartcoffeehelp@gmail.com"
            };
            else {
                emailToSend = "smartcoffeehelp@gmail.com"
            }

            val sender = EmailSender()
            sender.execute(emailToSend, txt_supportMsg.text.toString())

            Toast.makeText(activity, R.string.emailConfirm, Toast.LENGTH_SHORT).show()
            txt_supportMsg.text.clear()

            Toast.makeText(activity,R.string.emailConfirm,Toast.LENGTH_SHORT).show()
        }

    }
}