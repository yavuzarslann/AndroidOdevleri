package com.example.bitirmeyavuz;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.NavigationUI;

import android.os.Bundle;
import android.view.Menu;

import com.example.bitirmeyavuz.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding tasarim;
    private ActionBarDrawerToggle actionBarDrawerToggle;
    //NavController navController;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        tasarim = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(tasarim.getRoot());


        //navController = Navigation.findNavController(this,R.id.navHostFragment);
        //NavigationUI.setupActionBarWithNavController(this,navController);

        //super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);

    }

}