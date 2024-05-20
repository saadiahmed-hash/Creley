package com.example.creley;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.FirebaseAuth;

public class ChangePassActivity extends AppCompatActivity {


    protected TextInputEditText emailEdit ;
    protected  FirebaseAuth mAuth  ;
    protected Button changePassBtn ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_pass);
        init();
        changePassBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (emailEdit.getText().toString().equals("")){
                    emailEdit.setError("Veuillez saisir toutes les informations");
                } else {
                    changePassBtn.setEnabled(false);
                    changePassBtn.setText("S'il vous plaît, attendez...");
                    changePassBtn.setClickable(false);
                    changePass();
                }
            }
        });

    }
    private void init(){
        emailEdit = findViewById(R.id.emailEdit);
        changePassBtn = findViewById(R.id.changePassBtn);
        mAuth = FirebaseAuth.getInstance() ;
    }

    private  void changePass(){
        mAuth.sendPasswordResetEmail(emailEdit.getText().toString())
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()){
                            Toast.makeText(ChangePassActivity.this, "nous vous avons envoyé un lien, veuillez vérifier votre email", Toast.LENGTH_SHORT).show();
                            finish();
                        } else {
                            Toast.makeText(ChangePassActivity.this, task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                        }
                        changePassBtn.setEnabled(true);
                        changePassBtn.setClickable(true);
                        changePassBtn.setText("Envoyer");
                        emailEdit.setText("");
                    }
                });
    }
}