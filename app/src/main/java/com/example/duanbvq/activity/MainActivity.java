package com.example.duanbvq.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.duanbvq.R;

public class MainActivity extends AppCompatActivity {
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Ôn thi giấy phép A1");
    }

    public void opentracnghiem(View view) {
        Intent intent = new Intent(MainActivity.this, WaitTracnghiemActivity.class);
        startActivity(intent);
    }

    public void openbienbao(View view) {
        Intent intent = new Intent(MainActivity.this, BienBaoActivity.class);
        startActivity(intent);

    }

    public void ghinho(View view) {
        Intent intent = new Intent(MainActivity.this, GhiNhoActivity.class);
        startActivity(intent);
    }

    public void openontep(View view) {
        Intent intent = new Intent(MainActivity.this, OntapActivity.class);
        startActivity(intent);
    }
}
