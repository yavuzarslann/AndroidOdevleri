package com.example.odev6yavuz.adapters;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.odev6yavuz.databinding.CardTasarimMarketlerBinding;
import com.example.odev6yavuz.entity.Marketler;

import java.util.List;

public class MarketlerAdapter extends RecyclerView.Adapter<MarketlerAdapter.CardTasarimMarketlerTutucu>{
    private Context mContext;
    private List<Marketler> marketlerListesi;

    public MarketlerAdapter(Context mContext, List<Marketler> marketlerListesi) {
        this.mContext = mContext;
        this.marketlerListesi = marketlerListesi;
    }


    public class CardTasarimMarketlerTutucu extends RecyclerView.ViewHolder {
        private CardTasarimMarketlerBinding tasarim;
        public CardTasarimMarketlerTutucu(CardTasarimMarketlerBinding tasarim) {
            super(tasarim.getRoot());
            this.tasarim = tasarim;
        }
    }

    @NonNull
    @Override
    public CardTasarimMarketlerTutucu onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(mContext);
        CardTasarimMarketlerBinding tasarim = CardTasarimMarketlerBinding.inflate(layoutInflater,parent,false);
        return new CardTasarimMarketlerTutucu(tasarim);
    }

    @Override
    public void onBindViewHolder(@NonNull CardTasarimMarketlerTutucu holder, int position) {
        Marketler market = marketlerListesi.get(position);
        CardTasarimMarketlerBinding t = holder.tasarim;

        t.imageViewMarketResim.setImageResource(mContext.getResources().getIdentifier(market.getMarketResim(),"drawable",mContext.getPackageName()));
        t.imageViewAracResim.setImageResource(
                mContext.getResources().getIdentifier(market.getMarketArac(),"drawable",mContext.getPackageName()));
        t.textViewTeslimatTuru.setText(market.getMarketTeslimatTuru());
        t.textViewTeslimatSure.setText(market.getMarketTeslimatSure());
        t.textViewMinSepet.setText(market.getMarketMinSepet());

        if(market.getMarketTeslimatTuru() == "Randevulu teslimat"){
            t.textViewTeslimatTuru.setTextColor(Color.parseColor("#4c9deb"));
            t.textViewTeslimatSure.setTextColor(Color.parseColor("#4c9deb"));
        }
    }

    @Override
    public int getItemCount() {
        return marketlerListesi.size();
    }
}
