package com.example.duanbvq.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ListView;

import com.example.duanbvq.adapter.BienBaoAdapter;
import com.example.duanbvq.model.Bienbao;
import com.example.duanbvq.R;

import java.util.ArrayList;
import java.util.List;

public class BienBaoActivity extends AppCompatActivity {
    ListView lvbienbao;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bien_bao);
        setTitle("Các Biển Báo Giao Thông");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        lvbienbao = findViewById(R.id.lvbienbao);
        List<Bienbao> bienbaos = new ArrayList<>();
        bienbaos.add(new Bienbao(102, R.drawable.bienbao, "Đường Cấm", "Biển báo cấm tất cả các phương tiện tham gia giao thông đi lại cả hai hướng. "));
        bienbaos.add(new Bienbao(102, R.drawable.bienbao, "Đường Cấm", "Biển báo cấm tất cả các phương tiện tham gia giao thông đi lại cả hai hướng. "));
        bienbaos.add(new Bienbao(102, R.drawable.bienbao, "Đường Cấm", "Biển báo cấm tất cả các phương tiện tham gia giao thông đi lại cả hai hướng. "));
        bienbaos.add(new Bienbao(102, R.drawable.bienbao, "Đường Cấm", "Biển báo cấm tất cả các phương tiện tham gia giao thông đi lại cả hai hướng. "));
        bienbaos.add(new Bienbao(102, R.drawable.bienbao, "Đường Cấm", "Biển báo cấm tất cả các phương tiện tham gia giao thông đi lại cả hai hướng. "));
        bienbaos.add(new Bienbao(102, R.drawable.bienbao, "Đường Cấm", "Biển báo cấm tất cả các phương tiện tham gia giao thông đi lại cả hai hướng. "));
        bienbaos.add(new Bienbao(102, R.drawable.bienbao, "Đường Cấm", "Biển báo cấm tất cả các phương tiện tham gia giao thông đi lại cả hai hướng. "));
        bienbaos.add(new Bienbao(102, R.drawable.bienbao, "Đường Cấm", "Biển báo cấm tất cả các phương tiện tham gia giao thông đi lại cả hai hướng. "));
        bienbaos.add(new Bienbao(102, R.drawable.bienbao, "Đường Cấm", "Biển báo cấm tất cả các phương tiện tham gia giao thông đi lại cả hai hướng. "));
        bienbaos.add(new Bienbao(102, R.drawable.bienbao, "Đường Cấm", "Biển báo cấm tất cả các phương tiện tham gia giao thông đi lại cả hai hướng. "));
        bienbaos.add(new Bienbao(102, R.drawable.bienbao, "Đường Cấm", "Biển báo cấm tất cả các phương tiện tham gia giao thông đi lại cả hai hướng. "));
        bienbaos.add(new Bienbao(102, R.drawable.bienbao, "Đường Cấm", "Biển báo cấm tất cả các phương tiện tham gia giao thông đi lại cả hai hướng. "));
        bienbaos.add(new Bienbao(102, R.drawable.bienbao, "Đường Cấm", "Biển báo cấm tất cả các phương tiện tham gia giao thông đi lại cả hai hướng. "));
        bienbaos.add(new Bienbao(102, R.drawable.bienbao, "Đường Cấm", "Biển báo cấm tất cả các phương tiện tham gia giao thông đi lại cả hai hướng. "));
        bienbaos.add(new Bienbao(102, R.drawable.bienbao, "Đường Cấm", "Biển báo cấm tất cả các phương tiện tham gia giao thông đi lại cả hai hướng. "));
        bienbaos.add(new Bienbao(102, R.drawable.bienbao, "Đường Cấm", "Biển báo cấm tất cả các phương tiện tham gia giao thông đi lại cả hai hướng. "));
        bienbaos.add(new Bienbao(102, R.drawable.bienbao, "Đường Cấm", "Biển báo cấm tất cả các phương tiện tham gia giao thông đi lại cả hai hướng. "));
        bienbaos.add(new Bienbao(102, R.drawable.bienbao, "Đường Cấm", "Biển báo cấm tất cả các phương tiện tham gia giao thông đi lại cả hai hướng. "));
        bienbaos.add(new Bienbao(102, R.drawable.bienbao, "Đường Cấm", "Biển báo cấm tất cả các phương tiện tham gia giao thông đi lại cả hai hướng. "));
        BienBaoAdapter bienBaoAdapter = new BienBaoAdapter(BienBaoActivity.this, bienbaos);
        lvbienbao.setAdapter(bienBaoAdapter);
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
}
