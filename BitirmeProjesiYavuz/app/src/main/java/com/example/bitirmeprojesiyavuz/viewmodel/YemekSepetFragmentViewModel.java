package com.example.bitirmeprojesiyavuz.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.bitirmeprojesiyavuz.entity.SepetYemekler;
import com.example.bitirmeprojesiyavuz.repo.YemeklerDaoRepository;

import java.util.List;

public class YemekSepetFragmentViewModel extends ViewModel {
    private YemeklerDaoRepository yrepo = new YemeklerDaoRepository();
    public MutableLiveData<List<SepetYemekler>> sepetYemeklerListesi = new MutableLiveData<>();

    public YemekSepetFragmentViewModel() {
        sepettekiYemekleriYukle("yavuz");
        sepetYemeklerListesi = yrepo.sepetYemekleriGetir();
    }

    public void sepettekiYemekleriYukle(String kullanici_adi){
        yrepo.sepettekiYemekleriAl(kullanici_adi);
    }


}
