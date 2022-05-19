package com.example.bitirmeprojesiyavuz;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.NavigationUI;

import android.os.Bundle;

import com.example.bitirmeprojesiyavuz.databinding.ActivityMainBinding;
import com.example.bitirmeprojesiyavuz.databinding.BottomNavBinding;

public class MainActivity extends AppCompatActivity {
        private BottomNavBinding tasarim;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        tasarim = BottomNavBinding.inflate(getLayoutInflater());
        setContentView(tasarim.getRoot());

        NavHostFragment navHostFragment = (NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.navHostFragment);
        NavigationUI.setupWithNavController(tasarim.bottomNav,navHostFragment.getNavController());
    }
}