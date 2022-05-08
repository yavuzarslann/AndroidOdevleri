package com.example.odev7yavuz.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.ViewModel;

import com.example.odev7yavuz.repo.YapilacakDaoRepository;

public class DetayFragmentViewModel extends AndroidViewModel {
    private YapilacakDaoRepository yrepo;

    public DetayFragmentViewModel(@NonNull Application application) {
        super(application);
        yrepo = new YapilacakDaoRepository(application);
    }

    public void guncelle(int is_id, String is_adi){
        yrepo.isGuncelle(is_id,is_adi);
    }
}
