package com.example.conversor;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    ItmLong longItm = new ItmLong();
    ItmTemp tempItm = new ItmTemp();
    ItmPeso pesoItm = new ItmPeso();
    ItmVolum volumItm = new ItmVolum();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        BottomNavigationView navigation = findViewById(R.id.bottom_navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedItem);

        loadFragment(longItm);
    }

    private final BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedItem = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()){
                case R.id.longitudItem:
                    loadFragment(longItm);
                    return true;
                case R.id.pesoItem:
                    loadFragment(pesoItm);
                    return true;
                case R.id.volumenItem:
                    loadFragment(volumItm);
                    return true;
                case R.id.temperaturaItem:
                    loadFragment(tempItm);
                    return true;
            }
            return false;
        }
    };

    public void loadFragment(Fragment fragment){
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_container, fragment);
        transaction.commit();
    }
}