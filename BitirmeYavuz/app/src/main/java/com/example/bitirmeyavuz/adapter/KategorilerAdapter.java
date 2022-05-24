package com.example.bitirmeyavuz.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bitirmeyavuz.R;
import com.example.bitirmeyavuz.databinding.CardTasarimKategorilerBinding;
import com.example.bitirmeyavuz.entity.Kategoriler;

import java.util.List;

public class KategorilerAdapter extends RecyclerView.Adapter<KategorilerAdapter.CardTasarimTutucu> {
    private Context mContext;
    private List<Kategoriler> kategorilerListesi;

    public KategorilerAdapter(Context mContext, List<Kategoriler> kategorilerListesi) {
        this.mContext = mContext;
        this.kategorilerListesi = kategorilerListesi;
    }

    public class CardTasarimTutucu extends RecyclerView.ViewHolder {
        private CardTasarimKategorilerBinding tasarim;

        public CardTasarimTutucu(CardTasarimKategorilerBinding tasarim) {
            super(tasarim.getRoot());
            this.tasarim = tasarim;
        }
    }

    @NonNull
    @Override
    public CardTasarimTutucu onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(mContext);
        CardTasarimKategorilerBinding tasarim = DataBindingUtil.inflate(layoutInflater, R.layout.card_tasarim_kategoriler, parent, false);
        return new CardTasarimTutucu(tasarim);
    }

    @Override
    public void onBindViewHolder(@NonNull CardTasarimTutucu holder, int position) {
        Kategoriler kategori = kategorilerListesi.get(position);
        CardTasarimKategorilerBinding t = holder.tasarim;

        t.setKategoriNesnesi(kategori);

        t.imageViewKategoriResim.setImageResource(mContext.getResources().getIdentifier(kategori.getKategori_resim_adi(), "drawable", mContext.getPackageName()));

    }

    @Override
    public int getItemCount() {
        return kategorilerListesi.size();
    }
}
