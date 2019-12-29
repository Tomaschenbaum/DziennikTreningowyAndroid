package com.example.projekt_dzienniktreningowy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;

public class CalendarActivity extends AppCompatActivity {

    private CalendarView calendarView;
    Button backAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        overridePendingTransition(R.anim.fadein, R.anim.fadeout);
        setContentView(R.layout.activity_calendar);

        calendarView = findViewById(R.id.calendarView);
        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(CalendarView view, int year, int month, int dayOfMonth) {
                String date = dayOfMonth + "/" + (month + 1) + "/" + year;

                Intent intent = new Intent(CalendarActivity.this, AddActivity.class);
                intent.putExtra("date", date);
                startActivity(intent);
            }
        });

        backAdd = findViewById(R.id.backAdd);
        backAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CalendarActivity.this, AddActivity.class);
                startActivity(intent);
            }
        });
    }
}
