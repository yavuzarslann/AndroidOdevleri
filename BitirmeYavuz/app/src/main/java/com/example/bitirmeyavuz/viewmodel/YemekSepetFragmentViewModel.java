package com.example.bitirmeyavuz.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.bitirmeyavuz.entity.SepetYemekler;
import com.example.bitirmeyavuz.repo.SepetAlmaDaoRepository;
import com.example.bitirmeyavuz.repo.SepetSilmeDaoRepository;

import java.util.List;

public class YemekSepetFragmentViewModel extends ViewModel {
    private SepetAlmaDaoRepository sarepo = new SepetAlmaDaoRepository();
    public MutableLiveData<List<SepetYemekler>> sepetYemeklerListesi = new MutableLiveData<>();
    private SepetSilmeDaoRepository ssrepo = new SepetSilmeDaoRepository();

    public YemekSepetFragmentViewModel() {
        sepetYemekleriYukle();
        sepetYemeklerListesi = sarepo.sepetYemekleriGetir();
    }

    public void sepetYemekleriYukle(){
        sarepo.sepetYemekleriAl();
    }

    public void sepetYemekleriSil(int sepet_yemek_id,String kullanici_adi){
        ssrepo.sepetYemekleriSil(sepet_yemek_id,kullanici_adi);
    }

    //toplam fiyat hesaplama
    public LiveData<Double> toplamFiyatiAl(){
        return sarepo.toplamFiyatiAl();
    }
}
