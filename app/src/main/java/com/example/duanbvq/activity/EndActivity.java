package com.example.duanbvq.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.duanbvq.R;

public class EndActivity extends AppCompatActivity {

    TextView tv_result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end);
        tv_result=findViewById(R.id.result);
        setTitle("Hoàn Thành");

        int corect=getIntent().getIntExtra("correct",0);
        int wrong=getIntent().getIntExtra("wrong",0);
        tv_result.setText("Điểm: "+corect+"\nCâu Sai: "+ wrong);
    }

    public void btn(View view) {
        Intent intent=new Intent(EndActivity.this,WaitTracnghiemActivity.class);
        startActivity(intent);
    }
}

