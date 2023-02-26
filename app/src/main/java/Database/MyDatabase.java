package Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.annotation.Nullable;

public class MyDatabase extends SQLiteOpenHelper {

    public MyDatabase(@Nullable Context context) {
        super(context,"ClassManagement",null,1);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        //Create class table
        String sql = "CREATE TABLE LOP(MaLop text primary key not null, TenLop Text)";
        db.execSQL(sql);

        db.execSQL("INSERT INTO LOP VALUES('lop01','Smarting')");
        db.execSQL("INSERT INTO LOP VALUES('lop02','Development')");
        db.execSQL("INSERT INTO LOP VALUES('lop03','Create')");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS LOP");
    }
}
