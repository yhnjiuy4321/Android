package com.example.temperature_converter;

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
    public void ConvertC(View view){
        EditText EditView=(EditText)findViewById(R.id.input);
        TextView resultText =(TextView) findViewById(R.id.result);
        Button convertButtonC=(Button)findViewById(R.id.TurnToC);
        Button convertButtonF=(Button)findViewById(R.id.TurnToF);


        double input= Double.parseDouble(EditView.getText().toString());
        double result;

        result= (input-32)*5/9;
        resultText.setText(String.format(Locale.US,"攝氏溫度: %.2f°C", result));

        convertButtonF.setEnabled(false);
        convertButtonC.setEnabled(false);


    }
    public void ConvertF(View view){
        EditText EditView=(EditText)findViewById(R.id.input);
        TextView resultText =(TextView) findViewById(R.id.result);
        Button convertButtonF=(Button)findViewById(R.id.TurnToF);
        Button convertButtonC=(Button)findViewById(R.id.TurnToC);

        double input= Double.parseDouble(EditView.getText().toString());
        double result;

        result= input*9/5+32;
        resultText.setText(String.format(Locale.US,"華氏溫度: %.2f°F", result));

        convertButtonC.setEnabled(false);
        convertButtonF.setEnabled(false);
    }

    public void Init(View view){
        Button convertButton=(Button) findViewById(R.id.TurnToC);
        Button convertButton2=(Button) findViewById(R.id.TurnToF);
        TextView resultText=(TextView) findViewById(R.id.result);
        EditText EditView=(EditText) findViewById(R.id.input);

        resultText.setText("0");
        convertButton.setEnabled(true);
        convertButton2.setEnabled(true);
        EditView.setText("");
    }



}