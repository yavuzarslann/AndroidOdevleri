package com.example.bitirmeyavuz.repo;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.bitirmeyavuz.entity.SepetYemekler;
import com.example.bitirmeyavuz.entity.SepetYemeklerCevap;
import com.example.bitirmeyavuz.retrofit.ApiUtils;
import com.example.bitirmeyavuz.retrofit.SepetAlmaDaoInterface;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SepetAlmaDaoRepository {
    private MutableLiveData<List<SepetYemekler>> sepetYemeklerListesi;
    private SepetAlmaDaoInterface sadao;

    //toplam fiyat hesaplama
    private MutableLiveData<Double> mutableToplamFiyat = new MutableLiveData<>();
    //septteki tekrarı önleme
    private MutableLiveData<Integer> mutableToplamAdet = new MutableLiveData<>();

    public SepetAlmaDaoRepository() {
        sadao = ApiUtils.getSepetAlmaDaoInterface();
        sepetYemeklerListesi = new MutableLiveData<>();
    }

    public MutableLiveData<List<SepetYemekler>> sepetYemekleriGetir(){
        return sepetYemeklerListesi;
    }

    public void sepetYemekleriAl(){
        sadao.sepettekiYemekleriAl("yavuz").enqueue(new Callback<SepetYemeklerCevap>() {
            @Override
            public void onResponse(Call<SepetYemeklerCevap> call, Response<SepetYemeklerCevap> response) {
                sepetYemeklerListesi.setValue(response.body().getSepetYemekler());
                sepetToplamHesapla();
                sepetAdetToplama();
            }

            @Override
            public void onFailure(Call<SepetYemeklerCevap> call, Throwable t) {

            }
        });
    }

    //toplam fiyat hesaplama
    public void sepetToplamHesapla(){
        if(sepetYemeklerListesi.getValue() == null) return;
        double toplam = 0.0;
        List<SepetYemekler> sepetYemeklerList = sepetYemeklerListesi.getValue();
        for(SepetYemekler sepetYemekler: sepetYemeklerList){
            toplam += sepetYemekler.getYemek_fiyat() * sepetYemekler.getYemek_siparis_adet();
        }
        mutableToplamFiyat.setValue(toplam);
    }

    //toplam fiyat hesaplama
    public LiveData<Double> toplamFiyatiAl(){
        if(mutableToplamFiyat == null){
            mutableToplamFiyat.setValue(0.0);
        }
        return mutableToplamFiyat;
    }

    //septteki tekrarı önleme
    public void sepetAdetToplama(){
        if (sepetYemeklerListesi.getValue() == null) return;
        Integer toplamAdet = 0;
        List<SepetYemekler> sepetYemeklerList = sepetYemeklerListesi.getValue();
        for (SepetYemekler sepetYemekler: sepetYemeklerList){
            toplamAdet = sepetYemekler.getYemek_siparis_adet();
        }
        mutableToplamAdet.setValue(toplamAdet);
    }

    public LiveData<Integer> toplamAdetAl(){
        if (mutableToplamAdet == null){
            mutableToplamAdet.setValue(0);
        }
        return mutableToplamAdet;
    }
}
