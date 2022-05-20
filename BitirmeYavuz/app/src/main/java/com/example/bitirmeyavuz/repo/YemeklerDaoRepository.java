package com.example.bitirmeyavuz.repo;

import androidx.lifecycle.MutableLiveData;

import com.example.bitirmeyavuz.entity.CRUDCevap;
import com.example.bitirmeyavuz.entity.Yemekler;
import com.example.bitirmeyavuz.entity.YemeklerCevap;
import com.example.bitirmeyavuz.retrofit.ApiUtils;
import com.example.bitirmeyavuz.retrofit.YemeklerDaoInterface;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class YemeklerDaoRepository {
    private MutableLiveData<List<Yemekler>> yemeklerListesi;
    private YemeklerDaoInterface ydao;


    public YemeklerDaoRepository() {
        ydao = ApiUtils.getYemeklerDaoInterface();
        yemeklerListesi = new MutableLiveData<>();
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
            public void onFailure(Call<YemeklerCevap> call, Throwable t) {

            }
        });
    }

}
