package com.example.odev4yavuz;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.odev4yavuz.databinding.FragmentSayfaBBinding;

public class SayfaBFragment extends Fragment {
    private FragmentSayfaBBinding tasarim;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        tasarim = FragmentSayfaBBinding.inflate(inflater, container, false);

        tasarim.buttonYGit2.setOnClickListener(view -> {
            Navigation.findNavController(view).navigate(R.id.sayfaYGecis2);
        });

        return tasarim.getRoot();
    }
}