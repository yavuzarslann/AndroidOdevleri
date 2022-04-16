package com.example.odev4yavuz;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.odev4yavuz.databinding.FragmentSayfaYBinding;

public class SayfaYFragment extends Fragment {
    private FragmentSayfaYBinding tasarim;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        tasarim = FragmentSayfaYBinding.inflate(inflater, container, false);

        tasarim.buttonAnasayfaGit.setOnClickListener(view -> {
            Navigation.findNavController(view).navigate(R.id.anasayfayaDonus);
        });

        return tasarim.getRoot();
    }
}