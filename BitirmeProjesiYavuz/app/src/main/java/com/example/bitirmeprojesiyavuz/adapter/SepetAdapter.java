package com.example.bitirmeprojesiyavuz.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bitirmeprojesiyavuz.R;
import com.example.bitirmeprojesiyavuz.databinding.CardTasarimSepetBinding;
import com.example.bitirmeprojesiyavuz.entity.SepetYemekler;

import java.util.List;

public class SepetAdapter extends RecyclerView.Adapter<SepetAdapter.CardTasarimTutucu>{
    private Context mContext;
    private List<SepetYemekler> sepetYemeklerListesi;

    public SepetAdapter(Context mContext, List<SepetYemekler> sepetYemeklerListesi) {
        this.mContext = mContext;
        this.sepetYemeklerListesi = sepetYemeklerListesi;
    }

    public class CardTasarimTutucu extends RecyclerView.ViewHolder{
        private CardTasarimSepetBinding tasarim;

        public CardTasarimTutucu(CardTasarimSepetBinding tasarim) {
            super(tasarim.getRoot());
            this.tasarim = tasarim;
        }
    }

    @NonNull
    @Override
    public CardTasarimTutucu onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(mContext);
        CardTasarimSepetBinding tasarim = DataBindingUtil.inflate(layoutInflater, R.layout.card_tasarim_sepet,parent,false);
        return new CardTasarimTutucu(tasarim);
    }

    @Override
    public void onBindViewHolder(@NonNull CardTasarimTutucu holder, int position) {
        SepetYemekler sYemek = sepetYemeklerListesi.get(position);
        CardTasarimSepetBinding t = holder.tasarim;

        t.imageViewYemekResimSepet.setImageResource(
                mContext.getResources().getIdentifier(sYemek.getYemek_resim_adi(),"drawable",mContext.getPackageName()));
        t.setSepetNesnesi(sYemek);


    }

    @Override
    public int getItemCount() {
        return sepetYemeklerListesi.size();
    }
}
