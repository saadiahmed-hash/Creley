package com.example.creley.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.creley.R;
import com.example.creley.Classes.RealEstate;
import com.example.creley.ViewHolders.estateViewHolder;

import java.util.ArrayList;

public class estateAdapter extends RecyclerView.Adapter<estateViewHolder> {
    Context context ;
    ArrayList<RealEstate> estates  ;
    public estateAdapter(Context context, ArrayList<RealEstate> estates) {
        this.context = context;
        this.estates = estates;
    }

    @NonNull
    @Override
    public estateViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.real_estate_item , parent , false);
        return new estateViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull estateViewHolder holder, int position) {
        RealEstate estate = estates.get(position);
        holder.wilayaTxt.setText(estate.getWilaya());
        holder.town.setText(estate.getTown());
        holder.typeTxt.setText(estate.getType());
        holder.priceTxt.setText(String.valueOf(estate.getPrice())+"DZ");
        holder.periodTypeTxt.setText("/"+estate.getPeriodType());
        holder.bathTxt.setText(String.valueOf(estate.getNbBathroom())+" Salles de bain");
        holder.bedsNbTxt.setText(String.valueOf(estate.getNbRoom())+" Lists");
        holder.surfaceTxt.setText(String.valueOf(estate.getSurface())+" m²");
    }

    @Override
    public int getItemCount() {
        return estates.size();
    }
}
