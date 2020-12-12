package com.gameofthrones.leotolstoyquotes;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import androidx.annotation.RequiresApi;
import androidx.core.app.NotificationCompat;

import java.util.Random;

public class AlarmReciever extends BroadcastReceiver {
    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public void onReceive(Context context, Intent intent) {
        String[] quotes = new String[] {
                "Everyone thinks of changing the world but no one thinks of changing himself",
                "All happy families are alike each unhappy family is unhappy in its own way.",
                "If you look for perfection, youll never be content.",
                "It is amazing how complete is the delusion that beauty is goodness.",
                "Respect was invented to cover the empty place where love should be." ,
                "Spring is the time of plans and projects.",
                "If you want to be happy, be.",
                "Is it really possible to tell someone else what one feels?",
                "When you love someone, you love the person as they are, and not as youd like them to be.",
                "The two most powerful warriors are patience and time.",
                "Be bad, but at least dont be a liar, a deceiver!",
                "Anything is better than lies and deceit.",
                "Boredom: the desire for desires.",
                "There is no greatness where there is not simplicity, goodness, and truth.",
                "Happiness does not depend on outward things, but on the way we see them.",
                "True life is lived when tiny changes occur."
        };
        Random random = new Random();
        int randomLocation = random.nextInt(20);

        Intent repeating_intent = new Intent(context,QuoteIntentService.class);
        repeating_intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        PendingIntent pendingIntent = PendingIntent.getActivity(context,100,repeating_intent,PendingIntent.FLAG_UPDATE_CURRENT);
       NotificationManager notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);


        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            NotificationChannel notificationChannel = new NotificationChannel("ID","channel",NotificationManager.IMPORTANCE_DEFAULT);
            notificationManager.createNotificationChannel(notificationChannel);

            NotificationCompat.Builder builder = new NotificationCompat.Builder(context, notificationChannel.getId())
                    .setContentIntent(pendingIntent)
                    .setSmallIcon(android.R.drawable.star_on)
                    .setContentTitle("Leo Tolstoy Quotes")
                    .setContentText(quotes[randomLocation])
                    .setAutoCancel(true);
            notificationManager.notify(100,builder.build());
        }
    }
}
