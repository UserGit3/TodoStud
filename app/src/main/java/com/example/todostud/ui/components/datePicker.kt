package com.example.todostud.ui.components

import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.tooling.preview.Preview
import com.google.android.material.datepicker.MaterialDatePicker
import com.maxkeppeker.sheets.core.models.base.UseCaseState
import com.maxkeppeler.sheets.calendar.CalendarDialog
import com.maxkeppeler.sheets.calendar.models.CalendarConfig
import com.maxkeppeler.sheets.calendar.models.CalendarSelection
import java.time.LocalDate


@ExperimentalMaterial3Api
@Preview
@Composable
fun datePicker() {
    var calendarState = UseCaseState()
    var calendarDate = LocalDate.now()
    val selectedDate = remember {
        mutableListOf(LocalDate.now())
    }
    val displedDates = listOf(LocalDate.now())
    CalendarDialog(
        state = calendarState,
        config = CalendarConfig(monthSelection = true, yearSelection = true),
        selection = CalendarSelection.Date { newDate ->
            val currentDay = newDate.dayOfMonth
        })
    Button(onClick = { calendarState.show() }) {
        Text(text = "Calendar")

    }
}

