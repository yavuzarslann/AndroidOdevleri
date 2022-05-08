package com.example.odev7yavuz.viewmodel;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.ViewModel;

import com.example.odev7yavuz.repo.YapilacakDaoRepository;

public class KayitFragmentViewModel extends AndroidViewModel {
    private YapilacakDaoRepository yrepo;

    public KayitFragmentViewModel(@NonNull Application application) {
        super(application);
        yrepo = new YapilacakDaoRepository(application);
    }

    public void kayit(String is_adi){
        yrepo.isKayit(is_adi);
    }
}
