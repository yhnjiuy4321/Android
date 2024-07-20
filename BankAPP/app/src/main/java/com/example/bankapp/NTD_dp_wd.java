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

public class NTD_dp_wd extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_ntd_dp_wd);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

    }


    //輸入金額後存款
    public void dp(View view) {


        
        EditText amount = findViewById(R.id.inputMoney);
        double money = Double.parseDouble(amount.getText().toString());//將輸入的金額轉換成double

        Intent intent = new Intent();
        intent.putExtra("Total1", money);//將存款金額放入intent，並命名為Total1，money為存款金額
        setResult(RESULT_OK, intent);//回傳資料
        finish();//結束此Activity

    }

    //輸入金額後提款
    public void wd(View view) {

        EditText amount = findViewById(R.id.inputMoney);
        double money = Double.parseDouble(amount.getText().toString());//將輸入的金額轉換成double


        Intent intent = new Intent();
        intent.putExtra("Total2", money);
        setResult(RESULT_OK, intent);//
        finish();

    }





}