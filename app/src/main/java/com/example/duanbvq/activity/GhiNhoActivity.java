package com.example.duanbvq.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ListView;

import com.example.duanbvq.databinding.ActivityGhiNhoBinding;
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
//        setContentView(R.layout.activity_ghi_nho);
//        lvlistghinho = findViewById(R.id.lvlistghinho);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setTitle("Mẹo ghi nhớ");
        ActivityGhiNhoBinding binding =
                DataBindingUtil.setContentView(this, R.layout.activity_ghi_nho);

        Ghinho ghinho = new Ghinho("Các câu hỏi sau chọn đáp án 1 :", "- Khái niệm: Khổ giới hạn đường bộ",
                "-Khái niệm: dãi phân cách", "- Khái niệm :đường chính", "- Khái niệm : Đường cao tốc", "- Khái niệm: phần đường xe chạy");
        Ghinho ghinho1 = new Ghinho("Các câu hỏi sau chọn đáp án 2 :", "- Khái niệm: Dừng xe",
                "-Khái niệm: Đỗ xe", "- Khái niệm : Phương tiện giao thông cơ giới đường bộ", "- Khái niệm : Đường ưu tiên", "- Khái niệm: Hàng nguy hiểm");
        Ghinho ghinho2 = new Ghinho("Các câu hỏi sau chọn đáp án 3 :", "- Khái niệm: Khổ giới hạn đường bộ",
                "-Khái niệm: dãi phân cách", "- Khái niệm :đường chính", "- Khái niệm : Đường cao tốc", "- Khái niệm: phần đường xe chạy");

        Ghinho ghinho3 = new Ghinho("Các câu hỏi sau chọn đáp án 4 :", "- Khái niệm: Khổ giới hạn đường bộ",
                "-Khái niệm: dãi phân cách", "- Khái niệm :đường chính", "- Khái niệm : Đường cao tốc", "- Khái niệm: phần đường xe chạy");
        binding.setGhinho(ghinho);
        binding.setGhinho(ghinho1);
        binding.setGhinho(ghinho2);
        binding.setGhinho(ghinho3);
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
