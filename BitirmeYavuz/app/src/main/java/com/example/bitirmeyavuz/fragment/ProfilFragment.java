package com.example.bitirmeyavuz.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.bitirmeyavuz.R;
import com.example.bitirmeyavuz.databinding.FragmentProfilBinding;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;

public class ProfilFragment extends Fragment {
    private FragmentProfilBinding tasarim;
    private FirebaseAuth mAuth;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        tasarim = FragmentProfilBinding.inflate(inflater, container, false);

        mAuth = FirebaseAuth.getInstance();

        tasarim.buttonCikisYap.setOnClickListener(view -> {
            mAuth.signOut();
            Navigation.findNavController(view).navigate(R.id.profildenLogineGecis);
        });




        return tasarim.getRoot();
    }
}