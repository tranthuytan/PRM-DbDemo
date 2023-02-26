package com.example.dbconntection;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
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