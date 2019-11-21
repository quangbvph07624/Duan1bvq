package com.example.duanbvq;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class BienBaoAdapter extends BaseAdapter {
    Context context;
    List<Bienbao> bienbaoList;
    public BienBaoAdapter (Context context,List<Bienbao> bienbaoList){
        this.context=context;
        this.bienbaoList=bienbaoList;
    }

    @Override
    public int getCount() {
        return bienbaoList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        view= LayoutInflater.from(context).inflate(R.layout.row_bienbao,parent,false);
        TextView tvid=view.findViewById(R.id.tvid);
        TextView tvname=view.findViewById(R.id.tvname);
        TextView tvmota=view.findViewById(R.id.tvmota);
        ImageView img1=view.findViewById(R.id.img1);
        tvid.setText(bienbaoList.get(position).getId()+"");
        tvname.setText(bienbaoList.get(position).getName());
        tvmota.setText(bienbaoList.get(position).getMota());
        img1.setImageResource(bienbaoList.get(position).getImage());
        return view;
    }
}
