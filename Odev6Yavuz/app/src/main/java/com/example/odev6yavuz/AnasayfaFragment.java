package com.example.odev6yavuz;

import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.ColorRes;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.odev6yavuz.adapters.DahaOnceAdapter;
import com.example.odev6yavuz.adapters.KategorilerAdapter;
import com.example.odev6yavuz.adapters.MarketlerAdapter;
import com.example.odev6yavuz.databinding.FragmentAnasayfaBinding;
import com.example.odev6yavuz.entity.DahaOnce;
import com.example.odev6yavuz.entity.Kategoriler;
import com.example.odev6yavuz.entity.Marketler;

import java.util.ArrayList;

public class AnasayfaFragment extends Fragment {
    private FragmentAnasayfaBinding tasarim;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        tasarim = FragmentAnasayfaBinding.inflate(inflater, container, false);

        tasarim.bottomNav.setItemIconTintList(null);
        //tasarim.toolbarAnasayfa.setTitle("hepsiburada");

        tasarim.button3.setTextColor(Color.parseColor("#78b72d"));
        tasarim.button3.setOnClickListener(view -> {
            tasarim.button3.setTextColor(Color.parseColor("#78b72d"));
            tasarim.button4.setTextColor(Color.parseColor("#656564"));
            tasarim.button5.setTextColor(Color.parseColor("#656564"));
        });
        tasarim.button4.setOnClickListener(view -> {
            tasarim.button3.setTextColor(Color.parseColor("#656564"));
            tasarim.button4.setTextColor(Color.parseColor("#78b72d"));
            tasarim.button5.setTextColor(Color.parseColor("#656564"));
        });
        tasarim.button5.setOnClickListener(view -> {
            tasarim.button3.setTextColor(Color.parseColor("#656564"));
            tasarim.button4.setTextColor(Color.parseColor("#656564"));
            tasarim.button5.setTextColor(Color.parseColor("#78b72d"));
        });


        tasarim.rvKategori.setLayoutManager(new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.HORIZONTAL));

        ArrayList<Kategoriler> kategorilerListesi = new ArrayList<>();
        Kategoriler k1 = new Kategoriler(1, "Süt", "resim_sut");
        Kategoriler k2 = new Kategoriler(2, "Yumurta", "resim_yumurta");
        Kategoriler k3 = new Kategoriler(3, "Peynir", "resim_peynir");
        Kategoriler k4 = new Kategoriler(4, "Sebze", "resim_sebze");
        Kategoriler k5 = new Kategoriler(5, "Ekmek", "resim_ekmek");
        kategorilerListesi.add(k1);
        kategorilerListesi.add(k2);
        kategorilerListesi.add(k3);
        kategorilerListesi.add(k4);
        kategorilerListesi.add(k5);

        KategorilerAdapter adapter = new KategorilerAdapter(requireContext(), kategorilerListesi);
        tasarim.rvKategori.setAdapter(adapter);

        tasarim.rvMaketler.setLayoutManager(new LinearLayoutManager(requireContext()));
        ArrayList<Marketler> marketlerListesi = new ArrayList<>();
        Marketler m1 = new Marketler(
                1, "resim_migros", "resim_motor", "Hızlı teslimat",
                "25-30 dk", "Min. sepet: 25 TL");
        Marketler m2 = new Marketler(
                2, "resim_istegelsin", "resim_motor", "Hızlı teslimat",
                "25-30 dk", "Min. sepet: 50 TL");
        Marketler m3 = new Marketler(
                3, "resim_carrefor", "resim_araba", "Randevulu teslimat",
                "yarın 18:00-22:00", "Min. sepet: 150 TL");
        Marketler m4 = new Marketler(
                1, "resim_migros", "resim_motor", "Hızlı teslimat",
                "25-30 dk", "Min. sepet: 25 TL");
        marketlerListesi.add(m1);
        marketlerListesi.add(m2);
        marketlerListesi.add(m3);
        marketlerListesi.add(m4);

        MarketlerAdapter adapterMarket = new MarketlerAdapter(requireContext(),marketlerListesi);
        tasarim.rvMaketler.setAdapter(adapterMarket);

        tasarim.rvDahaOnce.setLayoutManager(new StaggeredGridLayoutManager(1,StaggeredGridLayoutManager.HORIZONTAL));
        ArrayList<DahaOnce> dahaOnceListesi = new ArrayList<>();
        DahaOnce d1 = new DahaOnce(1,"resim_nogger","Algida Nogger","7,50 TL");
        DahaOnce d2 = new DahaOnce(2,"resim_brownie","Eti Brownie","4,00 TL");
        DahaOnce d3 = new DahaOnce(3,"resim_lifalif","Eti Lifalif","4,68 TL");
        dahaOnceListesi.add(d1);
        dahaOnceListesi.add(d2);
        dahaOnceListesi.add(d3);

        DahaOnceAdapter adapterDahaOnce = new DahaOnceAdapter(requireContext(),dahaOnceListesi);
        tasarim.rvDahaOnce.setAdapter(adapterDahaOnce);

        return tasarim.getRoot();
    }
}