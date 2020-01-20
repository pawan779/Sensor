package com.pawan.sensor.service;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class MyService extends Service {
    public Context context=this;
    public Handler handler=null;
    public Runnable runnable=null;

    public MyService() {

    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        Toast.makeText(context, "Service created", Toast.LENGTH_SHORT).show();
        handler=new Handler();
        runnable=new Runnable() {
            @Override
            public void run() {
                double randomNo=getRandomDoubleRange(1,100);
                Toast.makeText(context, "Random no: "+randomNo, Toast.LENGTH_SHORT).show();
                handler.postDelayed(runnable,2000);
            }
        };
        handler.postDelayed(runnable,2000);

    }

    private double getRandomDoubleRange(int i, int i1) {
        return (Math.random()*((i1-i)+1))+i;
    }

    @Override
    public void onDestroy() {
        handler.removeCallbacks(runnable);
        Toast.makeText(this, "Service Stopped", Toast.LENGTH_SHORT).show();
    }
}
