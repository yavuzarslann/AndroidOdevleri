package com.example.bitirmeyavuz.repo;

import com.example.bitirmeyavuz.entity.CRUDCevap;
import com.example.bitirmeyavuz.retrofit.ApiUtils;
import com.example.bitirmeyavuz.retrofit.SepetSilmeDaoInterface;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SepetSilmeDaoRepository {
    private SepetSilmeDaoInterface ssdao;

    //toplam fiyat hesaplama
    private SepetAlmaDaoRepository sarepo;

    public SepetSilmeDaoRepository() {
        ssdao = ApiUtils.getSepetSilmeDaoInterface();

    }

    public void sepetYemekleriSil(int sepet_yemek_id, String kullanici_adi) {
        ssdao.sepetYemekSil(sepet_yemek_id, kullanici_adi).enqueue(new Callback<CRUDCevap>() {
            @Override
            public void onResponse(Call<CRUDCevap> call, Response<CRUDCevap> response) {

            }

            @Override
            public void onFailure(Call<CRUDCevap> call, Throwable t) {

            }
        });
    }
}
