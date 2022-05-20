package com.example.bitirmeyavuz.retrofit;

import com.example.bitirmeyavuz.entity.CRUDCevap;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface SepetDaoInterface {
    @POST("yemekler/sepeteYemekEkle.php")
    @FormUrlEncoded
    Call<CRUDCevap> sepeteYemekEkle(@Field("yemek_adi") String yemek_adi,
                                    @Field("yemek_resim_adi") String yemek_resim_adi,
                                    @Field("yemek_fiyat") int yemek_fiyat,
                                    @Field("yemek_siparis_adet") int yemek_siparis_adet,
                                    @Field("kullanici_adi") String kullanici_adi);
}
