package com.example.caculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void Plus(View view) {
        EditText num1 = (EditText) findViewById(R.id.input1);
        EditText num2 = (EditText) findViewById(R.id.input2);
        TextView resultText = (TextView) findViewById(R.id.result);
        //Button plusButton = (Button) findViewById(R.id.plus);

        double input1 = Double.parseDouble(num1.getText().toString());
        double input2 = Double.parseDouble(num2.getText().toString());
        double result;

        result = input1 + input2;
        resultText.setText(String.format(Locale.US, "%.2f", result));
    }

    public void Cut(View view) {
        EditText num1 = (EditText) findViewById(R.id.input1);
        EditText num2 = (EditText) findViewById(R.id.input2);
        TextView resultText = (TextView) findViewById(R.id.result);
        //Button cutButton = (Button) findViewById(R.id.cut);

        double input1 = Double.parseDouble(num1.getText().toString());
        double input2 = Double.parseDouble(num2.getText().toString());
        double result;

        result = input1 - input2;
        resultText.setText(String.format(Locale.US, "%.2f", result));
    }

    public void Multiply(View view) {
        EditText num1 = (EditText) findViewById(R.id.input1);
        EditText num2 = (EditText) findViewById(R.id.input2);
        TextView resultText = (TextView) findViewById(R.id.result);

        double input1 = Double.parseDouble(num1.getText().toString());
        double input2 = Double.parseDouble(num2.getText().toString());
        double result;

        result = input1 * input2;
        resultText.setText(String.format(Locale.US, "%.2f", result));
}

        public void Divide(View view) {
            EditText num1 = (EditText) findViewById(R.id.input1);
            EditText num2 = (EditText) findViewById(R.id.input2);
            TextView resultText = (TextView) findViewById(R.id.result);

            double input1 = Double.parseDouble(num1.getText().toString());
            double input2 = Double.parseDouble(num2.getText().toString());
            double result;

            if(input2 == 0){
                resultText.setText("    Num2 can't be 0!");
            }else {
                result = input1 / input2;
                resultText.setText(String.format(Locale.US, "%.2f", result));
            }
        }
}
