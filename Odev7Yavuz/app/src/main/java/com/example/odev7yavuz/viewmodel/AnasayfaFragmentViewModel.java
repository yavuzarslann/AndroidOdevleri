package com.example.odev7yavuz.viewmodel;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.odev7yavuz.entity.Yapilacaklar;
import com.example.odev7yavuz.repo.YapilacakDaoRepository;

import java.util.List;

public class AnasayfaFragmentViewModel extends AndroidViewModel {
    private YapilacakDaoRepository yrepo;
    public MutableLiveData<List<Yapilacaklar>> yapilacakListesi = new MutableLiveData();

    public AnasayfaFragmentViewModel(@NonNull Application application) {
        super(application);
        yrepo = new YapilacakDaoRepository(application);
        yapilacakYukle();
        yapilacakListesi = yrepo.yapilacakGetir();
    }

    public void yapilacakYukle(){
        yrepo.tumIsleriAl();
    }

    public void ara(String aramaKelimesi){
        yrepo.isAra(aramaKelimesi);
    }

    public void sil(int is_id){
        yrepo.isSil(is_id);
    }
}
