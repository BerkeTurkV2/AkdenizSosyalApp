package com.berke.AkdenizSosyal;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class AppPage extends AppCompatActivity {

    private BottomNavigationView appBottomBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app_page);

        appBottomBar = (BottomNavigationView) findViewById(R.id.app_page_bottombar);

        appBottomBar.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.bottombar_menu_event:
                        Toast.makeText(getApplicationContext(),"Etkinlikler",Toast.LENGTH_SHORT).show();
                        return true;
                    case R.id.bottombar_menu_club:
                        Toast.makeText(getApplicationContext(),"Kulüpler",Toast.LENGTH_SHORT).show();
                        return true;
                    case R.id.bottombar_menu_place:
                        Toast.makeText(getApplicationContext(),"Mekanlar",Toast.LENGTH_SHORT).show();
                        return true;
                    case R.id.bottombar_menu_chat:
                        Toast.makeText(getApplicationContext(),"Kampüs Chat",Toast.LENGTH_SHORT).show();
                        return true;
                    case R.id.bottombar_menu_profile:
                        Toast.makeText(getApplicationContext(),"Profil",Toast.LENGTH_SHORT).show();
                        return true;
                    default:
                        return false;
                }
            }
        });
    }
}