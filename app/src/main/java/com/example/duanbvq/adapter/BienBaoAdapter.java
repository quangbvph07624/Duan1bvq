package com.example.duanbvq.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.duanbvq.model.Bienbao;
import com.example.duanbvq.R;
import com.example.duanbvq.model.Ghinho;

import java.util.ArrayList;
import java.util.List;

public class BienBaoAdapter extends RecyclerView.Adapter<BienBaoAdapter.BienBaoViewHolder>  {
    private List<Bienbao> bienbaoList;

   private Context context;



    public BienBaoAdapter(List<Bienbao> bienbaoList,Context context) {
        this.bienbaoList=bienbaoList;
        this.context=context;
    }


    @NonNull
    @Override
    public BienBaoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_bienbao, parent, false);
        return new BienBaoViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull BienBaoAdapter.BienBaoViewHolder holder, int position) {
        Bienbao bienbao = bienbaoList.get(position);
        holder.img1.setImageResource(bienbao.getImage());
        holder.tvmota.setText(bienbao.getMota());
        holder.tvname.setText(bienbao.getName());
    }
    @Override
    public int getItemCount() {
        return bienbaoList.size();
    }
    public void setfilter(List<Bienbao> listitem){
        bienbaoList=new ArrayList<>();
        bienbaoList.addAll(listitem);
        notifyDataSetChanged();

    }

    class BienBaoViewHolder extends RecyclerView.ViewHolder{
        ImageView img1;
        TextView tvname;
        TextView tvmota;
        public BienBaoViewHolder(@NonNull View itemView) {
            super(itemView);
            tvname = itemView.findViewById(R.id.tvname);
            tvmota = itemView.findViewById(R.id.tvmota);
            img1 = itemView.findViewById(R.id.img1);

        }

    }
}
