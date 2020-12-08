package com.gameofthrones.leotolstoyquotes;

import androidx.appcompat.app.AppCompatActivity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import java.util.Calendar;


public class MainActivity extends AppCompatActivity {

    private AlarmManager alarmManager;
    private  PendingIntent pendingIntent;

    public static String[] quotesArray;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar calendar = Calendar.getInstance();

                Intent intent = new Intent(getApplicationContext(), AlarmReciever.class);

                pendingIntent = PendingIntent.getBroadcast(getApplicationContext(), 100, intent, PendingIntent.FLAG_UPDATE_CURRENT);

                alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);

                alarmManager.setRepeating(AlarmManager.RTC_WAKEUP,
                        calendar.getTimeInMillis(),
                        1000 * 60 * 5, pendingIntent);
            }
        });

    }

}