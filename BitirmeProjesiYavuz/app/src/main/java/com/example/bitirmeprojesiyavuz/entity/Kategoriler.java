package com.example.bitirmeprojesiyavuz.entity;

import java.io.Serializable;

public class Kategoriler implements Serializable {
    private int kategori_id;
    private String kategori_adi;
    private String kategori_resim_adi;

    public Kategoriler() {
    }

    public Kategoriler(int kategori_id, String kategori_adi, String kategori_resim_adi) {
        this.kategori_id = kategori_id;
        this.kategori_adi = kategori_adi;
        this.kategori_resim_adi = kategori_resim_adi;
    }

    public int getKategori_id() {
        return kategori_id;
    }

    public void setKategori_id(int kategori_id) {
        this.kategori_id = kategori_id;
    }

    public String getKategori_adi() {
        return kategori_adi;
    }

    public void setKategori_adi(String kategori_adi) {
        this.kategori_adi = kategori_adi;
    }

    public String getKategori_resim_adi() {
        return kategori_resim_adi;
    }

    public void setKategori_resim_adi(String kategori_resim_adi) {
        this.kategori_resim_adi = kategori_resim_adi;
    }
}
