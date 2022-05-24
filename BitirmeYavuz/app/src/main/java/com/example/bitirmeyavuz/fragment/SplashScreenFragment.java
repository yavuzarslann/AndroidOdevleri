package com.example.bitirmeyavuz.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.bitirmeyavuz.R;
import com.example.bitirmeyavuz.databinding.FragmentSplashScreenBinding;

public class SplashScreenFragment extends Fragment {
    private FragmentSplashScreenBinding tasarim;
    private Handler h = new Handler();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        tasarim = FragmentSplashScreenBinding.inflate(inflater, container, false);

        h.postDelayed(new Runnable() {
            @Override
            public void run() {
                Navigation.findNavController(requireView()).navigate(R.id.splashdenAnaGecis);
            }
        }, 4000);

        tasarim.splashLottie.setSpeed(2);


        return tasarim.getRoot();
    }
}