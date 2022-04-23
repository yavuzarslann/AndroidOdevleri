package com.example.odev6yavuz.entity;

import java.io.Serializable;

public class Marketler implements Serializable {
    private int marketId;
    private String marketResim;
    private String marketArac;
    private String marketTeslimatTuru;
    private String marketTeslimatSure;
    private String marketMinSepet;

    public Marketler() {
    }

    public Marketler(int marketId, String marketResim, String marketArac, String marketTeslimatTuru, String marketTeslimatSure, String marketMinSepet) {
        this.marketId = marketId;
        this.marketResim = marketResim;
        this.marketArac = marketArac;
        this.marketTeslimatTuru = marketTeslimatTuru;
        this.marketTeslimatSure = marketTeslimatSure;
        this.marketMinSepet = marketMinSepet;
    }

    public int getMarketId() {
        return marketId;
    }

    public void setMarketId(int marketId) {
        this.marketId = marketId;
    }

    public String getMarketResim() {
        return marketResim;
    }

    public void setMarketResim(String marketResim) {
        this.marketResim = marketResim;
    }

    public String getMarketArac() {
        return marketArac;
    }

    public void setMarketArac(String marketArac) {
        this.marketArac = marketArac;
    }

    public String getMarketTeslimatTuru() {
        return marketTeslimatTuru;
    }

    public void setMarketTeslimatTuru(String marketTeslimatTuru) {
        this.marketTeslimatTuru = marketTeslimatTuru;
    }

    public String getMarketTeslimatSure() {
        return marketTeslimatSure;
    }

    public void setMarketTeslimatSure(String marketTeslimatSure) {
        this.marketTeslimatSure = marketTeslimatSure;
    }

    public String getMarketMinSepet() {
        return marketMinSepet;
    }

    public void setMarketMinSepet(String marketMinSepet) {
        this.marketMinSepet = marketMinSepet;
    }
}
