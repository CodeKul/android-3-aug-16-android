package com.codekul.statusbarnotifications;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private static final int NOTIFACTION_SIMPLE = 1234;
    private static final int REQ_NOTIFICATION = 3456;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btnOkay).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                simple();
            }
        });
    }

    private void simple(){

        Intent intent =
                new Intent(this,NotificationActivity.class);

        NotificationCompat.Builder builder =
                new NotificationCompat.Builder(this)
                .setTicker(getResources().getString(R.string.notificationTicker))
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentTitle(getResources().getString(R.string.notificationTitle))
                .setContentInfo(getResources().getString(R.string.notificationContentInfo))
                .setContentText(getResources().getString(R.string.notificationContentText))
                .setDefaults(Notification.DEFAULT_ALL)
                .setContentIntent(PendingIntent
                        .getActivity(this,
                                REQ_NOTIFICATION,
                                intent,
                                PendingIntent.FLAG_NO_CREATE))
                .addAction(R.mipmap.ic_launcher,"Action",PendingIntent
                        .getActivity(this,
                                REQ_NOTIFICATION,
                                intent,
                                PendingIntent.FLAG_NO_CREATE));

        Notification notification = builder.build();
        //notification.flags = Notification.FLAG_NO_CLEAR;
        notification.flags = Notification.FLAG_AUTO_CANCEL;

        NotificationManager manager = (NotificationManager)
                getSystemService(NOTIFICATION_SERVICE);

        manager.notify(NOTIFACTION_SIMPLE,notification);
    }
}
