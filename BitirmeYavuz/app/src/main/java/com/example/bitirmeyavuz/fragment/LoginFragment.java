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
import com.example.bitirmeyavuz.databinding.FragmentLoginBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginFragment extends Fragment {
    private FragmentLoginBinding tasarim;
    private FirebaseAuth mAuth;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        tasarim = FragmentLoginBinding.inflate(inflater, container, false);

        mAuth = FirebaseAuth.getInstance();

        tasarim.buttonGirisYap.setOnClickListener(view -> {
            loginUser();
        });

        tasarim.textViewKayitOl.setOnClickListener(view -> {
            Navigation.findNavController(view).navigate(R.id.logindenKayitaGecis);
        });

        return tasarim.getRoot();
    }

    //login
    public void loginUser() {
        String email = tasarim.editTextGirisMail.getText().toString();
        String password = tasarim.editTextGirisSifre.getText().toString();

        if (TextUtils.isEmpty(email)) {
            tasarim.editTextGirisMail.setError("Email kısmı boş olamaz!");
            tasarim.editTextGirisMail.requestFocus();
        } else if (TextUtils.isEmpty(password)) {
            tasarim.editTextGirisSifre.setError("Şifre kısmı boş olamaz!");
            tasarim.editTextGirisSifre.requestFocus();
        } else {
            mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()) {
                        Toast.makeText(getContext(), "Başarıyla giriş yapıldı.", Toast.LENGTH_SHORT).show();
                        Navigation.findNavController(requireView()).navigate(R.id.logindenAnaGecis);
                    } else {
                        Toast.makeText(getContext(), "Giriş hatası: " + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }
}