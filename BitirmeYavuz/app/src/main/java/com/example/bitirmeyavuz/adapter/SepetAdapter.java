package com.example.bitirmeyavuz.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bitirmeyavuz.R;
import com.example.bitirmeyavuz.databinding.CardTasarimSepetBinding;
import com.example.bitirmeyavuz.entity.SepetYemekler;
import com.example.bitirmeyavuz.viewmodel.YemekSepetFragmentViewModel;
import com.google.android.material.snackbar.Snackbar;
import com.squareup.picasso.Picasso;

import java.util.List;

public class SepetAdapter extends RecyclerView.Adapter<SepetAdapter.CardTasarimTutucu>{
    private Context mContext;
    private List<SepetYemekler> sepetYemeklerListesi;
    private YemekSepetFragmentViewModel viewModel;

    public SepetAdapter(Context mContext, List<SepetYemekler> sepetYemeklerListesi, YemekSepetFragmentViewModel viewModel) {
        this.mContext = mContext;
        this.sepetYemeklerListesi = sepetYemeklerListesi;
        this.viewModel = viewModel;
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
        CardTasarimSepetBinding tasarim = DataBindingUtil.inflate(layoutInflater,R.layout.card_tasarim_sepet,parent,false);
        return new CardTasarimTutucu(tasarim);
    }

    @Override
    public void onBindViewHolder(@NonNull CardTasarimTutucu holder, int position) {
        SepetYemekler sYemek = sepetYemeklerListesi.get(position);
        CardTasarimSepetBinding t = holder.tasarim;


        t.setSepetNesnesi(sYemek);

        String url = "http://kasimadalan.pe.hu/yemekler/resimler/" + sYemek.getYemek_resim_adi();
        Picasso.get().load(url).into(t.imageViewSepetResim);

        t.imageViewSilResim.setOnClickListener(view -> {
            Snackbar.make(view,sYemek.getYemek_adi()+" sepetten silinsin mi?",Snackbar.LENGTH_LONG)
                    .setAction("Evet",v1 ->{
                        viewModel.sepetYemekleriSil(sYemek.getSepet_yemek_id(),"yavuz");
                        viewModel.sepetYemekleriYukle();
                    }).show();
        });

    }

    @Override
    public int getItemCount() {
        return sepetYemeklerListesi.size();
    }
}
