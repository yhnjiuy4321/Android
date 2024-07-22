package com.example.apple_calculator;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    int firstNumber;
    int secondNumber;
    int result;
    String operator;

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

    public void calculate(View view) {

        if (view.getId() == R.id.n0) {
            TextView textView = findViewById(R.id.Process);
            textView.setText("0");
            firstNumber = 0;
        } else if (view.getId() == R.id.n1) {
            TextView textView = findViewById(R.id.Process);
            textView.setText("1");
            firstNumber = 1;
        }
        else if (view.getId() == R.id.n2) {
            TextView textView = findViewById(R.id.Process);
            textView.setText("2");
            firstNumber = 2;
        }
        else if (view.getId() == R.id.n3) {
            TextView textView = findViewById(R.id.Process);
            textView.setText("3");
            firstNumber = 3;
        }
        else if (view.getId() == R.id.n4) {
            TextView textView = findViewById(R.id.Process);
            textView.setText("4");
            firstNumber = 4;
        }
        else if (view.getId() == R.id.n5) {
            TextView textView = findViewById(R.id.Process);
            textView.setText("5");
            firstNumber = 5;
        }
        else if (view.getId() == R.id.n6) {
            TextView textView = findViewById(R.id.Process);
            textView.setText("6");
            firstNumber = 6;
        }
        else if (view.getId() == R.id.n7) {
            TextView textView = findViewById(R.id.Process);
            textView.setText("7");
            firstNumber = 7;
        }
        else if (view.getId() == R.id.n8) {
            TextView textView = findViewById(R.id.Process);
            textView.setText("8");
            firstNumber = 8;
        }
        else if (view.getId() == R.id.n9) {
            TextView textView = findViewById(R.id.Process);
            textView.setText("9");
            firstNumber = 9;
        }

        if (view.getId() == R.id.n0) {
            TextView textView = findViewById(R.id.Process);
            textView.setText("0");
            secondNumber = 0;
        } else if (view.getId() == R.id.n1) {
            TextView textView = findViewById(R.id.Process);
            textView.setText("1");
            secondNumber = 1;
        }
        else if (view.getId() == R.id.n2) {
            TextView textView = findViewById(R.id.Process);
            textView.setText("2");
            secondNumber = 2;
        }
        else if (view.getId() == R.id.n3) {
            TextView textView = findViewById(R.id.Process);
            textView.setText("3");
            secondNumber = 3;
        }
        else if (view.getId() == R.id.n4) {
            TextView textView = findViewById(R.id.Process);
            textView.setText("4");
            secondNumber = 4;
        }
        else if (view.getId() == R.id.n5) {
            TextView textView = findViewById(R.id.Process);
            textView.setText("5");
            secondNumber = 5;
        }
        else if (view.getId() == R.id.n6) {
            TextView textView = findViewById(R.id.Process);
            textView.setText("6");
            secondNumber = 6;
        }
        else if (view.getId() == R.id.n7) {
            TextView textView = findViewById(R.id.Process);
            textView.setText("7");
            secondNumber = 7;
        }
        else if (view.getId() == R.id.n8) {
            TextView textView = findViewById(R.id.Process);
            textView.setText("8");
            secondNumber = 8;
        }
        else if (view.getId() == R.id.n9) {
            TextView textView = findViewById(R.id.Process);
            textView.setText("9");
            secondNumber = 9;
        }


        if (view.getId() == R.id.plus) {
            operator = "+";
        } else if (view.getId() == R.id.cut) {
            operator = "-";
        } else if (view.getId() == R.id.multiply) {
            operator = "*";
        } else if (view.getId() == R.id.divide) {
            operator = "/";
        }





        if (view.getId() == R.id.equal) {
            switch (operator) {
                case "+":
                    result = firstNumber + secondNumber;
                    break;
                case "-":
                    result = firstNumber - secondNumber;
                    break;
                case "*":
                    result = firstNumber * secondNumber;
                    break;
                case "/":
                    result = firstNumber / secondNumber;
                    break;
            }
            TextView textView = findViewById(R.id.Process);
            textView.setText(String.valueOf(result));
        }

    }

    public void clear(View view) {
        TextView textView = findViewById(R.id.Process);
        textView.setText("0");
    }

}