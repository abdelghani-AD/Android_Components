package com.example.androidcomponents;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    Button btnStart, btnCancel;
    PendingIntent pendingIntent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnStart = findViewById(R.id.start);
        btnCancel = findViewById(R.id.cancel);

        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, MyService.class);
                pendingIntent = PendingIntent.getService(MainActivity.this, 0, intent, PendingIntent.FLAG_IMMUTABLE);
                AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
                Calendar calendar = Calendar.getInstance();
                calendar.setTimeInMillis(System.currentTimeMillis());
                calendar.add(calendar.SECOND,15);
                alarmManager.set(AlarmManager.RTC_WAKEUP,calendar.getTimeInMillis(),pendingIntent);
                Toast.makeText(MainActivity.this , "Start Alarm",Toast.LENGTH_SHORT).show();
            }
        });

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
                alarmManager.cancel(pendingIntent);
                Toast.makeText(MainActivity.this, "Cancel !!!! ", Toast.LENGTH_SHORT).show();
            }
        });
    }
}