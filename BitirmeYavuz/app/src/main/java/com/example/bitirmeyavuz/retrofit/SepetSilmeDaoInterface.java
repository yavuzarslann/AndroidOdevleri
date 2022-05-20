package com.example.bitirmeyavuz.retrofit;

import com.example.bitirmeyavuz.entity.CRUDCevap;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface SepetSilmeDaoInterface {
    @POST("yemekler/sepettenYemekSil.php")
    @FormUrlEncoded
    Call<CRUDCevap> sepetYemekSil(@Field("sepet_yemek_id") int sepet_yemek_id,
                                  @Field("kullanici_adi") String kullanici_adi);
}
