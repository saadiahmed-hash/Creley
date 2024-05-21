package com.example.creley;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
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
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {

    protected Button  createAccBtn  , loginBtn;
    protected TextView changePassTxt ;

    protected TextInputEditText emailEdit , passEdit ;
    private FirebaseAuth mAuth ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        init();
        createAccBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(LoginActivity.this , SignupActivity.class));
            }
        });
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (testEdit(emailEdit)&& testEdit(passEdit)){
                    loginBtn.setEnabled(false);
                    loginBtn.setClickable(false);
                    loginBtn.setText("S'il vous plaît, attendez...");
                    loginAcc();
                }
            }
        });

        changePassTxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginActivity.this , ChangePassActivity.class));
            }
        });
    }

    private boolean testEdit(TextInputEditText edit){
        if ( edit.getText().toString().equals("")){
            edit.setError("Veuillez saisir toutes les informations");
            return false ;
        }else{
            return true ;
        }
    }
    protected  void init(){
        createAccBtn = findViewById(R.id.createAccBtn);
        loginBtn = findViewById(R.id.loginBtn);
        changePassTxt = findViewById(R.id.changePassTxt);
        emailEdit = findViewById(R.id.emailEdit);
        passEdit = findViewById(R.id.passEdit);
        mAuth = FirebaseAuth.getInstance() ;
    }

    private void loginAcc(){
        mAuth.signInWithEmailAndPassword(emailEdit.getText().toString() , passEdit.getText().toString())
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){
                            Toast.makeText(LoginActivity.this, "Bienvenu", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(LoginActivity.this , ChoiceActivity.class));
                            finish();
                        } else {
                            Toast.makeText(LoginActivity.this, task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                        }
                        loginBtn.setEnabled(true);
                        loginBtn.setClickable(true);
                        loginBtn.setText("Se connecter");
                        emailEdit.setText("");
                        passEdit.setText("");
                    }
                });
    }

}