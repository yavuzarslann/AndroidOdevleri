package com.example.bitirmeyavuz.fragment;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.bitirmeyavuz.R;
import com.example.bitirmeyavuz.databinding.FragmentYemekDetayBinding;
import com.example.bitirmeyavuz.entity.Yemekler;
import com.example.bitirmeyavuz.viewmodel.YemekDetayFragmentViewModel;
import com.squareup.picasso.Picasso;

public class YemekDetayFragment extends Fragment {
    private FragmentYemekDetayBinding tasarim;
    private YemekDetayFragmentViewModel viewModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        tasarim = DataBindingUtil.inflate(inflater, R.layout.fragment_yemek_detay, container, false);
        tasarim.setYemekDetayFragment(this);
        tasarim.setDetayToolbarBaslik("Detay");

        YemekDetayFragmentArgs bundle = YemekDetayFragmentArgs.fromBundle(getArguments());
        Yemekler gelenYemek = bundle.getYemekler();
        tasarim.setYemekNesnesi(gelenYemek);

        String url = "http://kasimadalan.pe.hu/yemekler/resimler/" + gelenYemek.getYemek_resim_adi();
        Picasso.get().load(url).into(tasarim.imageViewDetayResim);

        tasarim.buttonDetayAzalt.setOnClickListener(view -> {
            String a = tasarim.textViewDetayYemekAdet.getText().toString();
            int b = Integer.parseInt(a);
            if (b >= 2)
                b--;
            String adet = String.valueOf(b);
            tasarim.textViewDetayYemekAdet.setText(adet);
            int fiyat = b * gelenYemek.getYemek_fiyat();
            tasarim.textViewDetayYemekFiyat.setText(String.valueOf(fiyat)+" TL");
        });

        tasarim.buttonDetayArttir.setOnClickListener(view -> {
            String a = tasarim.textViewDetayYemekAdet.getText().toString();
            int b = Integer.parseInt(a);
            if (b >= 1)
                b++;
            String adet = String.valueOf(b);
            tasarim.textViewDetayYemekAdet.setText(adet);
            int fiyat = b * gelenYemek.getYemek_fiyat();
            tasarim.textViewDetayYemekFiyat.setText(String.valueOf(fiyat)+" TL");
        });

        return tasarim.getRoot();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel = new ViewModelProvider(this).get(YemekDetayFragmentViewModel.class);
    }

    public void buttonSepeteEkleTikla(String yemek_adi, String yemek_resim_adi, int yemek_fiyat, int yemek_siparis_adet, String kullanici_adi) {
        viewModel.sepeteYemekleriYukle(yemek_adi, yemek_resim_adi, yemek_fiyat, yemek_siparis_adet, kullanici_adi);
    }
}