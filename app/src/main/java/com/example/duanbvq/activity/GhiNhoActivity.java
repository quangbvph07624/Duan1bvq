package com.example.duanbvq.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.inputmethod.EditorInfo;
import android.widget.ListView;
import android.widget.SearchView;


import com.example.duanbvq.database.DataBaseHelper;
import com.example.duanbvq.model.Ghinho;
import com.example.duanbvq.adapter.GhinhoAdapter;
import com.example.duanbvq.R;

import java.util.ArrayList;
import java.util.List;

public class GhiNhoActivity extends AppCompatActivity {
   RecyclerView rvghinho;
 ArrayList<Ghinho> list;
 GhinhoAdapter adapter;
 DataBaseHelper dataBaseHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ghi_nho);
        rvghinho=findViewById(R.id.rvghinho);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setTitle("Mẹo ghi nhớ");
        list= new ArrayList<>();
        dataBaseHelper = new DataBaseHelper(this);
        dataBaseHelper.createDataBase();
        list=dataBaseHelper.getAllGhi();
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        rvghinho.setLayoutManager(layoutManager);
        adapter=new GhinhoAdapter(this,list);
        rvghinho.setAdapter(adapter);

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



}
