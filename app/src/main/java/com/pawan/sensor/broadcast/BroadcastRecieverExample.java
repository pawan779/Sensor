package com.pawan.sensor.broadcast;

import android.app.Notification;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.widget.Toast;

import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import com.pawan.sensor.R;
import com.pawan.sensor.createChannel.CreateChannel;

public class BroadcastRecieverExample extends BroadcastReceiver {
    private NotificationManagerCompat notificationManagerCompat;
    Context context;

    public BroadcastRecieverExample(Context context) {
        this.context = context;
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        boolean noConnectivity;
        notificationManagerCompat = NotificationManagerCompat.from(context);

        if (ConnectivityManager.CONNECTIVITY_ACTION.equals(intent.getAction())) {
            noConnectivity = intent.getBooleanExtra(
                    ConnectivityManager.EXTRA_NO_CONNECTIVITY,
                    false
            );

            if (noConnectivity) {
                Toast.makeText(context, "Disconnected", Toast.LENGTH_SHORT).show();
                displayDisconnectNotification();
            } else {
                Toast.makeText(context, "Connected", Toast.LENGTH_SHORT).show();
                displayConnectedNotification();
            }
        }
    }

    private void displayConnectedNotification() {
        Notification notification = new NotificationCompat.Builder(context, CreateChannel.CHANNEL_1)
                .setSmallIcon(R.drawable.ic_pan_tool_black_24dp)
                .setContentTitle("Connected")
                .setContentText(" You are connected to internet")
                .setCategory(NotificationCompat.CATEGORY_MESSAGE)
                .build();
        notificationManagerCompat.notify(2, notification);
    }

    private void displayDisconnectNotification() {
        Notification notification = new NotificationCompat.Builder(context, CreateChannel.CHANNEL_1)
                .setSmallIcon(R.drawable.ic_pan_tool_black_24dp)
                .setContentTitle(" No conection")
                .setContentText(" No connection, PLease connect")
                .setCategory(NotificationCompat.CATEGORY_MESSAGE)
                .build();
        notificationManagerCompat.notify(1, notification);
    }
}
