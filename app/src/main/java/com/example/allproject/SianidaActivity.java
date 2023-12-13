package com.example.allproject;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SianidaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sianida);
        // Find the button
        @SuppressLint("MissingInflatedId") Button backToMainButton = findViewById(R.id.backToMainButton);

        // Set OnClickListener for the button
        backToMainButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // When the button is clicked, open MainActivity
                Intent intent = new Intent(SianidaActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}