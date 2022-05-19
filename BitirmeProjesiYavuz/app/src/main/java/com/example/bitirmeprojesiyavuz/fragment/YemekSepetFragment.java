package com.example.bitirmeprojesiyavuz.fragment;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.bitirmeprojesiyavuz.R;
import com.example.bitirmeprojesiyavuz.adapter.SepetAdapter;
import com.example.bitirmeprojesiyavuz.databinding.FragmentYemekSepetBinding;
import com.example.bitirmeprojesiyavuz.entity.SepetYemekler;
import com.example.bitirmeprojesiyavuz.entity.Yemekler;
import com.example.bitirmeprojesiyavuz.viewmodel.AnasayfaFragmentViewModel;
import com.example.bitirmeprojesiyavuz.viewmodel.YemekSepetFragmentViewModel;

import java.util.ArrayList;

public class YemekSepetFragment extends Fragment {
        private FragmentYemekSepetBinding tasarim;
        private YemekSepetFragmentViewModel viewModel;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        tasarim = DataBindingUtil.inflate(inflater,R.layout.fragment_yemek_sepet, container, false);

        buttonSepettekiYemekleriAlTikla("yavuz");

        viewModel.sepetYemeklerListesi.observe(getViewLifecycleOwner(),liste ->{
            SepetAdapter sepetAdapter = new SepetAdapter(requireContext(),liste);
            tasarim.setSepetAdapter(sepetAdapter);
        });

        return tasarim.getRoot();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel = new ViewModelProvider(this).get(YemekSepetFragmentViewModel.class);
    }

    public void buttonSepettekiYemekleriAlTikla(String kullanici_adi){
        viewModel.sepettekiYemekleriYukle(kullanici_adi);
    }
}