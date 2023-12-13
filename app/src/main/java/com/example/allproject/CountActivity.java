package com.example.allproject;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.text.InputType;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class CountActivity extends AppCompatActivity {
    private static final int NUM_COLORS = 7;
    private int previousFibonacci = 1;

    private int currentFibonacci = 0;
    private int maxFibonacciValue = 100; // Default max value
    private TextView textView;
    private Button showFibonacciButton;
    private Button resetButton;
    private Button showToastButton;
    private Button enterMaxButton;

    private void changeTextColor() {
        Resources res = getResources();
        TypedArray colors = res.obtainTypedArray(R.array.fibonacci_colors);

        int randomIndex = new Random().nextInt(NUM_COLORS);
        int randomColor = colors.getColor(randomIndex, 0);

        textView.setTextColor(randomColor);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_count); // Correct layout file
        // ... rest of the code


    textView = findViewById(R.id.fibonacciNumberTextView);
        showFibonacciButton = findViewById(R.id.showFibonacciButton);
        resetButton = findViewById(R.id.resetButton);
        showToastButton = findViewById(R.id.showToastButton);
        enterMaxButton = findViewById(R.id.enterMaxButton);
        Button backToMainButton = findViewById(R.id.backToMainButton);

// Set OnClickListener for the button
        backToMainButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // When the button is clicked, open MainActivity
                Intent intent = new Intent(CountActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        enterMaxButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showMaxInputDialog();
            }
        });

        showFibonacciButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int nextFibonacci = currentFibonacci + previousFibonacci;

                if (maxFibonacciValue == 0 || nextFibonacci <= maxFibonacciValue) {
                    textView.setText(String.valueOf(nextFibonacci));
                    changeTextColor();
                    previousFibonacci = currentFibonacci;
                    currentFibonacci = nextFibonacci;
                } else {
                    Toast.makeText(CountActivity.this, "Reached Max Fibonacci Value", Toast.LENGTH_SHORT).show();
                }
            }
        });

        showToastButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String toastMessage = "Fibonacci Number: " + currentFibonacci;
                Toast toast = Toast.makeText(CountActivity.this, toastMessage, Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.TOP, 0, 16);
                toast.show();
            }
        });

        resetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentFibonacci = 0;
                previousFibonacci = 1;
                textView.setText("0");
            }
        });
    }

    private void showMaxInputDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Enter Max Number, 0 = No Limit");

        final EditText input = new EditText(this);
        input.setInputType(InputType.TYPE_CLASS_NUMBER);
        builder.setView(input);

        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                try {
                    int newMax = Integer.parseInt(input.getText().toString());

                    if (newMax >= 0) {
                        maxFibonacciValue = newMax;
                        // No toast message for unlimited Fibonacci sequence
                    } else {
                        Toast.makeText(CountActivity.this, "Enter a valid non-negative number", Toast.LENGTH_SHORT).show();
                    }
                } catch (NumberFormatException e) {
                    Toast.makeText(CountActivity.this, "Invalid input", Toast.LENGTH_SHORT).show();
                }
            }
        });

        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        builder.show();
    }
}