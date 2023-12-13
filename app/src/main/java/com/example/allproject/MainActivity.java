package com.example.allproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Find the HelloButton
        ImageButton helloButton = findViewById(R.id.HelloButton);
        helloButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, HalloActivity.class));
            }
        });

        ImageButton countButton = findViewById(R.id.CountButton);
        countButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, CountActivity.class));
            }
        });

        ImageButton sianidaButton = findViewById(R.id.SianidaButton);
        sianidaButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, SianidaActivity.class));
            }
        });

        ImageButton twoButton = findViewById(R.id.TwoButton);
        twoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, TwoActivity.class));
            }
        });

        findViewById(R.id.AlarmButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setAlarm();
            }
        });

        // Find the ImageButton for ThreeFragmentsActivity
        ImageButton threeFragmentsButton = findViewById(R.id.ThreeFragmentsButton);
        threeFragmentsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, ThreeFragmentsActivity.class));
            }
        });
    }

    private void setAlarm() {
        Intent alarm = new Intent(android.provider.AlarmClock.ACTION_SET_ALARM);
        startActivity(alarm);
    }
}
