package com.example.creley;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.creley.Adapters.estateAdapter;
import com.example.creley.Classes.RealEstate;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;


public class HomeFrag extends Fragment {
   protected LinearLayout allFilter , apartmentFilter , bungalowFilter , chaletFilter , cTouriFilter , localFilter , villaFilter , studioFilter ;
   protected ImageView allImg , apartmentImg , bungalowImg , chaletImg , cTouriImg , localImg , villaImg , studioImg ;
   protected TextView    allTxt , apartmentTxt , chaletTxt , bungalowTxt , cTouriTxt , localTxt , villaTxt , studioTxt ;
   protected RecyclerView estateRecycler ;

   protected estateAdapter adapter ;
   protected ArrayList<RealEstate> estates ;

    protected FirebaseDatabase firebaseDatabase;
    protected DatabaseReference estateRef;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        init(view);
        fetchData();

        allFilter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // call filter here
                active(allImg , allTxt  , view);
            }
        });
        apartmentFilter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                active(apartmentImg , apartmentTxt , view);
            }
        });
        bungalowFilter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                active(bungalowImg , bungalowTxt , view);
            }
        });
        chaletFilter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                active(chaletImg , chaletTxt , view);
            }
        });
        cTouriFilter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                active(cTouriImg , cTouriTxt , view);
            }
        });
        localFilter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                active(localImg , localTxt , view);
            }
        });
        villaFilter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                active(villaImg , villaTxt , view);
            }
        });
        studioFilter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                active(studioImg , studioTxt , view);
            }
        });
        return view ;
    }
    private void init(View view){
        estateRecycler = view.findViewById(R.id.estateRecycler);
        estates = new ArrayList<>();
        allImg  = view.findViewById(R.id.allImg);
        apartmentImg  = view.findViewById(R.id.apartmentImg);
        bungalowImg  = view.findViewById(R.id.bungalowImg);
        chaletImg  = view.findViewById(R.id.chaletImg);
        cTouriImg  = view.findViewById(R.id.cTouriImg);
        localImg  = view.findViewById(R.id.localImg);
        villaImg  = view.findViewById(R.id.villaImg);
        studioImg  = view.findViewById(R.id.studioImg);

        allFilter  = view.findViewById(R.id.allFilter);
        apartmentFilter  = view.findViewById(R.id.apartmentFilter);
        bungalowFilter  = view.findViewById(R.id.bungalowFilter);
        chaletFilter  = view.findViewById(R.id.chaletFilter);
        cTouriFilter  = view.findViewById(R.id.cTouriFilter);
        localFilter  = view.findViewById(R.id.localFilter);
        villaFilter  = view.findViewById(R.id.villaFilter);
        studioFilter  = view.findViewById(R.id.studioFilter);

        allTxt  = view.findViewById(R.id.allTxt);
        apartmentTxt  = view.findViewById(R.id.apartmentTxt);
        bungalowTxt  = view.findViewById(R.id.bungalowTxt);
        chaletTxt  = view.findViewById(R.id.chaletTxt);
        cTouriTxt  = view.findViewById(R.id.cTouriTxt);
        localTxt  = view.findViewById(R.id.localTxt);
        villaTxt  = view.findViewById(R.id.villaTxt);
        studioTxt  = view.findViewById(R.id.studioTxt);


        firebaseDatabase = FirebaseDatabase.getInstance("https://creley-c78b8-default-rtdb.europe-west1.firebasedatabase.app/") ;
        estateRef = firebaseDatabase.getReference().child("RealEstate");

    }
    private void active(ImageView img , TextView txt , View v){
        allImg.setColorFilter(v.getContext().getColor(R.color.reg_black));
        apartmentImg.setColorFilter(v.getContext().getColor(R.color.reg_black));
        bungalowImg.setColorFilter(v.getContext().getColor(R.color.reg_black));
        chaletImg.setColorFilter(v.getContext().getColor(R.color.reg_black));
        cTouriImg.setColorFilter(v.getContext().getColor(R.color.reg_black));
        localImg.setColorFilter(v.getContext().getColor(R.color.reg_black));
        villaImg.setColorFilter(v.getContext().getColor(R.color.reg_black));
        studioImg.setColorFilter(v.getContext().getColor(R.color.reg_black));
        img.setColorFilter(v.getContext().getColor(R.color.mainColor));

        allTxt.setTextColor(v.getContext().getColor(R.color.reg_black));
        apartmentTxt.setTextColor(v.getContext().getColor(R.color.reg_black));
        bungalowTxt.setTextColor(v.getContext().getColor(R.color.reg_black));
        chaletTxt.setTextColor(v.getContext().getColor(R.color.reg_black));
        cTouriTxt.setTextColor(v.getContext().getColor(R.color.reg_black));
        localTxt.setTextColor(v.getContext().getColor(R.color.reg_black));
        villaTxt.setTextColor(v.getContext().getColor(R.color.reg_black));
        studioTxt.setTextColor(v.getContext().getColor(R.color.reg_black));
        txt.setTextColor(v.getContext().getColor(R.color.mainColor));

    }

    private void fetchData(){
        estateRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                estates.clear();
                for (DataSnapshot oneSnap: snapshot.getChildren()) {
                    for (DataSnapshot oneSubSnap:oneSnap.getChildren()) {
                        estates.add(oneSubSnap.getValue(RealEstate.class));
                    }
                }
                adapter = new estateAdapter(getContext() , estates);
                estateRecycler.setAdapter(adapter);
                estateRecycler.setLayoutManager(new LinearLayoutManager(getContext()));
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}