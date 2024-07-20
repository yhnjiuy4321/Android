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

    double Total; //帳戶總額

    //輸入金額後存款
    public void dp(View view) {

        EditText amount = findViewById(R.id.inputMoney);
        double money = Double.parseDouble(amount.getText().toString());
        Total = Total + money;

        Intent intent = new Intent();
        intent.putExtra("Total", Total);
        setResult(RESULT_OK, intent);
        finish();

    }

    //輸入金額後提款
    public void wd(View view) {

        EditText amount = findViewById(R.id.inputMoney);
        double money = Double.parseDouble(amount.getText().toString());
        Total = Total - money;
        if (Total < 0) {
            Total = 0;
        }

        Intent intent = new Intent();
        intent.putExtra("Total", Total);
        setResult(RESULT_OK, intent);
        finish();

    }





}