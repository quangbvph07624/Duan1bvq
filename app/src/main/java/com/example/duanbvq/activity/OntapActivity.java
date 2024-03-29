package com.example.duanbvq.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.example.duanbvq.R;
import com.example.duanbvq.adapter.OnTapAdapter;
import com.example.duanbvq.database.DataBaseHelper1;
import com.example.duanbvq.interfaces.Mainview;
import com.example.duanbvq.model.OnTap;
import com.example.duanbvq.presenter.MainPresenter;

import java.util.ArrayList;

public class OntapActivity extends AppCompatActivity implements Mainview {
    RecyclerView rvOnTap;
    ArrayList<OnTap> list;
    OnTapAdapter adapter;
    DataBaseHelper1 dataBaseHelper;
    Intent intent;
    MainPresenter mainPresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Ôn tập các câu hỏi");
        setContentView(R.layout.activity_ontap);
        mainPresenter=new MainPresenter(this);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        intent=getIntent();
        Bundle bundle=intent.getExtras();
        rvOnTap = findViewById(R.id.rvOntap);
        rvOnTap.setHasFixedSize(true);
        list= new ArrayList<>();
        dataBaseHelper = new DataBaseHelper1(this);
        dataBaseHelper.createDataBase();
        list=dataBaseHelper.getAllOnTap();
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        rvOnTap.setLayoutManager(layoutManager);
        adapter=new OnTapAdapter(this,list);
        rvOnTap.setAdapter(adapter);

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

    }

    @Override
    public void navigate_one() {
    }

    @Override
    public void navigate_start() {

    }

    public void one(View view) {

    }
}
