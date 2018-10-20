package com.example.t.makanan;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

/**
 * Created by t on 8/23/2018.
 */

public class Adapter extends BaseAdapter {
    Context con;
    ArrayList<Model> mlist;
    public Model mdl;
    String nama,asal,kemasan;
    public Adapter(Context con ,ArrayList<Model> mlist)
    {
        this.con = con;
        this.mlist = mlist;
    }

    @Override
    public int getCount() {
        return mlist.size();
    }

    @Override
    public Object getItem(int position) {
        return mlist.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        mdl = mlist.get(position);
        LayoutInflater inflater = (LayoutInflater)con.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(R.layout.item,parent,false);
        TextView tv1 = convertView.findViewById(R.id.txtNama);
        tv1.setText(mdl.getNama_makanan());
        TextView tv2 = convertView.findViewById(R.id.txtAsal);
        tv2.setText(mdl.getAsal());
        TextView tv3 = convertView.findViewById(R.id.txtKemasan);
        tv3.setText(mdl.getKemasan());
        ImageView img = convertView.findViewById(R.id.imgMakanan);
        Glide.with(convertView).load(mdl.getFoto_produk()).into(img);
        return convertView;
    }
}
