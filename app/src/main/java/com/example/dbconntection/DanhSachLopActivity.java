package com.example.dbconntection;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

import Adapter.LopHocAdapter;
import DAO.LopDAO;
import Model.LopHoc;

public class DanhSachLopActivity extends AppCompatActivity {
    ArrayList<LopHoc> list = new ArrayList<>();
    LopDAO lopDAO;
    LopHocAdapter lopAdapter;
    ListView lv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_danh_sach_lop);

        lv = findViewById(R.id.lvLopHoc);
        lopDAO =new LopDAO(DanhSachLopActivity.this);

        list =lopDAO.readAll();

        lopAdapter = new LopHocAdapter(DanhSachLopActivity.this,list);

        lv.setAdapter(lopAdapter);

        Button btn_Add = findViewById(R.id.btn_Add);
        //Event cho Add button
        btn_Add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DanhSachLopActivity.this, LopThemActivity.class);
                DanhSachLopActivity.this.startActivity(intent);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        list.clear();
        list.addAll(lopDAO.readAll());
        lopAdapter.notifyDataSetChanged();
        lv.setAdapter(lopAdapter);
    }
}