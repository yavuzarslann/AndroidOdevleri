package com.example.bitirmeyavuz.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.bitirmeyavuz.entity.Yemekler;
import com.example.bitirmeyavuz.repo.YemeklerDaoRepository;

import java.util.List;

public class AnasayfaFragmentViewModel extends ViewModel {
    private YemeklerDaoRepository yrepo = new YemeklerDaoRepository();
    public MutableLiveData<List<Yemekler>> yemeklerListesi = new MutableLiveData<>();

    public AnasayfaFragmentViewModel() {
        yemekleriYukle();
        yemeklerListesi = yrepo.yemekleriGetir();
    }

    public void yemekleriYukle(){
        yrepo.tumYemekleriAl();
    }
}
