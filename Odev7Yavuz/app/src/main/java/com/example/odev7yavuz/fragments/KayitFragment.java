package com.example.odev7yavuz.fragments;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.odev7yavuz.R;
import com.example.odev7yavuz.databinding.FragmentKayitBinding;
import com.example.odev7yavuz.viewmodel.KayitFragmentViewModel;
import com.example.odev7yavuz.viewmodel.KayitVMF;

public class KayitFragment extends Fragment {
    private FragmentKayitBinding tasarim;
    private KayitFragmentViewModel viewModel;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        tasarim = DataBindingUtil.inflate(inflater, R.layout.fragment_kayit, container, false);
        tasarim.setKayitFragment(this);
        tasarim.setKayitToolbarBaslik("Yapılacak İş Kayıt");

        return tasarim.getRoot();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel = new ViewModelProvider(this,
                new KayitVMF(requireActivity().getApplication())).get(KayitFragmentViewModel.class);
    }

    public void buttonKayitTikla(String is_adi){
        viewModel.kayit(is_adi);
    }
}