package com.example.duanbvq.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.duanbvq.R;

public class FinishTestActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finish_test);
        setTitle("Đã Hoàn Thành");
    }

    public void finish(View view) {
        Intent intent = new Intent(this, WaitTracnghiemActivity.class);
        startActivity(intent);
    }
}
