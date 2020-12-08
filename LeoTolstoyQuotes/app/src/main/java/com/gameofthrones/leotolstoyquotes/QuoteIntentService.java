package com.gameofthrones.leotolstoyquotes;

import android.app.AlarmManager;
import android.app.IntentService;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;



public class QuoteIntentService  extends IntentService  {

    private static final String ACTION_QUOTE = "com.gameofthrones.leotolstoyquotes.action.quote";
    private static int arrLoc = 0;
    private static String[] quotes = {"Hi there", "Hello"};
    private NotificationManagerCompat notificationManager;
    static String CHANNEL_ID = "CHANNEL";


    public QuoteIntentService() {
        super("QuoteIntentService");
        notificationManager = null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }


    public static void startActionQuote(MainActivity context) {
        Intent intent = new Intent(context, QuoteIntentService.class);
        intent.setAction(ACTION_QUOTE);
        context.startService(intent);
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        if (intent != null) {
            final String action = intent.getAction();
            if (ACTION_QUOTE.equals(action)) {
                handleActionQuote();
            }

        }
    }

    private void handleActionQuote(){
        if(notificationManager == null){
            notificationManager = NotificationManagerCompat.from(this);
        }
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, CHANNEL_ID)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentTitle("Quote")
                .setContentText(quotes[arrLoc]);

        notificationManager.notify(1, builder.build());
        arrLoc = (arrLoc + 1) % quotes.length;
        startAlarm(this);
    }

    private void startAlarm(Context context){
        AlarmManager alarmManager = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
        Intent intent = new Intent(context, AlarmReciever.class);
        PendingIntent alarmIntent = PendingIntent.getBroadcast(context, 1, intent, 0);
        alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, System.currentTimeMillis(),
                5*60*1000, alarmIntent);
    }


}
