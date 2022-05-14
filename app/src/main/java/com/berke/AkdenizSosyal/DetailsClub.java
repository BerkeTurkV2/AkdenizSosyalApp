package com.berke.AkdenizSosyal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailsClub extends AppCompatActivity {

    private TextView txtClubNameDesc, txtClubType, txtOpeningDate, txtAdvisor, txtClubDesc;
    private ImageView imgClubLogo;

    private Intent getInt;
    private String ClubNameDesc,ClubType,ClubOpeningDate,ClubAdvisor,ClubDesc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_club);

        txtClubNameDesc = (TextView) findViewById(R.id.txtClubNameDesc);
        txtClubType = (TextView) findViewById(R.id.txtClubType);
        txtOpeningDate = (TextView) findViewById(R.id.txtOpeningDate);
        txtAdvisor = (TextView) findViewById(R.id.txtAdvisor);
        txtClubDesc = (TextView) findViewById(R.id.txtClubDesc);

        getInt = getIntent();
        ClubNameDesc = getInt.getStringExtra("ClubName");
        ClubType = getInt.getStringExtra("ClubType");
        ClubOpeningDate = getInt.getStringExtra("ClubOpeningDate");
        ClubAdvisor = getInt.getStringExtra("ClubAdvisor");
        ClubDesc = getInt.getStringExtra("ClubDesc");

        // if(!TextUtils.isEmpty(ClubNameDesc) && !TextUtils.isEmpty(ClubType) && !TextUtils.isEmpty(ClubOpeningDate) && !TextUtils.isEmpty(ClubAdvisor) && !TextUtils.isEmpty(ClubDesc)){
            txtClubNameDesc.setText(ClubNameDesc);
            txtClubType.setText(ClubType);
            txtOpeningDate.setText(ClubOpeningDate);
            txtAdvisor.setText(ClubAdvisor);
            txtClubDesc.setText(ClubDesc);
        // }
    }
}