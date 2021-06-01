package com.example.foodqrapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {
    private Activity activity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageButton back = findViewById(R.id.back_btn);
        back.setOnClickListener(v -> onBackPressed());

        /*ImageButton map = (ImageButton) findViewById(R.id.map_btn);
        map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplication(), GoMapActivity.class);
                startActivity(intent);
                finish();
            }
        });*/

        ImageButton my_page = findViewById(R.id.mypage_btn);
        my_page.setOnClickListener(v -> {
            Intent intent = new Intent(getApplication(), MyPageActivity.class);
            startActivity(intent);
            finish();
        });

        /*ImageButton services = (ImageButton) findViewById(R.id.services_btn);
        services.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplication(), ServicesActivity.class);
                startActivity(intent);
                finish();
            }
        });*/
    }

    @Override
    public void onBackPressed() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("로그아웃 하시겠습니까?");

        builder.setPositiveButton("예", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                onBackPressed();
                finish();
            }
        });
        builder.setNegativeButton("아니오", null);

        builder.show();
    }
}