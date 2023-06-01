package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        TextView username = findViewById(R.id.username);
        TextView password = findViewById(R.id.password);
        TextView passwordConfirm = findViewById(R.id.passwordconfirm);
        Button loginBtn = findViewById(R.id.logninbtn);

    }
}