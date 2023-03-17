package com.example.dbconntection;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import DAO.LopDAO;
import Model.LopHoc;

public class LopThemActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lop_them);

        EditText editTextCreate_maLop,editTextCreate_tenLop;
        Button btnCreate_Add;
        LopDAO dao;

        editTextCreate_maLop = findViewById(R.id.editTextCreate_maLop);
        editTextCreate_tenLop = findViewById(R.id.editTextCreate_tenLop);
        btnCreate_Add = findViewById(R.id.btnCreate_Add);
        dao = new LopDAO(LopThemActivity.this);

        btnCreate_Add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (dao.Create(new LopHoc(editTextCreate_maLop.getText().toString(),editTextCreate_tenLop.getText().toString()))) {
                    Toast.makeText(LopThemActivity.this, "Create successfully", Toast.LENGTH_LONG);
                }
                else {
                    Toast.makeText(LopThemActivity.this,"Create failed", Toast.LENGTH_LONG);
                }
                finish();
            }
        });
    }
}