package com.pawan.sensor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.pawan.sensor.service.MyService;

public class ServicesActivity extends AppCompatActivity {
    Button btnstartService,btnstopService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_services);
        btnstartService=findViewById(R.id.startService);
        btnstopService=findViewById(R.id.stopService);

        btnstartService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startMyService();
            }
        });

        btnstopService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stopMyService();
            }
        });
    }

    private void stopMyService() {
        stopService(new Intent(this,MyService.class));
    }

    private void startMyService() {
        startService(new Intent(this, MyService.class));
    }
}
