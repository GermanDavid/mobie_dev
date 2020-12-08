package com.gameofthrones.leotolstoyquotes;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;

import androidx.annotation.RequiresApi;
import androidx.core.app.NotificationCompat;

public class AlarmReciever extends BroadcastReceiver {
    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public void onReceive(Context context, Intent intent) {
        String[] quotesArray = new String[] {
                "Everyone thinks of changing the world but no one thinks of changing himself",
                "All happy families are alike each unhappy family is unhappy in its own way.",
                "If you look for perfection, youll never be content.",
                "It is amazing how complete is the delusion that beauty is goodness.",
        <item>“Respect was invented to cover the empty place where love should be.” </item>
        <item>“Spring is the time of plans and projects.” </item>
        <item>“If you want to be happy, be.” </item>
        <item>“Is it really possible to tell someone else what one feels?”</item>
        <item>“When you love someone, you love the person as they are, and not as youd like them to be.”</item>
        <item>“The two most powerful warriors are patience and time.”</item>
        <item>“Be bad, but at least dont be a liar, a deceiver!” </item>
        <item>“Anything is better than lies and deceit” </item>
        <item>“Boredom: the desire for desires.”</item>
        <item>“There is no greatness where there is not simplicity, goodness, and truth.” </item>
        <item>“Happiness does not depend on outward things, but on the way we see them.”</item>
        <item>“True life is lived when tiny changes occur.”</item>
        };
        Random rand = new Random();
        int randLocation = rand.nextInt(15); //Generating a random number to chose a quote from the array

        Intent repeating_intent = new Intent(context,Repeating_activity.class);
        repeating_intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        PendingIntent pendingIntent = PendingIntent.getActivity(context,100,repeating_intent,PendingIntent.FLAG_UPDATE_CURRENT);
        NotificationManager notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);

        //In case version is 26 or upper
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            NotificationChannel notificationChannel = new NotificationChannel("ID","channel",NotificationManager.IMPORTANCE_DEFAULT);
            notificationManager.createNotificationChannel(notificationChannel);

            NotificationCompat.Builder builder = new NotificationCompat.Builder(context, notificationChannel.getId())
                    .setContentIntent(pendingIntent)
                    .setSmallIcon(android.R.drawable.star_on)
                    .setContentTitle("FRIENDS Quote")
                    .setContentText(quotesArray[randLocation])
                    .setAutoCancel(true);
            notificationManager.notify(100,builder.build());
        }
        else{ //In case version is 25 or under
            NotificationCompat.Builder builder = new NotificationCompat.Builder(context)
                    .setContentIntent(pendingIntent)
                    .setSmallIcon(android.R.drawable.star_on)
                    .setContentTitle("FRIENDS Quote")
                    .setContentText(quotesArray[randLocation])
                    .setAutoCancel(true);
            notificationManager.notify(100,builder.build());
        }
    }
}
