package com.gb.presentation.common

import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

fun String.toHours(): String {
    val format = SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.getDefault())
    val date = format.parse(this) ?: return "Invalid date"
    val outputFormat = SimpleDateFormat("HH:mm", Locale.getDefault())
    return outputFormat.format(date)
}