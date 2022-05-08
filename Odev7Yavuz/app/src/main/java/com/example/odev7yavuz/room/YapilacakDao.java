package com.example.odev7yavuz.room;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.odev7yavuz.entity.Yapilacaklar;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Single;

@Dao
public interface YapilacakDao {
    @Query("SELECT * FROM yapilacaklar")
    Single<List<Yapilacaklar>> tumIsler();

    @Insert
    Completable isEkle(Yapilacaklar is);

    @Update
    Completable isGuncelle(Yapilacaklar is);

    @Delete
    Completable isSil(Yapilacaklar is);

    @Query("SELECT * FROM yapilacaklar WHERE is_adi like '%' || :aramaKelimesi || '%'")
    Single<List<Yapilacaklar>> isArama(String aramaKelimesi);
}
