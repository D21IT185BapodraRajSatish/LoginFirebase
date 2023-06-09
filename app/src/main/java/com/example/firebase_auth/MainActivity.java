package com.example.firebase_auth;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {

    Button btn;
    FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = findViewById(R.id.btnLogout);
        mAuth = FirebaseAuth.getInstance();

        btn.setOnClickListener(view -> {
            mAuth.signOut();
            startActivity(new Intent(MainActivity.this,LoginActivity.class));
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        FirebaseUser user = mAuth.getCurrentUser();
        if(user == null){
                startActivity(new Intent(MainActivity.this,LoginActivity.class));
        }
    }
}