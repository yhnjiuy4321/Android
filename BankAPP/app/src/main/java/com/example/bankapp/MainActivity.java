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
    private double Total =0;

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
                if(o.getData() != null && o.getResultCode()== Activity.RESULT_OK){
                    if(o.getData().hasExtra("Total1")){ //hasExtra()判斷intent是否有這個資料
                        Money = o.getData().getDoubleExtra("Total1", 0);
                        Total += Money;
                        updateUI();
                    }else if(o.getData().hasExtra("Total2")) {
                        Money = o.getData().getDoubleExtra("Total2", 0);
                        if (Total >= Money) {
                            Total -= Money;
                            updateUI();
                        } else {
                            error();
                        }
                    }
                }
            }
        });



    }


    //跳轉到NTD_dp_wd
    public void ntdATM(View view) {
        Intent intent = new Intent(this, NTD_dp_wd.class);
        intentActivityResultLauncher.launch(intent);//啟動intent
    }

    //更新UI
    private void updateUI() {
        TextView textView = findViewById(R.id.NTD_Amount);
        textView.setText(String.valueOf(Total));//將Total轉換成字串

        TextView textView2 = findViewById(R.id.Result);
        textView2.setText("操作成功");
        textView2.setTextColor(parseColor("#00FF00"));//字體改綠色
    }

    private void error() {
        TextView textView = findViewById(R.id.Result);
        textView.setText("餘額不足，操作失敗");
        textView.setTextColor(parseColor("#FF0000"));//字體改紅色
    }
}