package com.example.creley;

import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

public class Offrir_Home_Activity extends AppCompatActivity {

    protected LinearLayout addBtn , reqBtn, profBtn ;
    protected ImageView addImg, reqImg, profImg  ;
    protected TextView addTxt, reqTxt, profTxt ;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_offrir_home);
        init();
        // req its refer to list of houses
        activeBottom(addTxt, addImg);
        desActiveBottom(profTxt, profImg);
        desActiveBottom(reqTxt , reqImg);
        setFragment(new Add_Home_Frag());
        reqBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                activeBottom(reqTxt, reqImg);
                desActiveBottom(profTxt , profImg);
                desActiveBottom(addTxt, addImg);
                setFragment(new MyHousesListFrag());
            }
        });
        profBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                activeBottom(profTxt, profImg);
                desActiveBottom(reqTxt , reqImg);
                desActiveBottom(addTxt, addImg);
                setFragment(new ProfileFrag());
            }
        });
        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                activeBottom(addTxt, addImg);
                desActiveBottom(profTxt, profImg);
                desActiveBottom(reqTxt , reqImg);
                setFragment(new Add_Home_Frag());
            }
        });
    }


    private void init(){
        addBtn = findViewById(R.id.addProductBtn);
        addImg = findViewById(R.id.addProdImg);
        reqBtn = findViewById(R.id.reqBtn);
        profBtn = findViewById(R.id.profBtn);
        reqImg = findViewById(R.id.reqImg);
        profImg = findViewById(R.id.profImg);
        addTxt = findViewById(R.id.addProdTxt);
        reqTxt = findViewById(R.id.reqTxt);
        profTxt = findViewById(R.id.profTxt);
    }

    private void activeBottom(TextView txt , ImageView img){

        txt.setTypeface(null, Typeface.BOLD);
        img.setColorFilter(getColor(R.color.mainColor));
        txt.setTextColor(getColor(R.color.black));
    }


    private void desActiveBottom(TextView txt , ImageView img){
        txt.setTypeface( null, Typeface.NORMAL);
        txt.setTextColor(getColor(R.color.gray));
        img.setColorFilter(getColor(R.color.gray));

    }

    private void setFragment(Fragment fragment){

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frameContainer ,  fragment);
        transaction.commit();
    }

}