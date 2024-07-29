package com.example.activitycycle;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d("觀察方法", "onCreate running"); // Log.d() 是除錯用的方法，可以在 Logcat 看到
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void callMAP(View view) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("geo:0,0?q=逢甲大學"));
        startActivity(intent);
    }

    public void finish(View view) {
        finish();
    }

    @Override
    protected void onStart() {
        Log.d("觀察方法", "onStart running");
        super.onStart();
    }

    @Override
    protected void onResume() {
        Log.d("觀察方法", "onResume running");
        super.onResume();
    }

    @Override
    protected void onPause() {
        Log.d("觀察方法", "onPause running");
        super.onPause();
    }

    @Override
    protected void onStop() {
        Log.d("觀察方法", "onStop running");
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        Log.d("觀察方法", "onDestroy running");
        super.onDestroy();
    }


    @Override
    protected void onRestart() {
        Log.d("觀察方法", "onRestart running");
        super.onRestart();
    }

}