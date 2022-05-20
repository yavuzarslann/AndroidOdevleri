package com.example.bitirmeyavuz.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bitirmeyavuz.R;
import com.example.bitirmeyavuz.databinding.CardTasarimYemeklerBinding;
import com.example.bitirmeyavuz.entity.Yemekler;
import com.example.bitirmeyavuz.fragment.AnasayfaFragmentDirections;
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

        //t.imageViewTumYemekler.setImageResource(mContext.getResources().getIdentifier(yemek.getYemek_resim_adi(), "drawable", mContext.getPackageName()));

        String url = "http://kasimadalan.pe.hu/yemekler/resimler/" + yemek.getYemek_resim_adi();
        Picasso.get().load(url).into(t.imageViewTumYemekler);

        t.cardYemekler.setOnClickListener(view -> {
            AnasayfaFragmentDirections.DetayGecis gecis = AnasayfaFragmentDirections.detayGecis(yemek);
            Navigation.findNavController(view).navigate(gecis);
        });
    }

    @Override
    public int getItemCount() {
        return yemeklerListesi.size();
    }
}
