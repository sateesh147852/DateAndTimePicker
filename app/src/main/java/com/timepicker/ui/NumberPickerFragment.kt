package com.timepicker.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.NumberPicker
import android.widget.Toast
import com.timepicker.databinding.FragmentNumberPickkerBinding

class NumberPickerFragment : Fragment() {

    private lateinit var binding: FragmentNumberPickkerBinding
    private val numbers = arrayOf<String>("10", "20", "30", "40", "50", "60", "70", "80", "90", "100")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentNumberPickkerBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
    }

    private fun initViews() {
        binding.numberPicker.apply {
            maxValue = 9
            minValue = 0
            displayedValues = numbers
        }

        binding.numberPicker.wrapSelectorWheel = false

        binding.numberPicker.setOnValueChangedListener(object : NumberPicker.OnValueChangeListener {
            override fun onValueChange(picker: NumberPicker?, p1: Int, p2: Int) {
                context?.let {
                    Toast.makeText(it, numbers[picker?.value ?: 0], Toast.LENGTH_SHORT).show()
                }
            }

        })
    }
}