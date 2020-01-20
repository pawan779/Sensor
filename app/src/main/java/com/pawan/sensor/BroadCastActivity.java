package com.pawan.sensor;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.Notification;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.os.Bundle;

import com.pawan.sensor.broadcast.BroadcastRecieverExample;
import com.pawan.sensor.createChannel.CreateChannel;

import java.nio.channels.Channel;

public class BroadCastActivity extends AppCompatActivity {
    private NotificationManagerCompat notificationManagerCompat;

    BroadcastRecieverExample broadcastRecieverExample=new BroadcastRecieverExample(this);
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_broad_cast);



    }




    @Override
    protected void onStart() {
        super.onStart();

        IntentFilter intentFilter=new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION);
        registerReceiver(broadcastRecieverExample,intentFilter);
    }

    @Override
    protected void onStop() {
        super.onStop();

        unregisterReceiver(broadcastRecieverExample);
    }
}
