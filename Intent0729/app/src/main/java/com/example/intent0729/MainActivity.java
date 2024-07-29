package com.example.intent0729;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

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

    public void fcuWEB(View view) {
        Intent i = new Intent();
        i.setAction(Intent.ACTION_VIEW); // 開啟瀏覽器
        i.setData(Uri.parse("https://www.fcu.edu.tw/"));// 設定網址
        startActivity(i);// 啟動
    }

    public void fcuMap(View view) {
        Intent i = new Intent();
        i.setAction(Intent.ACTION_VIEW); // 開啟地圖
        //i.setData(Uri.parse("geo:24.178840,120.646600")); // geo定位座標(目前位置)
        i.setData(Uri.parse("geo:0,0?q=台中市西屯區文華路100號")); // 設定地址，?q=查詢
        startActivity(i);// 啟動
    }

    public void fcuPhone(View view) {
        Intent i = new Intent();
        //i.setAction(Intent.ACTION_DIAL); // 開啟撥號
        i.setAction(Intent.ACTION_CALL); // 直接撥打
        i.setData(Uri.parse("tel:0909")); // 設定電話號碼
        startActivity(i);// 啟動
    }


}