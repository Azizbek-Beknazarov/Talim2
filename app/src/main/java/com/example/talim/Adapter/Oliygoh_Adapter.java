package com.example.talim.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.talim.Activity.FanlarActivity;
import com.example.talim.Model.OliygohlarData;
import com.example.talim.R;

import java.util.List;

public class Oliygoh_Adapter extends RecyclerView.Adapter<Oliygoh_Adapter.OliygohViewHolder> {
    Context context;
    List<OliygohlarData> oliygohlarList;

    public Oliygoh_Adapter(Context context, List<OliygohlarData> oliygohlarList) {
        this.context = context;
        this.oliygohlarList = oliygohlarList;
    }

    @NonNull
    @Override
    public OliygohViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_row_oliygoh_nomi, parent, false);
        return new OliygohViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull OliygohViewHolder holder, final int position) {
        holder.nomi.setText(oliygohlarList.get(position).getNomi());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context, FanlarActivity.class);
                intent.putExtra("fan",oliygohlarList.get(position).getNomi());
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
               context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return oliygohlarList.size();
    }

    public void filterList(List<OliygohlarData> filteredList){
        oliygohlarList=filteredList;
        notifyDataSetChanged();
    }

    public static final class OliygohViewHolder extends RecyclerView.ViewHolder {
        TextView nomi;

        public OliygohViewHolder(@NonNull View itemView) {
            super(itemView);
            nomi = itemView.findViewById(R.id.text_view);
        }
    }
}
