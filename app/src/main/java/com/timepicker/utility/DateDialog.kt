package com.timepicker.utility

import android.app.DatePickerDialog
import android.content.Context


const val PAST: Int = 0
const val FUTURE: Int = 1

class DateDialog(
    context: Context,
    listener: OnDateSetListener,
    year: Int,
    month: Int,
    dayOfMonth: Int
) : DatePickerDialog(context, listener, year, month, dayOfMonth) {

    companion object {

        fun newInstance(
            context: Context, listener: OnDateSetListener,
            year: Int,
            month: Int,
            dayOfMonth: Int,
            calenderType: Int = 2
        ): DateDialog {

            val dialog = DateDialog(context, listener, year, month, dayOfMonth)
            dialog.datePicker.spinnersShown
            when (calenderType) {
                PAST -> {
                    dialog.datePicker.maxDate = System.currentTimeMillis() - 24 * 60 * 60 * 1000
                }

                FUTURE -> {
                    dialog.datePicker.minDate = System.currentTimeMillis() + 24 * 60 * 60 * 1000
                }
            }
            return dialog
        }
    }

}