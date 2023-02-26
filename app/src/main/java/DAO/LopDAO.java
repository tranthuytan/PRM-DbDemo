package DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

import Database.MyDatabase;
import Model.LopHoc;

public class LopDAO {
    MyDatabase myData;

    //Constructor
    public LopDAO(Context context) {
        this.myData = new MyDatabase(context);
    }

    //GetAll
    public ArrayList<LopHoc> readAll() {
        ArrayList<LopHoc> list = new ArrayList<>();
        SQLiteDatabase db = myData.getReadableDatabase();

        Cursor cs = db.rawQuery("SELECT * FROM LOP",null);
        //cursor move to the first row
        cs.moveToFirst();
        //loop until cursor after last
        while(!cs.isAfterLast()) {
            String maLop = cs.getString(0);
            String tenLop = cs.getString(1);
            list.add(new LopHoc(maLop,tenLop));
            cs.moveToNext();
        }
        return list;
    }

    public boolean Create(LopHoc lop) {
        SQLiteDatabase db = myData.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("MaLop",lop.getMaLop());
        values.put("TenLop",lop.getTenLop());
        long row = db.insert("LOP",null,values);
        return row>0;
    }

    public boolean Update(LopHoc lop) {
        SQLiteDatabase db = myData.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("TenLop",lop.getTenLop());
        long row = db.update("LOP",values,"MaLop=?",new String[]{lop.getMaLop()});
        return row>0;
    }
    public boolean Delete(String maLop) {
        SQLiteDatabase db = myData.getWritableDatabase();
        long row = db.delete("LOP","MaLop=?",new String[]{maLop});
        return row>0;
    }
}
