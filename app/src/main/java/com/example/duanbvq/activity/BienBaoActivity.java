package com.example.duanbvq.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SearchView;

import com.example.duanbvq.adapter.BienBaoAdapter;
import com.example.duanbvq.adapter.GhinhoAdapter;
import com.example.duanbvq.database.DataBaseHelper;
import com.example.duanbvq.model.Bienbao;
import com.example.duanbvq.R;
import com.example.duanbvq.model.Ghinho;

import java.util.ArrayList;
import java.util.List;

public class BienBaoActivity extends AppCompatActivity {
    SearchView searchView;

    BienBaoAdapter adapter;
    RecyclerView rvbienbao;

    Context context;
    List<Bienbao> bienbaos = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bien_bao);
        setTitle("Các Biển Báo Giao Thông");
        rvbienbao = (RecyclerView) findViewById(R.id.lvbienbao);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        bienbaos.add(new Bienbao(101, R.drawable.duongcam, "Đường Cấm", "Biển báo cấm tất cả các phương tiện tham gia giao thông đi lại cả hai hướng. "));
        bienbaos.add(new Bienbao(102, R.drawable.img2, "Cấm đi ngược chiều", "Biển cấm đi ngược chiều là biển báo giao thông báo hiệu đường cấm tất cả các loại xe đi vào theo chiều đặt biển, trừ các xe được ưu tiên theo luật lệ nhà nước quy định."));
        bienbaos.add(new Bienbao(103, R.drawable.img3, "Cấm ô tô", "Biển báo đường cấm tất cả các loại xe cơ giới kể cả mô tô 3 bánh có thùng đi qua trừ xe mô tô 2 bánh, xe gắn máy. "));
        bienbaos.add(new Bienbao(103, R.drawable.img5, "Cấm ô tô và mô tô", "Biển báo đường cấm tất cả xe cơ giới và xe mô tô đi qua trừ xe gắn máy và xe được ưu tiên. "));
        bienbaos.add(new Bienbao(103, R.drawable.img4, "Cấm mô tô", "Biển báo đường cấm tất cả các loại mô tô đi qua, trừ các loại xe mô tô được ưu tiên. "));
        bienbaos.add(new Bienbao(103, R.drawable.img19, "Cấm ô tô kéo rơ móc", "Biển báo đường cấm tất cả các loại xe cơ giới kéo theo rơ móc kể cả xe mô tô,máy kéo. "));
        bienbaos.add(new Bienbao(103, R.drawable.img18, "Cấm ô tô tải chở hàng nguy hiểm", "Cấm tất cả các loại xe ô tô tải chở hàng nguy hiểm. "));
        bienbaos.add(new Bienbao(103, R.drawable.img17, "Cấm xe súc vật kéo", " "));
        bienbaos.add(new Bienbao(103, R.drawable.img8, "Hạn chế chiều ngang", "Cấm các loại phương tiện giao thông đường bộ kể cả các xe ưu tiên có chiều ngang vượt quá trị sô ghi trên biển."));
        bienbaos.add(new Bienbao(103, R.drawable.img7, "Cấm rẽ trái", " Biển báo đường cấm các loại phương tiện giao thông đường bộ rẽ trái, trừ các phương tiện giao thông được ưu tiên."));
        bienbaos.add(new Bienbao(103, R.drawable.img9, "Hạn chế chiều dài ô tô", " "));
        bienbaos.add(new Bienbao(103, R.drawable.img6, "Cấm người đi bộ", "Biển báo đường cấm người đi bộ qua lại"));
        bienbaos.add(new Bienbao(103, R.drawable.img10, "Cấm đi thẳng", "Cấm tất cả các loại phương tiện giao thông đường bộ đi thẳng ở nơi giao nhau"));
        bienbaos.add(new Bienbao(103, R.drawable.img21, "Cấm rẽ trái và rẽ phải", "Cấm tất cả các loại phương tiện giao thông đường bộ rẽ trái và rẽ phải ở nơi đường giao nhau"));
        bienbaos.add(new Bienbao(103, R.drawable.img13, "Đường bị hẹp bên trái", " "));
        bienbaos.add(new Bienbao(103, R.drawable.img14, "Các xe chỉ được rẽ phải", " Được đặt trước ngã ba, ngã tư.Các xe chỉ được rẽ phải ở phạm vi ngã ba, ngã tư đằng sau mặt biển"));
        bienbaos.add(new Bienbao(103, R.drawable.img16, "Ấn Còi", "Biển báo lệnh cho người lái xe phải bấm còi"));
        bienbaos.add(new Bienbao(103, R.drawable.img15, "Đường danh cho người đi bộ", " "));
        bienbaos.add(new Bienbao(103, R.drawable.img12, "Chỗ quay xe", "Biển chỉ dẫn vị trí được phép quay đầu xe kiểu chữ U.Biển báo không cấm rx trái "));


        rvbienbao.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        rvbienbao.setLayoutManager(linearLayoutManager);
        adapter = new BienBaoAdapter(bienbaos, BienBaoActivity.this);


        rvbienbao.setAdapter(adapter);

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
        final MenuItem item = menu.findItem(R.id.action_search);
        searchView = (SearchView) item.getActionView();

        searchView.findViewById(R.id.action_search);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                if (!searchView.isIconified()) {
                    searchView.setIconified(true);
                }
                item.collapseActionView();
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                final List<Bienbao> filtermodellist = filter(bienbaos, newText);
                adapter.setfilter(filtermodellist);
                return true;
            }
        });


        return true;
    }

    private List<Bienbao> filter(List<Bienbao> pl, String query) {
        query = query.toLowerCase();
        final List<Bienbao> filteredModelList = new ArrayList<>();
        for (Bienbao model : pl) {
            final String text = model.getName().toLowerCase();
            if (text.startsWith(query)) {
                filteredModelList.add(model);
            }
        }
        return filteredModelList;
    }
}
