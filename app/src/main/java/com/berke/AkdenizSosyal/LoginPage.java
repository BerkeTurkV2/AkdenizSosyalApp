package com.berke.AkdenizSosyal;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LoginPage extends AppCompatActivity {

    private EditText editTxtEmail, editTxtPassword;
    private String txtEmail, txtPassword;
    private FirebaseAuth mAuth;
    private FirebaseUser mUser;

    private void init(){
        editTxtEmail = (EditText) findViewById(R.id.editTxtLoginEmail);
        editTxtPassword = (EditText) findViewById(R.id.editTxtLoginPassword);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);
        init();

        mAuth = FirebaseAuth.getInstance();

    }
    public void btnRegister(View view){
        Intent intent = new Intent(LoginPage.this, RegisterPage.class);
        startActivity(intent);
    }

    public void btnLogin(View view){
        txtEmail = editTxtEmail.getText().toString();
        txtPassword = editTxtPassword.getText().toString();

        if(!TextUtils.isEmpty(txtEmail) && !TextUtils.isEmpty(txtPassword)){
            mAuth.signInWithEmailAndPassword(txtEmail,txtPassword).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if(task.isSuccessful()){
                        mUser = mAuth.getCurrentUser();
                        Toast.makeText(LoginPage.this,"Giriş İşlemi Başarılı",Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(LoginPage.this, AppPage.class);
                        startActivity(intent);
                    }else
                        Toast.makeText(LoginPage.this,task.getException().getMessage(),Toast.LENGTH_SHORT).show();
                }
            });
        }else
            Toast.makeText(this,"Email ve Şifre Boş Olamaz.", Toast.LENGTH_SHORT).show();
    }
}