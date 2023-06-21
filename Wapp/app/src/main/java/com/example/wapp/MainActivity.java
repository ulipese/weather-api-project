package com.example.wapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.view.View;

import android.os.Bundle;


public class MainActivity extends AppCompatActivity  {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            Intent permissions = new Intent(this, PermissionsActivity.class);
            startActivity(permissions);
            finish();
        }

    }


    public void goInfo (View view) {
        Intent info = new Intent(this, InfoActivity.class);
        startActivity(info);
        finish();
    }
    public void goHistory (View view) {
        Intent history = new Intent(this, HistoryActivity.class);
        startActivity(history);
        finish();
    }
    public void goHome (View view) {
        Intent home = new Intent(this, MainActivity.class);
        startActivity(home);
        finish();
    }
}