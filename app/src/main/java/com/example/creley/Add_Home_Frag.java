package com.example.creley;

import static android.app.Activity.RESULT_OK;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ImageView;
import android.widget.Toast;

public class Add_Home_Frag extends Fragment {

    private static final int PICK_IMAGE_REQUEST = 100;
    protected ImageView homeImg ;

    protected String[] dairaTable = {"Sidi Bel Abbès", "Aïn el Berd", "Ben Badis", "Marhoum", "Merine", "Mostefa Ben Brahim", "Moulay Slissen", "Ras El Ma", "Sfisef", "Sidi Ali Benyoub", "Sidi Ali Boussidi", "Sidi Lahcene", "Telagh", "Tenira", "Tessala"};
    protected String[][] baladiasTable = {{"Sidi Bel Abbès"}, {"Aïn el Berd", "Sidi Brahim", "Makedra", "Sidi Hamadouche"}, {"Ben Badis", "Badredine El Mokrani", "Hassi Zahana", "Chettouane Belaila"}, {"Marhoum", "Sidi Chaib", "Bir El Hammam"}, {"Merine", "Tafissour", "Oued Taourira", "Taoudmout"}, {"Mostefa Ben Brahim", "Tilmouni", "Zerouala", "Belarbi"}, {"Moulay Slissen", "El Haçaiba", "Aïn Tindamine"}, {"Ras El Ma", "Oued Sebaa", "Redjem Demouche"}, {"Sfisef", "M'Cid", "Aïn Adden", "Boudjebha El Bordj"}, {"Sidi Ali Benyoub", "Boukhanafis", "Tabia"}, {"Sidi Ali Boussidi", "Aïn Kada", "Lamtar", "Sidi Daho des Zairs"}, {"Sidi Lahcene", "Amarnas", "Sidi Khaled", "Sidi Yacoub"}, {"Telagh", "Mezaourou", "Dhaya", "Teghalimet"}, {"Tenira", "Oued Sefioun", "Benachiba Chelia", "Hassi Dahou"}, {"Tessala", "Aïn Thrid", "Sehala Thaoura"}};


    protected String[] estateTypeTable = {"Appartement", "Bungalow", "Chalet", "Complexe touristique ", "Local", "Villa"};

    protected String[] periodTypeTable = {"Par mois" , "Par jour" , "Par houre"} ;
    protected ArrayAdapter<String> dairasAdapter, baladiyasAdapter, estateTypeAdapter , periodTypeAdapter;
    protected AutoCompleteTextView dairaList, estateTypeList, baladiaList , periodTypeList;
    protected String selectedDaira, selectedBaladia, selectedEstateType , selectedPeriodType;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_add__home_, container, false);
        init(view);

        // setting Dairas logic
        dairasAdapter = new ArrayAdapter<String>(getContext(), R.layout.drop_menu_item, dairaTable);
        dairaList.setAdapter(dairasAdapter);
        dairaList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                selectedDaira = adapterView.getItemAtPosition(i).toString();
                Toast.makeText(getContext(), selectedDaira, Toast.LENGTH_SHORT).show();
                updateBaladia(baladiasTable[i]);
            }
        });

        // setting baladia logic
        baladiaList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if (selectedDaira == null) {
                    Toast.makeText(getContext(), "Ajouter une Daira ", Toast.LENGTH_SHORT).show();
                } else {
                    selectedBaladia = adapterView.getItemAtPosition(i).toString();
                    Toast.makeText(getContext(), selectedDaira, Toast.LENGTH_SHORT).show();
                }
            }
        });

        // setting estate type logic
        estateTypeAdapter = new ArrayAdapter<String>(getContext(), R.layout.drop_menu_item, estateTypeTable);
        estateTypeList.setAdapter(estateTypeAdapter);
        estateTypeList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                selectedEstateType = adapterView.getItemAtPosition(i).toString();
                Toast.makeText(getContext(), selectedEstateType, Toast.LENGTH_SHORT).show();

            }
        });

        //setting  period type logic
        periodTypeAdapter = new ArrayAdapter<String>(getContext(), R.layout.drop_menu_item, periodTypeTable);
        periodTypeList.setAdapter(periodTypeAdapter);
        periodTypeList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                selectedPeriodType = adapterView.getItemAtPosition(i).toString();
                Toast.makeText(getContext(), selectedPeriodType, Toast.LENGTH_SHORT).show();
            }
        });

        homeImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openImagePicker();
            }
        });


        return view;

    }


    protected void updateBaladia(String[] newBaladias) {
        baladiyasAdapter = new ArrayAdapter<String>(getContext(), R.layout.drop_menu_item, newBaladias);
        baladiaList.setAdapter(baladiyasAdapter);
        baladiaList.setText("Commune", false);
    }

    protected void init(View v) {
        selectedBaladia = null;
        selectedDaira = null;
        selectedEstateType = null;
        selectedPeriodType = null;
        dairaList = v.findViewById(R.id.dairaList);
        baladiaList = v.findViewById(R.id.baladiaList);
        estateTypeList = v.findViewById(R.id.estateTypeList);
        periodTypeList = v.findViewById(R.id.periodTypeList);
        homeImg = v.findViewById(R.id.homeImg);
    }

    private void openImagePicker() {
        Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(intent, PICK_IMAGE_REQUEST);
    }

    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if ((requestCode == PICK_IMAGE_REQUEST) && (resultCode == RESULT_OK) && (data != null)) {
            Uri selectedImageUri = data.getData();
            homeImg.setImageURI(selectedImageUri);


        }
    }
}