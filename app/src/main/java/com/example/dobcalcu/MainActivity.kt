package com.example.dobcalcu
import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.DatePicker
import android.widget.Toast
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

class MainActivity : AppCompatActivity() {

   private var tvDateSelectedDate : TextView? = null

    private var tvAgeInMinutes : TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnDatePicker : Button = findViewById(R.id.btnDatePickerOf)
        tvDateSelectedDate = findViewById(R.id.tvSelectedDate)
        tvAgeInMinutes = findViewById(R.id.tvAgeInMinutes)

        btnDatePicker.setOnClickListener {
        // clickDatePicker()
        }
    }

    private fun clickDatePicker() {

        val myCalender = Calendar.getInstance()
        val year = myCalender.get(Calendar.YEAR)
        val month = myCalender.get(Calendar.MONTH)
        val day = myCalender.get(Calendar.DAY_OF_MONTH)
        DatePickerDialog(this,
          DatePickerDialog.OnDateSetListener{ _, selectedYear, selectedMonth, selectedDay ->
              Toast.makeText(this,
                  "DatePicker Wors", Toast.LENGTH_LONG).show()

              val selectedDate = "$selectedDay/${selectedMonth+1}/$selectedYear"
              tvDateSelectedDate?.text = selectedDate

              val sdf = SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH)
              val theDate = sdf.parse(selectedDate)

              val selectedDateInMintues = theDate.time / 6000

              val currentDate = sdf.parse(sdf.format(System.currentTimeMillis()))

              val currentDateInMinutes = currentDate.time / 6000

              val differenceInMinutes = currentDateInMinutes - selectedDateInMintues

              tvAgeInMinutes?.text = differenceInMinutes.toString()
          },
            year,
            month,
            day

            ).show()

    }
}