package com.example.duanbvq.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.duanbvq.R;
import com.example.duanbvq.interfaces.Mainview;
import com.example.duanbvq.presenter.MainPresenter;

public class MainActivity extends AppCompatActivity implements Mainview {
    Intent intent;
    private Button btnontap, btnthi, btnbienbao, btnmeo;
    MainPresenter mainPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Ôn thi giấy phép A1");
        btnontap = findViewById(R.id.btnontap);
        btnthi = findViewById(R.id.btnthi);
        btnbienbao = findViewById(R.id.btnbienbao);
        btnmeo = findViewById(R.id.btnmeo);
        mainPresenter = new MainPresenter(this);

    }

    @Override
    public void navigate_ontap() {
        Intent intent = new Intent(MainActivity.this, OntapActivity.class);
        startActivity(intent);

    }

    @Override
    public void navigate_thi() {
        Intent intent = new Intent(MainActivity.this, WaitTracnghiemActivity.class);
        startActivity(intent);

    }

    @Override
    public void navigate_bienbao() {
        Intent intent = new Intent(MainActivity.this, BienBaoActivity.class);
        startActivity(intent);

    }

    @Override
    public void navigate_meo() {
        Intent intent = new Intent(MainActivity.this, GhiNhoActivity.class);
        startActivity(intent);

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


    public void openontep(View view) {
        if (view.getId() == R.id.btnontap) {
            mainPresenter.openontap();
        }
    }

    public void openthi(View view) {
        if (view.getId() == R.id.btnthi) {
            mainPresenter.openthi();
        }
    }

    public void openbienbao(View view) {
        if (view.getId() == R.id.btnbienbao) {
            mainPresenter.openbienbao();
        }
    }

    public void ghinho(View view) {
        if (view.getId() == R.id.btnmeo) {
            mainPresenter.openmeo();
        }
    }


}
