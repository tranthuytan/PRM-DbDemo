package Adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.dbconntection.LopEditActivity;
import com.example.dbconntection.LopThemActivity;
import com.example.dbconntection.R;

import java.util.ArrayList;

import DAO.LopDAO;
import Model.LopHoc;

public class LopHocAdapter extends BaseAdapter {
    Context context;
    ArrayList<LopHoc> data;
    LopDAO dao;

    public LopHocAdapter(Context context, ArrayList<LopHoc> data) {
        this.context = context;
        this.data = data;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int i) {
        return data.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {
        Holder holder = new Holder();

        if(convertView==null) {
            LayoutInflater inflater = ((Activity)context).getLayoutInflater();
            convertView =inflater.inflate(R.layout.lophoc_item,null);

            //anh xa cac thanh phan o layout lophoc_item.xml
            holder.textView_maLop =convertView.findViewById(R.id.textView_maLop);
            holder.textView_tenLop =convertView.findViewById(R.id.textView_tenLop);
            holder.btn_Edit = convertView.findViewById(R.id.btnEdit);
            holder.btn_Delete = convertView.findViewById(R.id.btnDelete);

            convertView.setTag(holder);

        }
        //Event cho Edit button
        holder.btn_Edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, LopEditActivity.class);
                intent.putExtra("lophoc",data.get(position));
                ((Activity)context).startActivity(intent);
            }
        });

        //Hien thi du lieu cac thanh phan layout.xml
        holder.textView_maLop.setText(data.get(position).getMaLop());
        holder.textView_tenLop.setText(data.get(position).getTenLop());

        return convertView;
    }
    static class Holder {
        ImageButton btn_Edit, btn_Delete;
        TextView textView_maLop, textView_tenLop;
        Button btn_Add;
    }
}
