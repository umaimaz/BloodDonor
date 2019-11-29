package com.example.blooddonor;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;


import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;


public class MainActivity extends AppCompatActivity {
   // Toolbar toolBar1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       // toolBar1  = findViewById(R.id.toolbar1);

       // toolBar1.setTitle(getResources().getString(R.string.blood_connect));
       // setSupportActionBar(toolBar1);
        //...............bottomNavigation...............
        BottomNavigationView bottomNavView = findViewById(R.id.bottom_navigation);
        bottomNavView.setOnNavigationItemSelectedListener(navListener);
        //...............showing Find Donor Fragment On Main Screen....................
        getSupportFragmentManager().beginTransaction().replace(R.id.container_fragment,new FindDonor_Fragment()).commit();

      }//onCreate end
    //...............
    public void logout(View v){
        FirebaseAuth.getInstance().signOut();
        startActivity(new Intent(getApplicationContext(),login.class));
        finish();
    }

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
