package com.example.odev6yavuz.entity;

import java.io.Serializable;

public class DahaOnce implements Serializable {
    private int dahaId;
    private String dahaResim;
    private String dahaAdi;
    private String dahaFiyat;

    public DahaOnce() {
    }

    public DahaOnce(int dahaId, String dahaResim, String dahaAdi, String dahaFiyat) {
        this.dahaId = dahaId;
        this.dahaResim = dahaResim;
        this.dahaAdi = dahaAdi;
        this.dahaFiyat = dahaFiyat;
    }

    public int getDahaId() {
        return dahaId;
    }

    public void setDahaId(int dahaId) {
        this.dahaId = dahaId;
    }

    public String getDahaResim() {
        return dahaResim;
    }

    public void setDahaResim(String dahaResim) {
        this.dahaResim = dahaResim;
    }

    public String getDahaAdi() {
        return dahaAdi;
    }

    public void setDahaAdi(String dahaAdi) {
        this.dahaAdi = dahaAdi;
    }

    public String getDahaFiyat() {
        return dahaFiyat;
    }

    public void setDahaFiyat(String dahaFiyat) {
        this.dahaFiyat = dahaFiyat;
    }
}
