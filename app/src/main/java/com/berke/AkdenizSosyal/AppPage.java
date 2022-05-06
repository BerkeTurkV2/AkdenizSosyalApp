package com.berke.AkdenizSosyal;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class AppPage extends AppCompatActivity {

    private BottomNavigationView appBottomBar;
    private EventPage eventFragment;
    private ClubPage clubFragment;
    private PlacePage placeFragment;
    private ChatPage chatFragment;
    private ProfilePage profileFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app_page);

        appBottomBar = (BottomNavigationView) findViewById(R.id.app_page_bottombar);
        eventFragment = new EventPage();
        clubFragment = new ClubPage();
        placeFragment = new PlacePage();
        chatFragment = new ChatPage();
        profileFragment = new ProfilePage();

        setFragment(eventFragment);

        appBottomBar.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.bottombar_menu_event:
                        setFragment(eventFragment);
                        return true;
                    case R.id.bottombar_menu_club:
                        setFragment(clubFragment);
                        return true;
                    case R.id.bottombar_menu_place:
                        setFragment(placeFragment);
                        return true;
                    case R.id.bottombar_menu_chat:
                        setFragment(chatFragment);
                        return true;
                    case R.id.bottombar_menu_profile:
                        setFragment(profileFragment);
                        return true;
                    default:
                        return false;
                }
            }
        });
    }

    private void setFragment(Fragment fragment){
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.app_page_framelayout, fragment);
        transaction.commit();
    }
}