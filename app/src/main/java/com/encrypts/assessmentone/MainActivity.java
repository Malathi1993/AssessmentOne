package com.encrypts.assessmentone;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import android.graphics.Color;
import android.icu.util.Calendar;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.TextView;
import android.widget.Toast;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
public class MainActivity extends AppCompatActivity {
    CalendarView simpleCalendarView;
    Button showDateBtn;
    TextView date, day, year;

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        simpleCalendarView = (CalendarView) findViewById(R.id.calendarView);
        showDateBtn = (Button) findViewById(R.id.button);
        date = (TextView) findViewById(R.id.date);
        day = (TextView) findViewById(R.id.day);
        year = (TextView) findViewById(R.id.year);
        final Calendar calender = Calendar.getInstance();
        simpleCalendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(CalendarView view, int year, int month, int dayOfMonth) {
                // display the selected date by using a toast
                Toast.makeText(getApplicationContext(), dayOfMonth + "/" + month + "/" + year, Toast.LENGTH_LONG).show();
                calender.set(year,month,dayOfMonth);

            }
        });
        showDateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                date.setText(String.valueOf(calender.get(Calendar.DATE)));
                day.setText(String.valueOf(calender.get(Calendar.DAY_OF_WEEK)));
                year.setText(String.valueOf(calender.get(Calendar.YEAR)));
            }
        });

    }

}

