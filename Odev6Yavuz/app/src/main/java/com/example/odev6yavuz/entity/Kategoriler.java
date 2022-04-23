package com.example.odev6yavuz.entity;

import java.io.Serializable;

public class Kategoriler implements Serializable {
    private int kategoriId;
    private String kategoriAdi;
    private String kategoriResimAdi;

    public Kategoriler() {
    }

    public Kategoriler(int kategoriId, String kategoriAdi, String kategoriResimAdi) {
        this.kategoriId = kategoriId;
        this.kategoriAdi = kategoriAdi;
        this.kategoriResimAdi = kategoriResimAdi;
    }

    public int getKategoriId() {
        return kategoriId;
    }

    public void setKategoriId(int kategoriId) {
        this.kategoriId = kategoriId;
    }

    public String getKategoriAdi() {
        return kategoriAdi;
    }

    public void setKategoriAdi(String kategoriAdi) {
        this.kategoriAdi = kategoriAdi;
    }

    public String getKategoriResimAdi() {
        return kategoriResimAdi;
    }

    public void setKategoriResimAdi(String kategoriResimAdi) {
        this.kategoriResimAdi = kategoriResimAdi;
    }
}
