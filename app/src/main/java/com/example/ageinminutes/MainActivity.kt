package com.example.ageinminutes

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btnDatePicker:Button=findViewById(R.id.btnDatePicker);
        btnDatePicker.setOnClickListener(View.OnClickListener {view->
            clickDatePicker(view)
            //Toast.makeText(this,"clicked!",Toast.LENGTH_LONG).show()

        })
       
    }
    
    fun clickDatePicker(view:View){
        val tvSelectedDate:TextView=findViewById(R.id.tvSelectDate)
        val myCalender=Calendar.getInstance()//craete calendar obj
        val year=myCalender.get(Calendar.YEAR)
        val month=myCalender.get(Calendar.MONTH)
        val day=myCalender.get(Calendar.DAY_OF_MONTH)
        DatePickerDialog(this,
            DatePickerDialog.OnDateSetListener { view, selectedYear, selectedMonth, selectedDay ->
                Toast.makeText(this,"the chosen year is $selectedDay-$selectedMonth-$selectedYear",Toast.LENGTH_LONG).show()
                                               },
            year,month,day).show()
        val selectedDate="$day/${month+1}/$year"
        tvSelectedDate.setText(selectedDate)
        val sdf=SimpleDateFormat("dd/mm/yyyy",Locale.ENGLISH)
        val theDate=sdf.parse(selectedDate)


    }
}