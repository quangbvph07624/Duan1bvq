package com.example.duanbvq.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.example.duanbvq.R;
import com.example.duanbvq.interfaces.FinishView;
import com.example.duanbvq.presenter.FinishPresenter;

public class QuizActivity extends AppCompatActivity implements FinishView {
private FinishPresenter finishPresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
finishPresenter=new FinishPresenter(this);
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
    public void navigate_next() {
        Intent intent = new Intent(this, FinishTestActivity.class);
        startActivity(intent);

    }
    public void next(View view) {
        if (view.getId()==R.id.btnnext){
            finishPresenter.opennext();
        }

    }
}
