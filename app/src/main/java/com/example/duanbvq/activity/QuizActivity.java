package com.example.duanbvq.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.example.duanbvq.R;
import com.example.duanbvq.interfaces.Mainview;
import com.example.duanbvq.presenter.MainPresenter;

public class QuizActivity extends AppCompatActivity implements Mainview {
private MainPresenter mainPresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
mainPresenter=new MainPresenter(this);
        setContentView(R.layout.activity_quiz);
        setTitle("Câu Hỏi");
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
    public void navigate_ontap() {

    }

    @Override
    public void navigate_thi() {

    }

    @Override
    public void navigate_bienbao() {

    }

    @Override
    public void navigate_meo() {

    }

    @Override
    public void navigate_next() {
        Intent intent = new Intent(this, FinishTestActivity.class);
        startActivity(intent);

    }

    @Override
    public void navigate_one() {

    }

    @Override
    public void navigate_start() {

    }

    public void next(View view) {
        if (view.getId()==R.id.btnnext){
            mainPresenter.opennext();
        }

    }
}
