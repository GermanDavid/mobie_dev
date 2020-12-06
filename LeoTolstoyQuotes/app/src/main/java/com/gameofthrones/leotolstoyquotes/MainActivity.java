package com.gameofthrones.leotolstoyquotes;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlarmManager;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.view.View.OnClickListener;


public class MainActivity extends AppCompatActivity {

    private AlarmManager alarmManager;
    private  PendingIntent pendingIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        createNotificationChannel();
        initiallizeAlarm(this);

        Button button = (Button)findViewById(R.id.button);
        button.setOnClickListener(startListener);
    }


    private OnClickListener startListener = new OnClickListener() {
        public void onClick(View v) {
            Toast.makeText(MainActivity.this, "Leo Tolstoy Quotes", Toast.LENGTH_LONG).show();
            Intent starkClick = new Intent(v.getContext(), MainActivity.class);
            startActivity(starkClick);
        }
    };


    private void initiallizeAlarm(Context context) {

        Intent intent = new Intent(MainActivity.this, AlarmReciever.class);

        pendingIntent = PendingIntent.getBroadcast(MainActivity.this, 1, intent, 0);

        alarmManager = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);

        alarmManager.setRepeating(AlarmManager.RTC_WAKEUP,
                System.currentTimeMillis(),
                5*1000, pendingIntent);
        QuoteIntentService.startActionQuote(this);
        };



    private  void createNotificationChannel() {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CharSequence name = "ReminderChannel";
            String description = "Channel For Leo Tolstoy Quotes";
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel = new NotificationChannel("leoTolstoyQuotes", name, importance);
            channel.setDescription(description);


            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
        }
    }
}