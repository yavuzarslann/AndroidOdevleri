package com.example.bitirmeprojesiyavuz.repo;

import androidx.lifecycle.MutableLiveData;

import com.example.bitirmeprojesiyavuz.entity.CRUDCevap;
import com.example.bitirmeprojesiyavuz.entity.SepetYemekler;
import com.example.bitirmeprojesiyavuz.entity.SepetYemeklerCevap;
import com.example.bitirmeprojesiyavuz.entity.Yemekler;
import com.example.bitirmeprojesiyavuz.entity.YemeklerCevap;
import com.example.bitirmeprojesiyavuz.retrofit.ApiUtils;
import com.example.bitirmeprojesiyavuz.retrofit.YemeklerdaoInterface;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class YemeklerDaoRepository {
    private MutableLiveData<List<Yemekler>> yemeklerListesi;
    private YemeklerdaoInterface ydao;
    private MutableLiveData<List<SepetYemekler>> sepetYemeklerListesi;

    public YemeklerDaoRepository() {
        ydao = ApiUtils.getYemeklerDaoInterface();
        yemeklerListesi = new MutableLiveData<>();
        sepetYemeklerListesi = new MutableLiveData<>();
    }

    public MutableLiveData<List<Yemekler>> yemekleriGetir(){
        return yemeklerListesi;
    }

    public void tumYemekleriAl(){
        ydao.tumYemekler().enqueue(new Callback<YemeklerCevap>() {
            @Override
            public void onResponse(Call<YemeklerCevap> call, Response<YemeklerCevap> response) {
                List<Yemekler> liste = response.body().getYemekler();
                yemeklerListesi.setValue(liste);
            }
            @Override
            public void onFailure(Call<YemeklerCevap> call, Throwable t) { }
        });
    }

    public void sepetYemekleriEkle(String yemek_adi, String yemek_resim_adi, int yemek_fiyat, int yemek_siparis_adet, String kullanici_adi){
        ydao.sepeteYemekEkle(yemek_adi, yemek_resim_adi, yemek_fiyat, yemek_siparis_adet, kullanici_adi).enqueue(new Callback<CRUDCevap>() {
            @Override
            public void onResponse(Call<CRUDCevap> call, Response<CRUDCevap> response) {

            }
            @Override
            public void onFailure(Call<CRUDCevap> call, Throwable t) { }
        });
    }

    public MutableLiveData<List<SepetYemekler>> sepetYemekleriGetir(){
        return sepetYemeklerListesi;
    }

    public void sepettekiYemekleriAl(String kullanici_adi){
        ydao.sepettekiYemekleriAlma(kullanici_adi).enqueue(new Callback<SepetYemeklerCevap>() {
            @Override
            public void onResponse(Call<SepetYemeklerCevap> call, Response<SepetYemeklerCevap> response) {
                List<SepetYemekler> liste = response.body().getSepetYemekler();
                sepetYemeklerListesi.setValue(liste);
            }

            @Override
            public void onFailure(Call<SepetYemeklerCevap> call, Throwable t) {

            }
        });
    }
}
