package com.example.odev7yavuz.repo;

import android.app.Application;
import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.example.odev7yavuz.entity.Yapilacaklar;
import com.example.odev7yavuz.room.Veritabani;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.CompletableObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class YapilacakDaoRepository {
    private MutableLiveData<List<Yapilacaklar>> yapilacakListesi;
    private Veritabani vt;

    public YapilacakDaoRepository(Application application) {
        yapilacakListesi = new MutableLiveData<>();
        vt = Veritabani.veritabaniErisim(application);
    }

    public MutableLiveData<List<Yapilacaklar>> yapilacakGetir(){
        return yapilacakListesi;
    }

    public void isKayit(String is_adi){
        Yapilacaklar yeniIs = new Yapilacaklar(0,is_adi);
        vt.yapilacakDao().isEkle(yeniIs)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new CompletableObserver() {
                    @Override
                    public void onSubscribe(Disposable d) { }
                    @Override
                    public void onComplete() {
                        Log.e("İş kayıt:","BAŞARILI");
                    }
                    @Override
                    public void onError(Throwable e) { }
                });
    }

    public void isGuncelle(int is_id, String is_adi){
        Yapilacaklar guncellenenIs = new Yapilacaklar(is_id,is_adi);
        vt.yapilacakDao().isGuncelle(guncellenenIs)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new CompletableObserver() {
                    @Override
                    public void onSubscribe(Disposable d) { }
                    @Override
                    public void onComplete() {
                        Log.e("İş güncelleme:","BAŞARILI");
                    }
                    @Override
                    public void onError(Throwable e) { }
                });
    }

    public void isAra(String aramaKelimesi){
        Disposable disposable = vt.yapilacakDao().isArama(aramaKelimesi)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(liste ->{
                    yapilacakListesi.setValue(liste);
                });
    }

    public void isSil(int is_id){
        Yapilacaklar silinenIs = new Yapilacaklar(is_id,"");
        vt.yapilacakDao().isSil(silinenIs)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new CompletableObserver() {
                    @Override
                    public void onSubscribe(Disposable d) { }
                    @Override
                    public void onComplete() {
                        Log.e("İş silme:","BAŞARILI");
                        tumIsleriAl();
                    }
                    @Override
                    public void onError(Throwable e) { }
                });
    }

    public void tumIsleriAl(){
        Disposable disposable = vt.yapilacakDao().tumIsler()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(liste ->{
                    yapilacakListesi.setValue(liste);
                });
    }
}
