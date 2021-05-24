package com.example.talim.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.talim.Database.FanlarDB;
import com.example.talim.Model.FanlarEntity;
import com.example.talim.R;

import java.util.List;


public class YoqtirganlarAdapter extends RecyclerView.Adapter<YoqtirganlarAdapter.ViewHolder> {
    List<FanlarEntity> mList;
    Context mContext;
    FanlarDB mDB;

    public YoqtirganlarAdapter(List<FanlarEntity> list, Context context) {
        mList = list;
        mContext = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        mDB=FanlarDB.getInstance(mContext);
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_fanlar, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {


        holder.mFan.setText(mList.get(position).getFan_nomi());
        holder.mIsm.setText(mList.get(position).getUqituvchi_ismi());
        holder.mimageurl.setImageResource(mList.get(position).getImageUrl());
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView mFan, mIsm, mBush;
        ImageView mimageurl;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mFan = itemView.findViewById(R.id.text_view_fan_nomi);
            mIsm = itemView.findViewById(R.id.text_view_uqituvchi);
            mimageurl = itemView.findViewById(R.id.fav_Image);

        }
    }
}
