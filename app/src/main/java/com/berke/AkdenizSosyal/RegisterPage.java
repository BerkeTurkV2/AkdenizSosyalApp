package com.berke.AkdenizSosyal;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.berke.AkdenizSosyal.Model.User;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;

public class RegisterPage extends AppCompatActivity {

    private User mUser;

    private EditText editTxtUsername, editTxtEmail, editTxtPassword, editTxtPassword2;
    private String txtUsername, txtEmail, txtPassword, txtPassword2;

    private FirebaseAuth mAuth;
    private FirebaseFirestore mFireStore;
    private FirebaseUser mFirebaseUser;


    private void init(){
        editTxtUsername = (EditText) findViewById(R.id.editTxtUsername);
        editTxtEmail = (EditText) findViewById(R.id.editTxtEmail);
        editTxtPassword = (EditText) findViewById(R.id.editTxtPassword);
        editTxtPassword2 = (EditText) findViewById(R.id.editTxtPassword2);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_page);
        init();

        mAuth = FirebaseAuth.getInstance();
        mFireStore = FirebaseFirestore.getInstance();
    }
    public void btnRegister(View view){
        txtUsername = editTxtUsername.getText().toString();
        txtEmail = editTxtEmail.getText().toString();
        txtPassword = editTxtPassword.getText().toString();
        txtPassword2 = editTxtPassword2.getText().toString();

        if(!TextUtils.isEmpty(txtUsername)){
            if(!TextUtils.isEmpty(txtEmail)){
                if (!TextUtils.isEmpty(txtPassword) && !TextUtils.isEmpty(txtPassword2)){
                    if(txtPassword.equals(txtPassword2)){

                        mAuth.createUserWithEmailAndPassword(txtEmail,txtPassword)
                                .addOnCompleteListener(RegisterPage.this, new OnCompleteListener<AuthResult>() {
                                    @Override
                                    public void onComplete(@NonNull Task<AuthResult> task) {
                                        if (task.isSuccessful()){
                                            mFirebaseUser = mAuth.getCurrentUser();

                                            if(mFirebaseUser != null ) {
                                                mUser = new User(txtUsername,txtEmail,txtPassword,mFirebaseUser.getUid());
                                                mFireStore.collection("Users").document(mFirebaseUser.getUid()).set(mUser).addOnCompleteListener(RegisterPage.this, new OnCompleteListener<Void>() {
                                                    @Override
                                                    public void onComplete(@NonNull Task<Void> task) {
                                                        if(task.isSuccessful()){
                                                            Toast.makeText(RegisterPage.this,"Kayıt İşlemi Başarılı",Toast.LENGTH_SHORT).show();
                                                            finish();
                                                            Intent intent = new Intent(RegisterPage.this, LoginPage.class);
                                                            startActivity(intent);
                                                        }else
                                                            Toast.makeText(RegisterPage.this,task.getException().getMessage(),Toast.LENGTH_SHORT).show();
                                                    }
                                                });
                                            }

                                        }
                                        else
                                            Toast.makeText(RegisterPage.this,task.getException().getMessage(),Toast.LENGTH_SHORT).show();
                                    }
                                });

                    }else
                        Toast.makeText(this,"Girilen Şifreler Aynı Olmalı.", Toast.LENGTH_SHORT).show();
                }else
                    Toast.makeText(this,"Şifre Boş Olamaz.", Toast.LENGTH_SHORT).show();
            }else
                Toast.makeText(this,"Email Kısmı Boş Olamaz.", Toast.LENGTH_SHORT).show();
        }else
            Toast.makeText(this,"Kullanıcı Adı Boş Olamaz.", Toast.LENGTH_SHORT).show();

    }
    public void btnLogin(View view){
        Intent intent = new Intent(RegisterPage.this, LoginPage.class);
        startActivity(intent);
    }
}