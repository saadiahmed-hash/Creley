package com.example.creley;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    private FirebaseAuth mAuth ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // splash timing

        init();
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                    if(mAuth.getCurrentUser()!=null){
                        startActivity(new Intent(MainActivity.this,ChoiceActivity.class));
                    } else {
                        startActivity(new Intent(MainActivity.this,SignupActivity.class));
                    }
                    finish();
                } catch (Exception e){
                }
            }
        });
        thread.start();

    }

    private void init(){
        mAuth = FirebaseAuth.getInstance() ;
    }
}