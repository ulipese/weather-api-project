package com.example.wapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class PermissionsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_permissions);

        // Checando se a permissão não está garantida
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_COARSE_LOCATION}, 1);
        }
        // Se não... (permissão garantida)
        else {
            Intent home = new Intent(this, MainActivity.class);
            startActivity(home);
            finish();
        }
    }
    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions,  int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case 1: {
                // Se o usuário aceitar, grantResults  > 0 ou == 1
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    // Se a permissão for realmente concedida, irá exibir na tela ...
                    if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
                        Toast.makeText(this, "Permission Granted", Toast.LENGTH_SHORT).show();
                        Intent home = new Intent(this, MainActivity.class);
                        startActivity(home);
                        finish();
                    }
                }
                // se não:
                else {
                    Toast.makeText(this, "Aceite as permissões para usar o app :)", Toast.LENGTH_SHORT).show();
                }
                return;
            }
        }
    }

    public void permitir (View view) {
        Intent permissions = new Intent(this, PermissionsActivity.class);
        startActivity(permissions);
        finish();
    }
}