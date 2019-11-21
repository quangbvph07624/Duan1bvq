package com.example.duanbvq;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class GhinhoAdapter extends BaseAdapter {
    Context context;
    List<Ghinho> ghinhoList;
    public GhinhoAdapter(Context context,List<Ghinho> ghinhoList){
        this.context=context;
        this.ghinhoList=ghinhoList;
    }

    @Override
    public int getCount() {
        return ghinhoList.size();
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
        view= LayoutInflater.from(context).inflate(R.layout.row_ghinho,parent,false);
        TextView tvname1=view.findViewById(R.id.tvnameghinho);
        TextView tvmota1=view.findViewById(R.id.tvmota1);
        TextView tvmota2=view.findViewById(R.id.tvmota2);
        TextView tvmota3=view.findViewById(R.id.tvmota3);
        TextView tvmota4=view.findViewById(R.id.tvmota4);
        TextView tvmota5=view.findViewById(R.id.tvmota5);
        tvname1.setText(ghinhoList.get(position).getName());
        tvmota1.setText(ghinhoList.get(position).getMota1());
        tvmota2.setText(ghinhoList.get(position).getMota2());
        tvmota3.setText(ghinhoList.get(position).getMota3());
        tvmota4.setText(ghinhoList.get(position).getMota4());
        tvmota5.setText(ghinhoList.get(position).getMota5());
        return view;
    }
}
