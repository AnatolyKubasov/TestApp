package com.example.aufgabe1.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.aufgabe1.Network.DownloadCallback;
import com.example.aufgabe1.R;

public class ThxForRegView extends AppCompatActivity {

    Button btGoToLogin;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thxforreg);

        btGoToLogin = findViewById(R.id.btGoToLogin);
        Intent intent = new Intent(ThxForRegView.this, MainActivity.class);
        startActivity(intent);


    }


}
