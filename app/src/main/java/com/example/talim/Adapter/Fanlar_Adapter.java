package com.example.talim.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.talim.Activity.KursDetailActivity;
import com.example.talim.Model.FanlarEntity;
import com.example.talim.R;

import java.util.List;

public class Fanlar_Adapter extends RecyclerView.Adapter<Fanlar_Adapter.FanlarViewHolder> {
    Context mContext;
    List<FanlarEntity> mFanlarData;

    public Fanlar_Adapter(Context mContext, List<FanlarEntity> mFanlarData) {
        this.mContext = mContext;
        this.mFanlarData = mFanlarData;
    }

    @NonNull
    @Override
    public FanlarViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    View view= LayoutInflater.from(mContext).inflate(R.layout.item_fanlar,parent,false);
        return new FanlarViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FanlarViewHolder holder, final int position) {
        holder.mTextView_fan_nomi.setText(mFanlarData.get(position).getFan_nomi());
        holder.mTextView_uqituvchi.setText(mFanlarData.get(position).getUqituvchi_ismi());
        holder.reklama_image.setImageResource(mFanlarData.get(position).getImageUrl());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Intent intent=new Intent(mContext, KursDetailActivity.class);
               intent.putExtra("fan",mFanlarData.get(position).getFan_nomi());
               intent.putExtra("uqituvchi",mFanlarData.get(position).getUqituvchi_ismi());
               intent.putExtra("image_d",mFanlarData.get(position).getImageUrl());
               intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
               mContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mFanlarData.size();
    }
    public void filterList(List<FanlarEntity> filteredList){
        mFanlarData=filteredList;
        notifyDataSetChanged();
    }

    public class FanlarViewHolder extends RecyclerView.ViewHolder {
        TextView mTextView_fan_nomi, mTextView_uqituvchi;
        ImageView reklama_image;
        public FanlarViewHolder(@NonNull View itemView) {
            super(itemView);

            mTextView_fan_nomi = itemView.findViewById(R.id.text_view_fan_nomi);
            mTextView_uqituvchi = itemView.findViewById(R.id.text_view_uqituvchi);
            reklama_image=itemView.findViewById(R.id.fav_Image);
        }
    }
}
