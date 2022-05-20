package com.example.bitirmeyavuz.viewmodel;

import android.view.View;

import androidx.lifecycle.ViewModel;

import com.example.bitirmeyavuz.repo.SepetDaoRepository;
import com.example.bitirmeyavuz.repo.YemeklerDaoRepository;

public class YemekDetayFragmentViewModel extends ViewModel {
    private SepetDaoRepository srepo = new SepetDaoRepository();

    public void sepeteYemekleriYukle(String yemek_adi, String yemek_resim_adi, int yemek_fiyat, int yemek_siparis_adet, String kullanici_adi){
        srepo.sepetYemekleriEkle(yemek_adi, yemek_resim_adi, yemek_fiyat, yemek_siparis_adet, kullanici_adi);
    }
}
