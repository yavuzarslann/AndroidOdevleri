package com.example.odev7yavuz.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import org.jetbrains.annotations.NotNull;

import java.io.Serializable;

@Entity(tableName = "yapilacaklar")
public class Yapilacaklar implements Serializable {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "is_id")
    @NotNull
    private int is_id;
    @ColumnInfo(name = "is_adi")
    @NotNull
    private String is_adi;

    public Yapilacaklar() {
    }

    public Yapilacaklar(int is_id, String is_adi) {
        this.is_id = is_id;
        this.is_adi = is_adi;
    }

    public int getIs_id() {
        return is_id;
    }

    public void setIs_id(int is_id) {
        this.is_id = is_id;
    }

    public String getIs_adi() {
        return is_adi;
    }

    public void setIs_adi(String is_adi) {
        this.is_adi = is_adi;
    }
}
