package com.example.module_part3;


import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;

import androidx.annotation.NonNull;

import java.util.List;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ViewHolder> {


    Context c ;
    static List<PlantData> pData;

    private static FragmentManager fragmentManager;


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
        holder.waterText.setText(plantData.getWater());

        switch (plantData.getState()) {
            case "Making fruit":
                holder.plantIcon.setImageResource(R.drawable.grown);
                break;
            case "Sappling":
                holder.plantIcon.setImageResource(R.drawable.sappling);
                break;
            default:
                holder.plantIcon.setImageResource(R.drawable.seedling);
                break;
        }
    }

    public ItemAdapter(Context c, List<PlantData> pData, FragmentManager fragmentManager){
        this.c = c;
        this.pData = pData;
        this.fragmentManager = fragmentManager;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public int getItemCount() {
        return pData.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, DeleteDialogFragment.OnDeleteDialogListener {
        TextView nameText;
        TextView stateText;
        TextView waterText;
        ImageView plantIcon;

        public ViewHolder(@NonNull View itemview) {
            super(itemview);

            nameText = itemview.findViewById(R.id.nameField);
            stateText = itemview.findViewById(R.id.descriptionField);
            waterText = itemview.findViewById(R.id.priceField);
            plantIcon = itemview.findViewById(R.id.plantIcon);

            itemview.setOnClickListener((View.OnClickListener) this);

        }

        @Override
        public void onClick(View view) {
            DeleteDialogFragment alert = new DeleteDialogFragment();
            alert.setOnDeleteDialogListener(ViewHolder.this);
            alert.show(fragmentManager, "Plant delete");
        }

        public void onConfirmDelete() {
            PlantData plantData = pData.get(getAdapterPosition());
            pData.remove(plantData);
            notifyItemRemoved(getAdapterPosition());
            notifyItemRangeChanged(getAdapterPosition(), pData.size()-getAdapterPosition());

        }


    }

}
