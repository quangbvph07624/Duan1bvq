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
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.duanbvq.databinding.RowGhinhoBinding;
import com.example.duanbvq.databinding.RowQuydinhBinding;
import com.example.duanbvq.model.Bienbao;
import com.example.duanbvq.model.Ghinho;
import com.example.duanbvq.R;
import com.example.duanbvq.model.QuyDinh;

import java.util.ArrayList;
import java.util.List;

public class GhinhoAdapter extends RecyclerView.Adapter<GhinhoAdapter.ViewHolder> {
    Context context;
    ArrayList<Ghinho> ghinhoArrayList;

    public GhinhoAdapter(Context context, ArrayList<Ghinho> ghinhoArrayList) {
        this.context = context;
        this.ghinhoArrayList = ghinhoArrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
         RowGhinhoBinding rowGhinhoBinding= DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.row_ghinho,parent,false);
        return new ViewHolder(rowGhinhoBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Ghinho ghinho=ghinhoArrayList.get(position);
        holder.binding.setGhinho(ghinho);

    }


    @Override
    public int getItemCount() {
        return ghinhoArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        RowGhinhoBinding binding;
        public ViewHolder(@NonNull RowGhinhoBinding itemView) {
            super(itemView.getRoot());
            binding=itemView;
        }
    }

}
