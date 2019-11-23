package com.example.blooddonor;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView bottomNavView = findViewById(R.id.bottom_navigation);
        bottomNavView.setOnNavigationItemSelectedListener(navListener);
        getSupportFragmentManager().beginTransaction().replace(R.id.container_fragment,new FindDonor_Fragment()).commit();
    }
    //heeeyyyyyyyy xDDDDDDDDDDDDDD
        private BottomNavigationView.OnNavigationItemSelectedListener navListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                Fragment selectFragment = null;

                switch(menuItem.getItemId()){
                    case R.id.find_donor:
                        selectFragment = new FindDonor_Fragment();
                        break;

                    case R.id.request:
                        selectFragment = new Request_Fragment();
                        break;

                    case R.id.request_for_blood:
                        selectFragment = new RequestForBlood_Fragment();
                        break;

                    case R.id.history:
                        selectFragment = new History_Fragment();
                        break;

                    case R.id.profile:
                        selectFragment = new Profile_Fragment();
                        break;

                }
                getSupportFragmentManager().beginTransaction().replace(R.id.container_fragment,selectFragment).commit();
                return true;
            }
        };



}
