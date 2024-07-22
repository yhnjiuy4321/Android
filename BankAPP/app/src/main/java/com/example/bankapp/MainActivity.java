package com.example.bankapp;

import static android.graphics.Color.parseColor;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {


    private ActivityResultLauncher<Intent> intentActivityResultLauncher;
    private double Money;
    private double TotalNTD = 0;
    private double TotalUSD = 0;
    private double TotalJPY = 0;
    private double Result = 0;

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

        intentActivityResultLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
            @Override
            public void onActivityResult(ActivityResult o) {
                //這裡寫另一個Activity回傳資料後的處理
                if (o.getData() != null && o.getResultCode() == Activity.RESULT_OK) {
                    if (o.getData().hasExtra("Total1")) { //hasExtra()判斷intent是否有這個資料
                        Money = o.getData().getDoubleExtra("Total1", 0);
                        TotalNTD += Money;
                        updateUI();
                    } else if (o.getData().hasExtra("Total2")) {
                        Money = o.getData().getDoubleExtra("Total2", 0);
                        if (TotalNTD >= Money) {
                            TotalNTD -= Money;
                            updateUI();
                        } else {
                            error();
                        }
                    } else if (o.getData().hasExtra("JPY")) {
                        Result = o.getData().getDoubleExtra("JPY", 0);
                        Money = o.getData().getDoubleExtra("inputNTD", 0);
                        if (TotalNTD >= Money) {
                            TotalNTD -= Money;
                            TotalJPY += Result;
                            updateUI();
                        } else {
                            error();
                        }
                    } else if (o.getData().hasExtra("NTD")) {
                        Result = o.getData().getDoubleExtra("NTD", 0);
                        Money = o.getData().getDoubleExtra("inputJPY", 0);
                        if (TotalJPY >= Money) {
                            TotalJPY -= Money;
                            TotalNTD += Result;
                            updateUI();
                        } else {
                            error();
                        }
                    } else if (o.getData().hasExtra("USD")) {
                        Result = o.getData().getDoubleExtra("USD", 0);
                        Money = o.getData().getDoubleExtra("inputNTD", 0);
                        if (TotalNTD >= Money) {
                            TotalNTD -= Money;
                            TotalUSD += Result;
                            updateUI();
                        } else {
                            error();
                        }
                    } else if (o.getData().hasExtra("action")) {
                        Result = o.getData().getDoubleExtra("NTD1", 0);
                        Money = o.getData().getDoubleExtra("inputUSD", 0); //取得intent的資料，第二個參數是預設值
                        if (TotalUSD >= Money) {
                            TotalUSD -= Money;
                            TotalNTD += Result;
                            updateUI();
                        } else {
                            error();
                        }
                    }
                }
            }
            /*

            其他方法
            String action = o.getData().getStringExtra("action");

            if(action.equals("Value")) {
                //do something
            }

            --->計算過程就寫在onCreate()裡面

            */


        });
    }


    //跳轉到NTD_dp_wd
    public void ntdATM(View view) {
        Intent intent = new Intent(this, NTD_dp_wd.class);
        intentActivityResultLauncher.launch(intent);//啟動intent
    }

    //跳轉到JP_EXcu
    public void jpEX(View view) {
        Intent intent = new Intent(this, JP_EXcu.class);
        intentActivityResultLauncher.launch(intent);
    }

    //跳轉到US_EXcu
    public void usEX(View view) {
        Intent intent = new Intent(this, US_EXcu.class);
        intentActivityResultLauncher.launch(intent);
    }

    //更新UI
    private void updateUI() {


        TextView textView = findViewById(R.id.JPY_Amount);
        textView.setText(String.valueOf(TotalJPY));//將Total轉換成字串

        TextView textView2 = findViewById(R.id.USD_Amount);
        textView2.setText(String.valueOf(TotalUSD));//將Total轉換成字串

        TextView textView1 = findViewById(R.id.NTD_Amount);
        textView1.setText(String.valueOf(TotalNTD));//將Total轉換成字串

        TextView result = findViewById(R.id.Result);
        result.setText("操作成功");
        result.setTextColor(parseColor("#00FF00"));//字體改綠色
    }

    private void error() {
        TextView textView = findViewById(R.id.Result);
        textView.setText("餘額不足，操作失敗");
        textView.setTextColor(parseColor("#FF0000"));//字體改紅色
    }
}