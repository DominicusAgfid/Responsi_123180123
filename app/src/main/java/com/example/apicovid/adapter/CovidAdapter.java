package com.example.apicovid.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.apicovid.R;
import com.example.apicovid.model.Covid.CovidContentItem;

import java.util.ArrayList;

public class CovidAdapter extends RecyclerView.Adapter<CovidAdapter.ViewHolder> {

    private ArrayList<CovidContentItem> covidItem = new ArrayList<>();
    private Context context;

    public void setData(ArrayList<CovidContentItem> items){
        covidItem.clear();
        covidItem.addAll(items);
        notifyDataSetChanged();
    }

    public CovidAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_listcovid,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.tv_tanggal.setText(covidItem.get(position).getTanggal()+"");
        holder.tv_terkonfirmasi.setText("Terkonfimasi : "+covidItem.get(position).getConfirmationDiisolasi()+"");
        holder.tv_sembuh.setText("Sembuh : "+covidItem.get(position).getConfirmationSelesai()+"");
        holder.tv_meninggal.setText("Meninggal : "+covidItem.get(position).getConfirmationMeninggal()+"");
    }

    @Override
    public int getItemCount() {
        return covidItem.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tv_tanggal,tv_terkonfirmasi,tv_sembuh,tv_meninggal;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tv_tanggal = itemView.findViewById(R.id.item_tanggal);
            tv_terkonfirmasi = itemView.findViewById(R.id.item_terkonfirmasi);
            tv_sembuh = itemView.findViewById(R.id.item_sembuh);
            tv_meninggal = itemView.findViewById(R.id.item_meninggal);
        }
    }
}
