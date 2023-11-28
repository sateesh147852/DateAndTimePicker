package com.timepicker.ui

import android.app.TimePickerDialog
import android.icu.util.Calendar
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TimePicker
import android.widget.Toast
import com.timepicker.R
import com.timepicker.databinding.FragmentTimePickerBinding
import com.timepicker.utility.TimeDialog

class TimePickerFragment : Fragment(), TimePickerDialog.OnTimeSetListener {

    private lateinit var binding: FragmentTimePickerBinding
    private lateinit var timeDialog: TimeDialog

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentTimePickerBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val calender = Calendar.getInstance()
        val hour = calender.get(Calendar.HOUR)
        val minute = calender.get(Calendar.MINUTE)
        context?.let {
            timeDialog = TimeDialog(it, this@TimePickerFragment, hour, minute,true)
        }

        binding.btShow.setOnClickListener {
            timeDialog.show()
        }
    }

    override fun onTimeSet(p0: TimePicker?, hour: Int, minute: Int) {
        Toast.makeText(context, "$hour : $minute", Toast.LENGTH_SHORT).show()
    }
}