package com.example.module_part3;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;

import androidx.annotation.NonNull;

import java.util.List;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ViewHolder> {


    Context c ;
    List<PlantData> pData;


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(c).inflate(R.layout.list_detail, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        PlantData plantData = pData.get(position);
        holder.nameText.setText(plantData.getName());
        holder.stateText.setText(plantData.getState());
        holder.priceText.setText(plantData.getWater());

        if (pData.get(position).getState() == "Making fruit")
        holder.plantIcon.setImageResource(R.drawable.grown);
        if (pData.get(position).getState() == "Sappling")
            holder.plantIcon.setImageResource(R.drawable.sappling);

    }

    public ItemAdapter(Context c, List<PlantData> pData){
        this.c = c;
        this.pData = pData;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public int getItemCount() {
        return pData.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView nameText;
        TextView stateText;
        TextView priceText;
        ImageView plantIcon;

        public ViewHolder(@NonNull View itemview) {
            super(itemview);

            nameText = itemview.findViewById(R.id.nameField);
            stateText = itemview.findViewById(R.id.descriptionField);
            priceText = itemview.findViewById(R.id.priceField);
            plantIcon = itemview.findViewById(R.id.plantIcon);
            //itemview.setOnClickListener((View.OnClickListener) this);

        }

        /*public void onClick(View view) {
            int position = (int) view.getTag();
            imageView.setImageResource(pData.get(position).getImageResourceId());
        }*/

    }

}
