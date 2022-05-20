package com.example.bitirmeyavuz.retrofit;

import com.example.bitirmeyavuz.entity.SepetYemeklerCevap;
import com.example.bitirmeyavuz.entity.YemeklerCevap;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface SepetAlmaDaoInterface {
    @POST("yemekler/sepettekiYemekleriGetir.php")
    @FormUrlEncoded
    Call<SepetYemeklerCevap> sepettekiYemekleriAl(@Field("kullanici_adi") String kullanici_adi);
}
