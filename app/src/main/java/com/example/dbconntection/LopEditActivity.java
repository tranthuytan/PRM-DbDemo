package com.example.dbconntection;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import DAO.LopDAO;
import Model.LopHoc;

public class LopEditActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lop_edit);

        EditText editText_maLop,editText_tenLop;
        ImageButton editOk;
        LopDAO dao;

        editText_maLop = findViewById(R.id.editText_maLop);
        editText_tenLop = findViewById(R.id.editText_tenLop);
        editOk = findViewById(R.id.btn_editOk);

        dao = new LopDAO(LopEditActivity.this);
        Intent editIntent =getIntent();
        LopHoc lop = (LopHoc) editIntent.getSerializableExtra("lophoc");

        //show current data
        editText_maLop.setText(lop.getMaLop());
        editText_tenLop.setText(lop.getTenLop());

        editOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String maLop = editText_maLop.getText().toString();
                String tenLop = editText_tenLop.getText().toString();
                if (dao.Update(new LopHoc(maLop,tenLop))) {
                    Toast.makeText(LopEditActivity.this,"Update success",Toast.LENGTH_LONG);
                    finish();
                }
                else {
                    Toast.makeText(LopEditActivity.this,"Update fail", Toast.LENGTH_LONG);
                    finish();
                }
            }
        });
    }
}