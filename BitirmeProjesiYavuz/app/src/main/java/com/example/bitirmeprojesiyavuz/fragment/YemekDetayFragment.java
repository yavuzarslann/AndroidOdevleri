package com.example.bitirmeprojesiyavuz.fragment;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.example.bitirmeprojesiyavuz.R;
import com.example.bitirmeprojesiyavuz.databinding.FragmentYemekDetayBinding;
import com.example.bitirmeprojesiyavuz.entity.Yemekler;
import com.example.bitirmeprojesiyavuz.viewmodel.YemekDetayFragmentViewModel;
import com.squareup.picasso.Picasso;

public class YemekDetayFragment extends Fragment {
        private FragmentYemekDetayBinding tasarim;
        private YemekDetayFragmentViewModel viewModel;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        tasarim = DataBindingUtil.inflate(inflater,R.layout.fragment_yemek_detay, container, false);
        tasarim.setYemekDetayFragment(this);


        YemekDetayFragmentArgs bundle = YemekDetayFragmentArgs.fromBundle(getArguments());
        Yemekler gelenYemek = bundle.getYemek();
        tasarim.setYemekNesnesi(gelenYemek);

        resimGoster(gelenYemek.getYemek_resim_adi());

        tasarim.buttonSepeteEkle.setOnClickListener(view -> {

        });

        return tasarim.getRoot();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel = new ViewModelProvider(this).get(YemekDetayFragmentViewModel.class);
    }

    public void resimGoster(String yemek_resim_adi){
        String url = "http://kasimadalan.pe.hu/yemekler/resimler/"+yemek_resim_adi;
        Picasso.get().load(url).into(tasarim.imageViewYemek);

    }

    public void buttonSepeteEkleTikla(String yemek_adi, String yemek_resim_adi, int yemek_fiyat, int yemek_siparis_adet, String kullanici_adi){
        viewModel.sepeteYemekleriYukle(yemek_adi,yemek_resim_adi,yemek_fiyat,yemek_siparis_adet,kullanici_adi);
    }
}