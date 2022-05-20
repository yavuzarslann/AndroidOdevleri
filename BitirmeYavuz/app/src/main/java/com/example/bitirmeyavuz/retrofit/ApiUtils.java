package com.example.bitirmeyavuz.retrofit;

public class ApiUtils {
    public static final String BASE_URL = "http://kasimadalan.pe.hu/";

    public static YemeklerDaoInterface getYemeklerDaoInterface(){
        return RetrofitClient.getClient(BASE_URL).create(YemeklerDaoInterface.class);
    }

    public static SepetDaoInterface getSepetDaoInterFace(){
        return RetrofitClient.getClient(BASE_URL).create(SepetDaoInterface.class);
    }

    public static SepetAlmaDaoInterface getSepetAlmaDaoInterface(){
        return RetrofitClient.getClient(BASE_URL).create(SepetAlmaDaoInterface.class);
    }

    public static SepetSilmeDaoInterface getSepetSilmeDaoInterface(){
        return RetrofitClient.getClient(BASE_URL).create(SepetSilmeDaoInterface.class);
    }
}
