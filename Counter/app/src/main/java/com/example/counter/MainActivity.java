package com.example.counter;

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
    public void Count(View view){
        EditText limitEditView=(EditText)findViewById(R.id.limit);
        TextView timesText =(TextView) findViewById(R.id.times);
        Button countButton=(Button)findViewById(R.id.count);

        int limit= Integer.parseInt(limitEditView.getText().toString());
        int times= Integer.parseInt(timesText.getText().toString());

        if(limit>times){
            times+=1;
            timesText.setText(String.valueOf(times));
        }else {
            timesText.setText("已達上限");
            countButton.setEnabled(false);//意思是
        }

    }
    public void Init(View view){
        Button countButton=(Button) findViewById(R.id.count);
        TextView timesText=(TextView) findViewById(R.id.times);

        timesText.setText("0");
        countButton.setEnabled(true);//
    }

}
