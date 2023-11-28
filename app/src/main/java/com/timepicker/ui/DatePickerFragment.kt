package com.timepicker.ui

import android.app.DatePickerDialog
import android.icu.util.Calendar
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.DatePicker
import android.widget.Toast
import com.timepicker.databinding.FragmentDatePickerBinding
import com.timepicker.utility.DateDialog

class DatePickerFragment : Fragment(), DatePickerDialog.OnDateSetListener {

    private lateinit var binding: FragmentDatePickerBinding
    private var dateDialog: DateDialog? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDatePickerBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val calender = Calendar.getInstance()
        val year = calender.get(Calendar.YEAR)
        val month = calender.get(Calendar.MONTH)
        val day = calender.get(Calendar.DAY_OF_MONTH)
        context?.let { context ->
            dateDialog = DateDialog.newInstance(context, this@DatePickerFragment, year, month, day,1)
        }

        binding.btShow.setOnClickListener {
            dateDialog?.show()
        }
    }

    override fun onDateSet(p0: DatePicker?, year: Int, month: Int, day: Int) {
        context?.let {
            Toast.makeText(it, " $year $month $day", Toast.LENGTH_SHORT).show()
        }
    }
}