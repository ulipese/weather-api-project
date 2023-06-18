package com.example.wapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class InfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
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