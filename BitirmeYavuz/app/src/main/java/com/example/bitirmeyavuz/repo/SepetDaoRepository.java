package com.example.bitirmeyavuz.repo;

import com.example.bitirmeyavuz.entity.CRUDCevap;
import com.example.bitirmeyavuz.retrofit.ApiUtils;
import com.example.bitirmeyavuz.retrofit.SepetDaoInterface;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SepetDaoRepository {
    private SepetDaoInterface sdao;


    public SepetDaoRepository() {
        sdao = ApiUtils.getSepetDaoInterFace();
    }

    public void sepetYemekleriEkle(String yemek_adi, String yemek_resim_adi, int yemek_fiyat, int yemek_siparis_adet, String kullanici_adi){
        sdao.sepeteYemekEkle( yemek_adi,  yemek_resim_adi,  yemek_fiyat,  yemek_siparis_adet,  kullanici_adi).enqueue(new Callback<CRUDCevap>() {
            @Override
            public void onResponse(Call<CRUDCevap> call, Response<CRUDCevap> response) {

            }

            @Override
            public void onFailure(Call<CRUDCevap> call, Throwable t) {

            }
        });
    }
}
