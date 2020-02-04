package com.encrypts.assessmentone;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
   CalendarView simpleCalendarView;
   TextView date,day,year;
   Button showselecteddate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        date = (TextView) findViewById(R.id.date);
        day = (TextView) findViewById(R.id.day);
        year = (TextView) findViewById(R.id.year);
        showselecteddate = (Button)findViewById(R.id.button);
        final Calendar calendar = Calendar.getInstance();
        //simpleCalendarView = (CalendarView) findViewById(R.id.calendarView);
        simpleCalendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                //public void onSelectedDayChange(CalendarView view, int year, int month, int dayOfMonth) {
                // display the selected date by using a toast
                Toast.makeText(MainActivity.this.getApplicationContext(), dayOfMonth + "/" + month + "/" + year, Toast.LENGTH_LONG).show();
                calendar.set(year, month, dayOfMonth);
            }
        });

        showselecteddate.setOnClickListener((view ));
        {

            date.setText(String.valueOf(calendar.get(Calendar.DATE)));
            date.setText(String.valueOf(calendar.get(Calendar.DAY_OF_WEEK)));
            date.setText(String.valueOf(calendar.get(Calendar.YEAR)));
        }
    }

}

