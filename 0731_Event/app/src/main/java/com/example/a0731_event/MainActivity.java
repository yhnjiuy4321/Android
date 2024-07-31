package com.example.a0731_event;

import android.graphics.Color;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, View.OnLongClickListener,View.OnTouchListener{

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

        Button button = (Button)findViewById(R.id.button);
        Button button2= (Button)findViewById(R.id.button2);
        button2.setOnClickListener(this);
        button.setOnClickListener(this);
        button.setOnLongClickListener(this);


        ConstraintLayout layout = (ConstraintLayout)findViewById(R.id.main);
        layout.setOnTouchListener(this);

    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.button) {

            TextView tv = (TextView) findViewById(R.id.size);
            TextView tv_size = (TextView) findViewById(R.id.textView);
            float size = tv.getTextSize() / getResources().getDisplayMetrics().scaledDensity;
            tv.setTextSize(size + 5);
            tv_size.setText(String.valueOf(size + 5));
        }else if(view.getId() == R.id.button2){
            TextView tv = (TextView) findViewById(R.id.size);
            TextView tv_size = (TextView) findViewById(R.id.textView);
            float size = tv.getTextSize() / getResources().getDisplayMetrics().scaledDensity;
            tv.setTextSize(size - 5);
            tv_size.setText(String.valueOf(size - 5));
        }
    }

    @Override
    public boolean onLongClick(View view) {
        TextView tv = (TextView)findViewById(R.id.size);
        TextView tv_size = (TextView)findViewById(R.id.textView);

        float size = tv.getTextSize()/getResources().getDisplayMetrics().scaledDensity;
        tv.setTextSize(size - 5); // 設定文字大小
        tv_size.setText(String.valueOf(size - 5));

        return true;
    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {

        TextView tv_action = (TextView)findViewById(R.id.action);
        TextView tv_position = (TextView)findViewById(R.id.position);

        int act = motionEvent.getAction();
        switch (act){
            case MotionEvent.ACTION_DOWN:
                tv_action.setText("ACTION_DOWN");
                //設定顏色
                tv_action.setTextColor(Color.RED);
                break;
            case MotionEvent.ACTION_MOVE:
                tv_action.setText("ACTION_MOVE");
                //設定顏色
                tv_action.setTextColor(Color.GREEN);
                break;
            case MotionEvent.ACTION_UP:
                tv_action.setText("ACTION_UP");
                //設定顏色
                tv_action.setTextColor(Color.BLUE);
                break;
        }

        float x = motionEvent.getX();
        float y = motionEvent.getY();
        tv_position.setText("x: "+x+" y: "+y);

        return true; // false意思是事件沒有被消耛，還會繼續往下傳遞，true則是消耗掉事件
    }
}