package com.example.creley;

import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

public class HomeActivity extends AppCompatActivity {

    protected LinearLayout addBtn, homeBtn, reqBtn, profBtn ;
    protected ImageView addImg, homeImg, reqImg, profImg  ;
    protected TextView addTxt, homeTxt, reqTxt, profTxt ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        init();
        // set default as home
        activeBottom(homeTxt, homeImg);
        desActiveBottom(reqTxt, reqImg);
        desActiveBottom(profTxt , profImg);
        desActiveBottom(addTxt, addImg);
        setFragment(new HomeFrag());
        homeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                activeBottom(homeTxt, homeImg);
                desActiveBottom(reqTxt, reqImg);
                desActiveBottom(profTxt , profImg);
                desActiveBottom(addTxt, addImg);
                setFragment(new HomeFrag());
            }
        });
        reqBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                activeBottom(reqTxt, reqImg);
                desActiveBottom(homeTxt , homeImg);
                desActiveBottom(profTxt , profImg);
                desActiveBottom(addTxt, addImg);
                setFragment(new RequestFrag());
            }
        });
        profBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                activeBottom(profTxt, profImg);
                desActiveBottom(homeTxt , homeImg);
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
                desActiveBottom(homeTxt , homeImg);
                desActiveBottom(reqTxt , reqImg);
                setFragment(new AddFrag());
            }
        });


    }

    private void init(){
        addBtn = findViewById(R.id.addProductBtn);
        homeBtn = findViewById(R.id.prodListBtn);
        addImg = findViewById(R.id.addProdImg);
        reqBtn = findViewById(R.id.reqBtn);
        profBtn = findViewById(R.id.profBtn);
        homeImg = findViewById(R.id.prodListImg);
        reqImg = findViewById(R.id.reqImg);
        profImg = findViewById(R.id.profImg);
        addTxt = findViewById(R.id.addProdTxt);
        homeTxt = findViewById(R.id.prodListTxt);
        reqTxt = findViewById(R.id.reqTxt);
        profTxt = findViewById(R.id.profTxt);
    }

    private void setFragment(Fragment fragment){

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frameContainer ,  fragment);
        transaction.commit();
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
}