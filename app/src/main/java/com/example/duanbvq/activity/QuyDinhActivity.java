package com.example.duanbvq.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.duanbvq.R;
import com.example.duanbvq.adapter.OnTapAdapter;
import com.example.duanbvq.adapter.QuyDinhAdapter;
import com.example.duanbvq.database.DataBaseHelper1;
import com.example.duanbvq.interfaces.Mainview;
import com.example.duanbvq.model.OnTap;
import com.example.duanbvq.model.QuyDinh;
import com.example.duanbvq.presenter.MainPresenter;

import java.util.ArrayList;

public class QuyDinhActivity extends AppCompatActivity implements Mainview {
    RecyclerView rvQuyDinh;
    ArrayList<QuyDinh> list;
    QuyDinhAdapter adapter;
    DataBaseHelper1 dataBaseHelper;
    Intent intent;
    MainPresenter mainPresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quy_dinh);
        mainPresenter=new MainPresenter(this);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setTitle("Quy Định");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        intent=getIntent();
        Bundle bundle=intent.getExtras();
        rvQuyDinh = findViewById(R.id.rvQuydinh);
        rvQuyDinh.setHasFixedSize(true);
        list= new ArrayList<>();
        dataBaseHelper = new DataBaseHelper1(this);
        dataBaseHelper.createDataBase();
        list=dataBaseHelper.getAllQuyDinh(bundle.getString("id"));
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        rvQuyDinh.setLayoutManager(layoutManager);
        adapter=new QuyDinhAdapter(this,list);
        rvQuyDinh.setAdapter(adapter);
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
}
