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


public class SignupActivity extends AppCompatActivity {


    protected Button signupBtn ;
    protected TextView signupTxt ;
    protected TextInputEditText nomEdit , prenomEdit  , phoneEdit , emailEdit , passEdit ;
    private FirebaseAuth mAuth ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        init();
        signupBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (testEdit(nomEdit) && testEdit(prenomEdit) &&testEdit(phoneEdit) && testEdit(emailEdit) && testEdit(passEdit)){
                    signupBtn.setClickable(false);
                    signupBtn.setEnabled(false);
                    signupBtn.setText("S'il vous plaît, attendez...");
                    createAcc();
                }
            }
        });
        signupTxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SignupActivity.this ,LoginActivity.class));
            }
        });
    }

    protected  void init(){
        signupBtn = findViewById(R.id.signupBtn) ;
        signupTxt = findViewById(R.id.signupTxt) ;
        nomEdit = findViewById(R.id.nomEdit) ;
        prenomEdit = findViewById(R.id.prenomEdit) ;
        phoneEdit = findViewById(R.id.phoneEdit) ;
        emailEdit = findViewById(R.id.emailEdit) ;
        passEdit = findViewById(R.id.passEdit) ;
        mAuth = FirebaseAuth.getInstance() ;
    }

    private boolean testEdit(TextInputEditText edit){
        if ( edit.getText().toString().equals("")){
            edit.setError("Veuillez saisir toutes les informations");
            return false ;
        }else{
            return true ;
        }
    }
    private void createAcc(){
        mAuth.createUserWithEmailAndPassword(emailEdit.getText().toString() , passEdit.getText().toString())
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(SignupActivity.this, "Bienvenu " + prenomEdit.getText().toString(), Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(SignupActivity.this ,ChoiceActivity.class ));
                            finish();
                        } else {
                            Toast.makeText(SignupActivity.this, task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                        }
                        signupBtn.setClickable(true);
                        signupBtn.setEnabled(true);
                        signupBtn.setText("Crée un compte");
                    }
                });
    }
}