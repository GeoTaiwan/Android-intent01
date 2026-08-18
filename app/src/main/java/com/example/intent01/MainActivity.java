package com.example.intent01;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.Group;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    TextView tv_main;
    Button btn_start_activity_two,btn_start_activity_three,btn_set_visibility;
    Group vg_1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
//            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
//            return insets;
//        });
        tv_main = findViewById(R.id.tv_main);
        btn_start_activity_two = findViewById(R.id.btn_start_activity_two);
        btn_start_activity_three = findViewById(R.id.btn_start_activity_three);
        btn_set_visibility = findViewById(R.id.btn_set_visibility);

        vg_1=findViewById(R.id.vg_1);

        btn_start_activity_two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_01;
                intent_01 = new Intent(MainActivity.this, Activity_Two.class);
                startActivity(intent_01);
            }
        });

        btn_start_activity_three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_01;
                intent_01 = new Intent(MainActivity.this, Activity_Three.class);
                startActivity(intent_01);
            }
        });

        btn_set_visibility.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vg_1.setVisibility(View.INVISIBLE);
                tv_main.setText("-= 這是主畫面 =-\n顯示狀態：" + vg_1.getVisibility());

                Handler visibilityHandler = new Handler();
                visibilityHandler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        vg_1.setVisibility(View.VISIBLE);
                        tv_main.setText("-= 這是主畫面 =-\n顯示狀態：" + vg_1.getVisibility());
                    }
                },5000);
                visibilityHandler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        tv_main.setText("-= 這是主畫面 =-");
                    }
                },7000);

            }
        });

    }


}