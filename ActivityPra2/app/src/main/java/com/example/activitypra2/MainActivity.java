package com.example.activitypra2;

import android.content.Intent;
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


    public void sentFruitname(View view) {
        //按下按鈕A，傳送Apple，按下按鈕B，傳送Banana
        String fruit ;

        if(view.getId() == R.id.buttonA){ //如果按下的是按鈕A
            fruit = "Apple";
        }else if(view.getId() == R.id.buttonB){ //如果按下的是按鈕B
            fruit = "Banana";
        }
        else{
            fruit = "";
        }

        Intent intent = new Intent(this, FruitActivity.class);
        // 設定intent，從MainActivity到FruitActivity，this是指MainActivity(自己)

        // 設定一個bundle來放資料
        Bundle bundle = new Bundle(); //bundle是一個資料包，可以放很多資料
        bundle.putString("FRUIT", fruit);//FRUIT是key，fruit是value

        // 利用intent攜帶bundle的資料
        intent.putExtras(bundle);//把bundle放到intent裡面
        startActivity(intent);//啟動intent
    }
}