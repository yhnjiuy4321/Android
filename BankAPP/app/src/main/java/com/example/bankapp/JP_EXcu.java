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
            double result = money / exrate;
            Intent intent = new Intent();
            intent.putExtra("inputNTD", money);
            intent.putExtra("JPY", result);
            setResult(RESULT_OK, intent);
            finish();
        } else if (view.getId() == R.id.exchangeBTN1) {
            double result = money * exrate;
            Intent intent = new Intent();
            intent.putExtra("inputJPY", money);
            intent.putExtra("NTD", result);
            setResult(RESULT_OK, intent);
            finish();
        }
    }
}

/*
TextView：
顯示靜態文本，例如標籤、說明文字、標題等。
不需要用戶輸入或編輯的情況。
例如顯示用戶名、顯示計算結果、顯示描述性文字等。
EditText：
需要用戶輸入或編輯文本的情況。
用於表單輸入、搜索框、評論區等。
例如用戶輸入密碼、輸入電子郵件地址、輸入搜索關鍵字等。
*/
