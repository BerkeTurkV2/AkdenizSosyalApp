package com.berke.AkdenizSosyal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class RegisterPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_page);
    }
    public void btnRegister(View view){
        Intent intent = new Intent(RegisterPage.this, LoginPage.class);
        startActivity(intent);
    }
    public void btnLogin(View view){
        Intent intent = new Intent(RegisterPage.this, LoginPage.class);
        startActivity(intent);
    }
}