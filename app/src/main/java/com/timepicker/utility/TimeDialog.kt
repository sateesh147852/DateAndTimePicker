package com.timepicker.utility

import android.app.TimePickerDialog
import android.content.Context

class TimeDialog(
    context: Context,
    listener: OnTimeSetListener,
    hour: Int,
    minute: Int,
    is24Hour: Boolean = false
) :
    TimePickerDialog(context, listener, hour, minute, is24Hour) {
}