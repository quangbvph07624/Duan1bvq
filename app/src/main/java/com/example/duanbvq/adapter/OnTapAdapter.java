package com.example.duanbvq.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.duanbvq.R;
import com.example.duanbvq.activity.QuyDinhActivity;
import com.example.duanbvq.databinding.RowOntapBinding;
import com.example.duanbvq.model.OnTap;
import com.example.duanbvq.model.QuyDinh;

import java.util.ArrayList;

public class OnTapAdapter extends RecyclerView.Adapter<OnTapAdapter.ViewHolder>  {
    Context context;
    ArrayList<OnTap> onTaps;

    public OnTapAdapter(Context context, ArrayList<OnTap> onTaps) {
        this.context = context;
        this.onTaps = onTaps;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        RowOntapBinding rowOntapBinding= DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),R.layout.row_ontap,parent,false);
        return new ViewHolder(rowOntapBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        OnTap onTap=onTaps.get(position);
        holder.binding.setOntap(onTap);
        holder.binding.tvTitle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle=new Bundle();
                bundle.putString("id",onTaps.get(position).getId()+"");
                bundle.putString("name",onTaps.get(position).getTitle());
                Intent intent=new Intent(context, QuyDinhActivity.class);
                intent.putExtras(bundle);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return onTaps.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        RowOntapBinding binding;
        public ViewHolder(@NonNull RowOntapBinding itemView) {
            super(itemView.getRoot());
            binding=itemView;
        }
    }
}
