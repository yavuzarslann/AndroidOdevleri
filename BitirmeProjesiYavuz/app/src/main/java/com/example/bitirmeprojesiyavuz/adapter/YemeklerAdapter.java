package com.example.bitirmeprojesiyavuz.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bitirmeprojesiyavuz.R;
import com.example.bitirmeprojesiyavuz.databinding.CardTasarimYemeklerBinding;
import com.example.bitirmeprojesiyavuz.entity.Yemekler;
import com.example.bitirmeprojesiyavuz.fragment.AnasayfaFragmentDirections;
import com.google.android.material.snackbar.Snackbar;
import com.squareup.picasso.Picasso;

import java.util.List;

public class YemeklerAdapter extends RecyclerView.Adapter<YemeklerAdapter.CardTasarimTutucu> {
    private Context mContext;
    private List<Yemekler> yemeklerListesi;

    public YemeklerAdapter(Context mContext, List<Yemekler> yemeklerListesi) {
        this.mContext = mContext;
        this.yemeklerListesi = yemeklerListesi;
    }

    public class CardTasarimTutucu extends RecyclerView.ViewHolder {
        private CardTasarimYemeklerBinding tasarim;

        public CardTasarimTutucu(CardTasarimYemeklerBinding tasarim) {
            super(tasarim.getRoot());
            this.tasarim = tasarim;
        }
    }

    @NonNull
    @Override
    public CardTasarimTutucu onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(mContext);
        CardTasarimYemeklerBinding tasarim = DataBindingUtil.inflate(layoutInflater, R.layout.card_tasarim_yemekler, parent, false);
        return new CardTasarimTutucu(tasarim);
    }

    @Override
    public void onBindViewHolder(@NonNull CardTasarimTutucu holder, int position) {
        Yemekler yemek = yemeklerListesi.get(position);
        CardTasarimYemeklerBinding t = holder.tasarim;

        t.setYemekNesnesi(yemek);

        String url = "http://kasimadalan.pe.hu/yemekler/resimler/" + yemek.getYemek_resim_adi();
        Picasso.get().load(url).into(t.imageViewYemekResim);

        t.buttonYemekEkle.setOnClickListener(view -> {
            Snackbar.make(view, yemek.getYemek_adi() + " sepete eklendi", Snackbar.LENGTH_SHORT).show();
        });

        t.cardViewYemekler.setOnClickListener(view -> {
            AnasayfaFragmentDirections.YemekDetayGecis gecis = AnasayfaFragmentDirections.yemekDetayGecis(yemek);
            Navigation.findNavController(view).navigate(gecis);
        });

    }

    @Override
    public int getItemCount() {
        return yemeklerListesi.size();
    }

}
