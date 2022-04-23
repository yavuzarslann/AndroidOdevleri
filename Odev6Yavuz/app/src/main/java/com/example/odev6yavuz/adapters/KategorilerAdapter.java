package com.example.odev6yavuz.adapters;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.odev6yavuz.databinding.CardTasarimKategoriBinding;
import com.example.odev6yavuz.entity.Kategoriler;

import java.util.List;

public class KategorilerAdapter extends RecyclerView.Adapter<KategorilerAdapter.CardTasarimKategoriTutucu>{
    private Context mContext;
    private List<Kategoriler> kategorilerListesi;

    public KategorilerAdapter(Context mContext, List<Kategoriler> kategorilerListesi) {
        this.mContext = mContext;
        this.kategorilerListesi = kategorilerListesi;
    }


    public class CardTasarimKategoriTutucu extends RecyclerView.ViewHolder {
        private CardTasarimKategoriBinding tasarim;
        public CardTasarimKategoriTutucu(CardTasarimKategoriBinding tasarim) {
            super(tasarim.getRoot());
            this.tasarim = tasarim;
        }
    }

    @NonNull
    @Override
    public CardTasarimKategoriTutucu onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(mContext);
        CardTasarimKategoriBinding tasarim = CardTasarimKategoriBinding.inflate(layoutInflater,parent,false);
        return new CardTasarimKategoriTutucu(tasarim);
    }

    @Override
    public void onBindViewHolder(@NonNull CardTasarimKategoriTutucu holder, int position) {
        Kategoriler kategori = kategorilerListesi.get(position);
        CardTasarimKategoriBinding t = holder.tasarim;

        t.imageViewKategoriResim.setImageResource(mContext.getResources().getIdentifier(kategori.getKategoriResimAdi(),"drawable",mContext.getPackageName()));
        t.textViewKategoriAdi.setText(kategori.getKategoriAdi());

    }

    @Override
    public int getItemCount() {
        return kategorilerListesi.size();
    }
}
