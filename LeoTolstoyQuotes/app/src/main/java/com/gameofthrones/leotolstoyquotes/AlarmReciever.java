package com.gameofthrones.leotolstoyquotes;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

public class AlarmReciever extends BroadcastReceiver {

    private static int arrLoc = 0;
    private String[] quotes;
    private NotificationManagerCompat notificationManager;

    public AlarmReciever() {
        super();
        notificationManager = null;
        quotes = null;
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        QuoteIntentService.startActionQuote((MainActivity) context);

        if(notificationManager == null){
            notificationManager = NotificationManagerCompat.from(context);
        }
        if(quotes == null){
            quotes = context.getResources().getStringArray(R.array.TolstoyQuotes);
        }
        NotificationCompat.Builder builder = new NotificationCompat.Builder(context, "leoTolstoyQuotes")
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentTitle("Leo Tolstoy Quotes")
                .setContentText("Hey, this is a life changing quotes...")
                .setPriority(NotificationCompat.PRIORITY_DEFAULT);

        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(context);

        notificationManager.notify(1, builder.build());
        arrLoc = (arrLoc + 1) % quotes.length;

    }
}
