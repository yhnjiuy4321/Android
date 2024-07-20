package com.example.bankapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class JP_EXcu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_jp_excu);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void exchange(View view) {



        EditText amount = findViewById(R.id.input);
        EditText rate = findViewById(R.id.Rate);

        double money = Double.parseDouble(amount.getText().toString());
        double exrate = Double.parseDouble(rate.getText().toString());

        if (view.getId() == R.id.exchangeBTN2) {
            double result = money * exrate;
            Intent intent = new Intent();
            intent.putExtra("inputNTD", money);
            intent.putExtra("JPY", result);
            setResult(RESULT_OK, intent);
            finish();
        }else {
            double result = money / exrate;
            Intent intent = new Intent();
            intent.putExtra("inputJPY", money);
            intent.putExtra("NTD", result);
            setResult(RESULT_OK, intent);
            finish();
        }
    }
}