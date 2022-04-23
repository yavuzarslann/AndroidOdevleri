package com.example.odev6yavuz.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.odev6yavuz.databinding.CardTasarimDahaonceBinding;
import com.example.odev6yavuz.entity.DahaOnce;

import java.util.List;

public class DahaOnceAdapter extends RecyclerView.Adapter<DahaOnceAdapter.CardTasarimDahaOnceTutucu>{
    private Context mContext;
    private List<DahaOnce> dahaOnceListesi;

    public DahaOnceAdapter(Context mContext, List<DahaOnce> dahaOnceListesi) {
        this.mContext = mContext;
        this.dahaOnceListesi = dahaOnceListesi;
    }

    public class CardTasarimDahaOnceTutucu extends RecyclerView.ViewHolder{
        private CardTasarimDahaonceBinding tasarim;
        public CardTasarimDahaOnceTutucu(CardTasarimDahaonceBinding tasarim) {
            super(tasarim.getRoot());
            this.tasarim = tasarim;
        }
    }

    @NonNull
    @Override
    public CardTasarimDahaOnceTutucu onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(mContext);
        CardTasarimDahaonceBinding tasarim = CardTasarimDahaonceBinding.inflate(layoutInflater,parent,false);
        return new CardTasarimDahaOnceTutucu(tasarim);
    }

    @Override
    public void onBindViewHolder(@NonNull CardTasarimDahaOnceTutucu holder, int position) {
        DahaOnce dahaOnce = dahaOnceListesi.get(position);
        CardTasarimDahaonceBinding t = holder.tasarim;

        t.imageViewDahaOnce.setImageResource(
                mContext.getResources().getIdentifier(
                        dahaOnce.getDahaResim(),"drawable",mContext.getPackageName()));
        t.textViewDahaAd.setText(dahaOnce.getDahaAdi());
        t.textViewDahaFiyat.setText(dahaOnce.getDahaFiyat());
    }

    @Override
    public int getItemCount() {
        return dahaOnceListesi.size();
    }
}
