package com.example.talim.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.talim.Model.ReklamaData;
import com.example.talim.R;

import java.util.List;

public class Reklama_Adapter extends RecyclerView.Adapter<Reklama_Adapter.ReklamaViewHolder> {

   Context context;
    List<ReklamaData> reklamaData;

    public Reklama_Adapter(Context context, List<ReklamaData> reklamaData) {
        this.context = context;
        this.reklamaData = reklamaData;
    }

    @NonNull
    @Override
    public ReklamaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.item_row_reklama,
                parent, false);

        return new ReklamaViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ReklamaViewHolder holder, int position) {
    holder.mTextView_fan_nomi.setText(reklamaData.get(position).getFan_nomi());
    holder.mTextView_uqituvchi.setText(reklamaData.get(position).getUqituvchi_ismi());
    holder.reklama_image.setImageResource(reklamaData.get(position).getRasmURL());
    }

    @Override
    public int getItemCount() {
        return reklamaData.size();
    }

    public void filterList(List<ReklamaData> filteredList){
     reklamaData=filteredList;
     notifyDataSetChanged();
    }

    public class ReklamaViewHolder extends RecyclerView.ViewHolder {

        TextView mTextView_fan_nomi, mTextView_uqituvchi;
        ImageView reklama_image;


        public ReklamaViewHolder(@NonNull View itemView) {
            super(itemView);

            mTextView_fan_nomi = itemView.findViewById(R.id.text_view_fan_nomi);
            mTextView_uqituvchi = itemView.findViewById(R.id.text_view_uqituvchi);
            reklama_image=itemView.findViewById(R.id.reklama_Image);

        }
    }
}
