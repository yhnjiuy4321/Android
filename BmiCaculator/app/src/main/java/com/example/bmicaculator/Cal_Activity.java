package com.example.bmicaculator;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Cal_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_cal);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void BMI(View view) {
        EditText height = findViewById(R.id.input1);
        EditText weight = findViewById(R.id.input2);

        double h = Double.parseDouble(height.getText().toString());
        double w = Double.parseDouble(weight.getText().toString());
        h = h/100; //將身高從公分轉換成公尺
        double bmi = w / (h * h);

        Intent intent = new Intent();
        intent.putExtra("bmi", bmi);
        setResult(RESULT_OK, intent);
        finish();

    }
}