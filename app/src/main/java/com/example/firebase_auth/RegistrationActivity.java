package com.example.firebase_auth;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class RegistrationActivity extends AppCompatActivity {


    EditText editTextEmail,editTextPassword;
    Button btnReg,btnLoginHere;

    FirebaseAuth firebaseAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        editTextEmail = findViewById(R.id.regemail);
        editTextPassword = findViewById(R.id.regpassword);
        btnReg = findViewById(R.id.btnRegister);


        btnLoginHere = findViewById(R.id.btnLoginHere);
        firebaseAuth = FirebaseAuth.getInstance();
        btnReg.setOnClickListener(view -> {
            createUser();
        });

        btnLoginHere.setOnClickListener(view -> {
            startActivity(new Intent(RegistrationActivity.this,LoginActivity.class));
        });

    }

    private void createUser() {
        String email = editTextEmail.getText().toString();
        String password =  editTextPassword.getText().toString();

        firebaseAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    Toast.makeText(RegistrationActivity.this, "User Register done", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(RegistrationActivity.this,LoginActivity.class));
                }else{
                    Toast.makeText(RegistrationActivity.this, "User Register Error", Toast.LENGTH_SHORT).show();
                }

            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();

       


    }
    
}