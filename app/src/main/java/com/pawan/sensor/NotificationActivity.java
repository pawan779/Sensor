package com.pawan.sensor;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.Notification;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.pawan.sensor.createChannel.CreateChannel;

public class NotificationActivity extends AppCompatActivity {
    private NotificationManagerCompat notificationManagerCompat;
    private Button btnNoti1,btnNoti2;
    private int count=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);
        notificationManagerCompat=NotificationManagerCompat.from(this);
        CreateChannel channel=new CreateChannel(this);
        channel.createChannel();
        btnNoti1=findViewById(R.id.notification1);

        btnNoti1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DisplayNotification();
            }
        });


    }

    private void DisplayNotification() {
        Notification notification=new NotificationCompat.Builder(this,CreateChannel.CHANNEL_1)
                .setSmallIcon(R.drawable.ic_pan_tool_black_24dp)
                .setContentTitle(count++ +" message")
                .setContentText(count++ +" Message Body")
                .setCategory(NotificationCompat.CATEGORY_MESSAGE)
                .build();
        notificationManagerCompat.notify(count++,notification);
    }


}
