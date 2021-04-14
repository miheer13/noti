package com.miheer.noti;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Color;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private NotificationManagerCompat notificationManager;

    private Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        notificationManager = NotificationManagerCompat.from(this);

        long vibrate[]={100,500,100,500};

        Uri uri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);

        btn = findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent activityIntent = new Intent(MainActivity.this, TestActivity.class);
                PendingIntent contentIntent = PendingIntent.getActivity(MainActivity.this,
                        0,activityIntent, 0);

                Notification notification = new NotificationCompat.Builder(MainActivity.this, NotificationChannel.CHANNEL_ID)
                        //set icon
                        .setSmallIcon(R.drawable.ic_noti_icon)
                        //set title
                        .setContentTitle("noti")
                        //set the stuff that appears appears below
                        .setContentText("this is a test noti")
                        //set priority level
                        .setSound(uri)
                        .setAutoCancel(true)
                        .setPriority(NotificationCompat.PRIORITY_HIGH)
                        .setCategory(NotificationCompat.CATEGORY_MESSAGE)
                        .setContentIntent(contentIntent)
                        .setVibrate(vibrate)
                        .build();

                notificationManager.notify(1,notification);
            }
        });
    }
}