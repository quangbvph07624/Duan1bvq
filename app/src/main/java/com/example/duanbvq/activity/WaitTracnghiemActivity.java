package com.example.duanbvq.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.example.duanbvq.R;
import com.example.duanbvq.activity.QuizActivity;
import com.example.duanbvq.interfaces.QuizView;
import com.example.duanbvq.presenter.QuizPresenter;

public class WaitTracnghiemActivity extends AppCompatActivity implements QuizView {
    Intent intent;
    QuizPresenter quizPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Trắc Nghiệm");
        setContentView(R.layout.activity_wait_tracnghiem);
        quizPresenter=new QuizPresenter(this);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }



    @Override
    public void navigate_start() {
        Intent intent = new Intent(this, QuizActivity.class);
        startActivity(intent);

    }
    public void start(View view) {
        if (view.getId()==R.id.btnstart){
            quizPresenter.openStart();

        }
    }
}
