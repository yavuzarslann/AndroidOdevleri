package com.example.bitirmeprojesiyavuz.retrofit;

public class ApiUtils {
    public static final String BASE_URL = "http://kasimadalan.pe.hu/";

    public static YemeklerdaoInterface getYemeklerDaoInterface(){
        return RetrofitClient.getClient(BASE_URL).create(YemeklerdaoInterface.class);
    }
}
