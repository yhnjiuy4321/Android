package com.example.activitypra2;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class FruitActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_fruit);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            String fruit = String.format(bundle.getString("FRUIT"));

            // set Name
            TextView name = findViewById(R.id.Name);
            name.setText(fruit);//意思是把fruit放到name裡面

            // set Image
            ImageView image = findViewById(R.id.AppleImg);
            if (image != null && fruit != null) {
                String fruitName = fruit.toLowerCase();//把fruit變成小寫
                int resId = getResources().getIdentifier(fruitName, "drawable", getPackageName());//取得圖片的id，getPackageName()取得package名稱
                if (resId != 0) {
                    Drawable drawable = ContextCompat.getDrawable(this, resId);//取得圖片
                    image.setImageDrawable(drawable);//設定圖片
                }else{
                    image.setVisibility(View.GONE);
                }
            }
        }
    }

    public void back(View view) {
        finish();
    }
}