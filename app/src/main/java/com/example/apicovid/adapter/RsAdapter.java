package com.example.apicovid.adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.apicovid.R;
import com.example.apicovid.model.rmsakit.RsDataItem;

import java.util.ArrayList;

public class RsAdapter extends RecyclerView.Adapter<RsAdapter.ViewHolder> {
    
    private ArrayList<RsDataItem> rsDataItems = new ArrayList<>();
    private Context context;

    public void setData(ArrayList<RsDataItem> items){
        rsDataItems.clear();
        rsDataItems.addAll(items);
        notifyDataSetChanged();
    }

    public RsAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_listrs,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.tv_rs.setText(rsDataItems.get(position).getNama());
        holder.tv_alamat.setText(rsDataItems.get(position).getAlamat());
        holder.btn_map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://maps.google.com/maps?q="+ rsDataItems.get(position).getAlamat()));
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return rsDataItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tv_rs,tv_alamat;
        Button btn_map;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_rs = itemView.findViewById(R.id.item_rs);
            tv_alamat = itemView.findViewById(R.id.item_alamat);
            btn_map = itemView.findViewById(R.id.item_btn_maps);
        }
    }
}