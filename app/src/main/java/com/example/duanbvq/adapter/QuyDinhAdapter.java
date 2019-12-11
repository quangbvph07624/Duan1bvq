package com.example.duanbvq.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.duanbvq.R;
import com.example.duanbvq.databinding.RowOntapBinding;
import com.example.duanbvq.databinding.RowQuydinhBinding;
import com.example.duanbvq.model.OnTap;
import com.example.duanbvq.model.QuyDinh;

import java.util.ArrayList;

public class QuyDinhAdapter extends RecyclerView.Adapter<QuyDinhAdapter.ViewHolder> {
    Context context;
    ArrayList<QuyDinh> quyDinhs;

    public QuyDinhAdapter(Context context, ArrayList<QuyDinh> quyDinhs) {
        this.context = context;
        this.quyDinhs = quyDinhs;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        RowQuydinhBinding rowQuydinhBinding= DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.row_quydinh,parent,false);
        return new ViewHolder(rowQuydinhBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        QuyDinh quyDinh=quyDinhs.get(position);
        holder.binding.setQuydinh(quyDinh);
        }

    @Override
    public int getItemCount() {
        return quyDinhs.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        RowQuydinhBinding binding;
        public ViewHolder(@NonNull RowQuydinhBinding itemView) {
            super(itemView.getRoot());
            binding=itemView;
        }
    }
}
