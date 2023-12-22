package com.example.androidcomponents;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class MyService extends Service {
    public MyService() {
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Toast.makeText(this, "Service onCreate ", Toast.LENGTH_LONG).show();
    }
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Toast.makeText(this, "Service onBind(", Toast.LENGTH_LONG).show();
        return null;
    }
    @Override
    public void onDestroy() {
        super.onDestroy();
        Toast.makeText(this, "Service onDestroy", Toast.LENGTH_LONG).show();
    }
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Toast.makeText(this, "Service onStartCommand", Toast.LENGTH_LONG).show();
        return START_NOT_STICKY;
    }
    @Override
    public boolean onUnbind(Intent intent) {
        Toast.makeText(this, "Service onUnbind", Toast.LENGTH_LONG).show();
        return super.onUnbind(intent);
    }
}