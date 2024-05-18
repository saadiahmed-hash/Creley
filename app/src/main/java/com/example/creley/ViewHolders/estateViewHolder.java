package com.example.creley.ViewHolders;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.creley.R;

public class estateViewHolder extends RecyclerView.ViewHolder {
    public ImageView houseImg ;
    public TextView typeTxt ,   priceTxt , periodTypeTxt , wilayaTxt , town , bedsNbTxt , bathTxt , surfaceTxt;
    public estateViewHolder(@NonNull View itemView) {
        super(itemView);
        houseImg = itemView.findViewById(R.id.houseImg);
        typeTxt = itemView.findViewById(R.id.typeTxt);
        priceTxt = itemView.findViewById(R.id.priceTxt);
        periodTypeTxt = itemView.findViewById(R.id.periodTypeTxt);
        wilayaTxt = itemView.findViewById(R.id.wilayaTxt);
        town = itemView.findViewById(R.id.town);
        bedsNbTxt = itemView.findViewById(R.id.bedsNbTxt);
        bathTxt = itemView.findViewById(R.id.bathTxt);
        surfaceTxt = itemView.findViewById(R.id.surfaceTxt);

    }
}
