package com.example.duanbvq.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.example.duanbvq.R;
import com.example.duanbvq.interfaces.OnTapView;
import com.example.duanbvq.presenter.MainPresenter;
import com.example.duanbvq.presenter.Ontappresenter;

public class OntapActivity extends AppCompatActivity implements OnTapView {
    Button btnone;
    private Ontappresenter ontappresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Ôn tập các câu hỏi");
        setContentView(R.layout.activity_ontap);
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
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.search_menu, menu);
        MenuItem item = menu.findItem(R.id.action_search);
        return super.onCreateOptionsMenu(menu);
    }



    @Override
    public void navigate_one() {
        Intent intent = new Intent(OntapActivity.this, ExxampleActivity.class);
        startActivity(intent);
    }
    public void one(View view) {
        if (view.getId()==R.id.btnone){
       ontappresenter.openone();
        }

    }
}
