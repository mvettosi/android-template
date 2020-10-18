package com.mvettosi.kotlin.template.ui.factorial

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.mvettosi.kotlin.template.repository.FactorialCalculator
import com.mvettosi.kotlin.template.repository.NotificationUtil
import com.mvettosi.kotlin.template.ui.R
import kotlinx.android.synthetic.main.fragment_factorial.*

/**
 * A simple [Fragment] subclass.
 */
class FactorialFragment : Fragment() {

    private val notificationUtil: NotificationUtil? by lazy {
        NotificationUtil(requireContext())
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_factorial, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        button_compute.setOnClickListener {
            val input = edit_text_factorial.text.toString().toInt()
            val result = FactorialCalculator.computeFactorial(input).toString()

            text_result.text = result
            text_result.visibility = View.VISIBLE

            notificationUtil?.showNotification(
                context = requireContext(),
                title = getString(R.string.notification_title),
                message = result
            )
        }
    }
}