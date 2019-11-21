package com.example.duanbvq.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ListView;

import com.example.duanbvq.model.Ghinho;
import com.example.duanbvq.adapter.GhinhoAdapter;
import com.example.duanbvq.R;

import java.util.ArrayList;
import java.util.List;

public class GhiNhoActivity extends AppCompatActivity {
    ListView lvlistghinho;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ghi_nho);
        lvlistghinho = findViewById(R.id.lvlistghinho);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setTitle("Mẹo ghi nhớ");
        List<Ghinho> ghinhoList = new ArrayList<>();
        ghinhoList.add(new Ghinho("Các câu hỏi sau chọn đáp án 1 :", "- Khái niệm: Khổ giới hạn đường bộ",
                "-Khái niệm: dãi phân cách", "- Khái niệm :đường chính", "- Khái niệm : Đường cao tốc", "- Khái niệm: phần đường xe chạy"));
        ghinhoList.add(new Ghinho("Các câu hỏi sau chọn đáp án 2 :", "- Khái niệm: Dừng xe",
                "-Khái niệm: Đỗ xe", "- Khái niệm : Phương tiện giao thông cơ giới đường bộ", "- Khái niệm : Đường ưu tiên", "- Khái niệm: Hàng nguy hiểm"));
        ghinhoList.add(new Ghinho("Các câu hỏi sau chọn đáp án 3 :", "- Khái niệm: Khổ giới hạn đường bộ",
                "-Khái niệm: dãi phân cách", "- Khái niệm :đường chính", "- Khái niệm : Đường cao tốc", "- Khái niệm: phần đường xe chạy"));
        ghinhoList.add(new Ghinho("Các câu hỏi sau chọn đáp án 4 :", "- Khái niệm: Dừng xe",
                "-Khái niệm: Đỗ xe", "- Khái niệm : Phương tiện giao thông cơ giới đường bộ", "- Khái niệm : Đường ưu tiên", "- Khái niệm: Hàng nguy hiểm"));
        GhinhoAdapter ghinhoAdapter = new GhinhoAdapter(GhiNhoActivity.this, ghinhoList);
        lvlistghinho.setAdapter(ghinhoAdapter);
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
