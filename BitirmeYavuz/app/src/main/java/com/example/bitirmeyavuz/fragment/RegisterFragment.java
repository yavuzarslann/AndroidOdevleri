package com.example.bitirmeyavuz.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.bitirmeyavuz.R;
import com.example.bitirmeyavuz.databinding.FragmentRegisterBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class RegisterFragment extends Fragment {
    private FragmentRegisterBinding tasarim;
    private FirebaseAuth mAuth;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        tasarim = FragmentRegisterBinding.inflate(inflater, container, false);

        mAuth = FirebaseAuth.getInstance();

        tasarim.buttonKayitOl.setOnClickListener(view -> {
            createUser();
        });

        tasarim.textViewGirisYap.setOnClickListener(view -> {
            Navigation.findNavController(view).navigate(R.id.kayitttanLogineGecis);
        });


        return tasarim.getRoot();
    }

    private void createUser() {
        String email = tasarim.editTextKayitMail.getText().toString();
        String password = tasarim.editTextKayitSifre.getText().toString();

        if (TextUtils.isEmpty(email)) {
            tasarim.editTextKayitMail.setError("Email kısmı boş olamaz!");
            tasarim.editTextKayitMail.requestFocus();
        } else if (TextUtils.isEmpty(password)) {
            tasarim.editTextKayitSifre.setError("Şifre kısmı boş olamaz!");
            tasarim.editTextKayitSifre.requestFocus();
        } else {
            mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()) {
                        Toast.makeText(getContext(), "Kullanıcı kaydı başarıyla yapıldı.", Toast.LENGTH_SHORT).show();
                        Navigation.findNavController(requireView()).navigate(R.id.kayitttanLogineGecis);
                    } else {
                        Toast.makeText(getContext(), "Kayıt hatası: " + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }
}