package com.example.bitirmeyavuz.retrofit;

import com.example.bitirmeyavuz.entity.CRUDCevap;
import com.example.bitirmeyavuz.entity.YemeklerCevap;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface YemeklerDaoInterface {
    //http://kasimadalan.pe.hu/yemekler/tumYemekleriGetir.php
    @GET("yemekler/tumYemekleriGetir.php")
    Call<YemeklerCevap> tumYemekler();

}
