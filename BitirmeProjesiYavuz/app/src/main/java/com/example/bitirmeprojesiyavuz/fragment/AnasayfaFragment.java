package com.example.bitirmeprojesiyavuz.fragment;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.bitirmeprojesiyavuz.R;
import com.example.bitirmeprojesiyavuz.adapter.KategorilerAdapter;
import com.example.bitirmeprojesiyavuz.adapter.YemeklerAdapter;
import com.example.bitirmeprojesiyavuz.databinding.FragmentAnasayfaBinding;
import com.example.bitirmeprojesiyavuz.entity.Kategoriler;
import com.example.bitirmeprojesiyavuz.entity.Yemekler;
import com.example.bitirmeprojesiyavuz.viewmodel.AnasayfaFragmentViewModel;

import java.util.ArrayList;

public class AnasayfaFragment extends Fragment {
        private FragmentAnasayfaBinding tasarim;
        private AnasayfaFragmentViewModel viewModel;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        tasarim = DataBindingUtil.inflate(inflater,R.layout.fragment_anasayfa, container, false);
        tasarim.setAnasayfaFragment(this);


        viewModel.yemeklerListesi.observe(getViewLifecycleOwner(),liste ->{
            YemeklerAdapter yemeklerAdapter = new YemeklerAdapter(requireContext(),liste);
            tasarim.setYemeklerAdapter(yemeklerAdapter);
        });



        ArrayList<Kategoriler> kategorilerListesi = new ArrayList<>();
        Kategoriler k1 = new Kategoriler(1,"İçecekler","fanta");
        Kategoriler k2 = new Kategoriler(2,"Izagara Yemekler","izgaratavuk");
        Kategoriler k3 = new Kategoriler(3,"Tatlılar","sutlac");
        Kategoriler k4 = new Kategoriler(4,"Ayranlar","ayran");
        kategorilerListesi.add(k1);
        kategorilerListesi.add(k2);
        kategorilerListesi.add(k3);
        kategorilerListesi.add(k4);

        KategorilerAdapter kategorilerAdapter = new KategorilerAdapter(requireContext(),kategorilerListesi);
        tasarim.setKategorilerAdapter(kategorilerAdapter);


        return tasarim.getRoot();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel = new ViewModelProvider(this).get(AnasayfaFragmentViewModel.class);
    }
}