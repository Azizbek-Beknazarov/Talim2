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

import java.util.ArrayList;
import java.util.List;

public class ObunaAdapter extends RecyclerView.Adapter<ObunaAdapter.ViewHolder> {
    List<FanlarEntity> mList=new ArrayList<>();
    FanlarDB mDB;
    Context mContext;

    public ObunaAdapter(List<FanlarEntity> list, Context context) {
        mList = list;
        mContext = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        mDB=FanlarDB.getInstance(mContext);
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_fanlar,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        FanlarEntity entity=mList.get(position);
        String nom=entity.getFan_nomi();
        String ism=entity.getUqituvchi_ismi();
        int image=entity.getImageUrl();
holder.mTextView_fan_nomi.setText(nom);
holder.mTextView_uqituvchi.setText(ism);
holder.reklama_image.setImageResource(image);
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView mTextView_fan_nomi, mTextView_uqituvchi;
        ImageView reklama_image;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            mTextView_fan_nomi = itemView.findViewById(R.id.text_view_fan_nomi);
            mTextView_uqituvchi = itemView.findViewById(R.id.text_view_uqituvchi);
            reklama_image=itemView.findViewById(R.id.fav_Image);
        }
    }
}
