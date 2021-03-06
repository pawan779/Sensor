package com.pawan.sensor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button btnAcc,btnShow,btnGyro,btnAdd,btnProxy,btnNotification,btnService,btnBroadcast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnAcc=findViewById(R.id.Accelerometer);
        btnShow=findViewById(R.id.allSensor);
        btnGyro=findViewById(R.id.Gyro);
        btnAdd=findViewById(R.id.Add);
        btnProxy=findViewById(R.id.proximity);
        btnNotification=findViewById(R.id.notification);
        btnService=findViewById(R.id.Service);
        btnBroadcast=findViewById(R.id.Broadcast);

        btnAcc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,Acclerometer.class);
                startActivity(intent);
            }
        });
        btnShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,SensorActivity.class);
                startActivity(intent);
            }
        });
        btnGyro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,GyroScope.class);
                startActivity(intent);
            }
        });
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,AddAcivity.class);
                startActivity(intent);
            }
        });
        btnProxy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,ProximitySensor.class);
                startActivity(intent);
            }
        });
        btnNotification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,NotificationActivity.class);
                startActivity(intent);
            }
        });

        btnService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,ServicesActivity.class);
                startActivity(intent);
            }
        });

btnBroadcast.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent intent=new Intent(MainActivity.this,BroadCastActivity.class);
        startActivity(intent);
    }
});

    }
}
