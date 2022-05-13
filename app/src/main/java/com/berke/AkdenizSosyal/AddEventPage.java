package com.berke.AkdenizSosyal;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;

public class AddEventPage extends AppCompatActivity {

    private EditText editTxtEventTitle, editTxtEventDate, editTxtEventPlace, editTxtEventQuota, editTextEventDescription;
    private Button btnEventAddEvent;
    private ImageView imgEventAddImage;
    private String eventTitle, eventDate, eventPlace;

    ActivityResultLauncher<Intent> activityResultLauncher;

    private void init() {
        editTxtEventTitle = (EditText) findViewById(R.id.editTxtEventTitle);
        editTxtEventDate = (EditText) findViewById(R.id.editTxtEventDate);
        editTxtEventPlace = (EditText) findViewById(R.id.editTxtEventPlace);
        editTxtEventQuota = (EditText) findViewById(R.id.editTxtEventQuota);
        editTextEventDescription = (EditText) findViewById(R.id.editTxtEventDescription);
        imgEventAddImage = (ImageView) findViewById(R.id.imgEventAddImage);
        btnEventAddEvent = (Button) findViewById(R.id.btnEventAddEvent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_event_page);
        init();

        ActivityResultLauncher<String> selectImage = registerForActivityResult(new ActivityResultContracts.GetContent(), new ActivityResultCallback<Uri>() {
            @Override
            public void onActivityResult(Uri result) {
                imgEventAddImage.setImageURI(result);
            }
        });

        imgEventAddImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectImage.launch("Image/*");
            }
        });
    }

    public void btnEventAddEvent(View view) {
        eventTitle = editTxtEventTitle.getText().toString();
        eventDate = editTxtEventDate.getText().toString();
        eventPlace = editTxtEventPlace.getText().toString();

        if(!TextUtils.isEmpty(eventTitle)){
            if(!TextUtils.isEmpty(eventDate)){
                if(!TextUtils.isEmpty(eventPlace)){

                    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();


                }else
                    showToast("Yer Bilgisi Boş Olamaz.");
            }else
                showToast("Tarih Bilgisi Boş Olamaz.");
        }else
            showToast("Başlık Bilgisi Boş Olamaz.");
    }
    private void showToast(String message){
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }
}