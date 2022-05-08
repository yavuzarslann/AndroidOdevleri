package com.example.odev7yavuz.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.example.odev7yavuz.R;
import com.example.odev7yavuz.databinding.CardTasarimBinding;
import com.example.odev7yavuz.entity.Yapilacaklar;
import com.example.odev7yavuz.fragments.AnasayfaFragmentDirections;
import com.example.odev7yavuz.viewmodel.AnasayfaFragmentViewModel;
import com.google.android.material.snackbar.Snackbar;

import java.util.List;

public class YapilacakAdapter extends RecyclerView.Adapter<YapilacakAdapter.CardTasarimTutucu> {
    private Context mContext;
    private List<Yapilacaklar> yapilacaklarListesi;
    private AnasayfaFragmentViewModel viewModel;

    public YapilacakAdapter(Context mContext, List<Yapilacaklar> yapilacaklarListesi, AnasayfaFragmentViewModel viewModel) {
        this.mContext = mContext;
        this.yapilacaklarListesi = yapilacaklarListesi;
        this.viewModel = viewModel;
    }

    public class CardTasarimTutucu extends RecyclerView.ViewHolder {
        private CardTasarimBinding tasarim;

        public CardTasarimTutucu(CardTasarimBinding tasarim) {
            super(tasarim.getRoot());
            this.tasarim = tasarim;
        }
    }

    @NonNull
    @Override
    public CardTasarimTutucu onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(mContext);
        CardTasarimBinding tasarim = DataBindingUtil.inflate(layoutInflater, R.layout.card_tasarim, parent, false);
        return new CardTasarimTutucu(tasarim);
    }

    @Override
    public void onBindViewHolder(@NonNull CardTasarimTutucu holder, int position) {
        Yapilacaklar is = yapilacaklarListesi.get(position);
        CardTasarimBinding t = holder.tasarim;

        t.setYapilacakNesnesi(is);

        t.satirCard.setOnClickListener(view -> {
            AnasayfaFragmentDirections.IsDetayGecis gecis = AnasayfaFragmentDirections.isDetayGecis(is);
            Navigation.findNavController(view).navigate(gecis);
        });

        t.imageViewSilResim.setOnClickListener(view -> {
            Snackbar.make(view, "Yapılacak " + is.getIs_id() +" silinsin mi?", Snackbar.LENGTH_LONG)
                    .setAction("Evet",v1 ->{
                        viewModel.sil(is.getIs_id());
                    }).show();

        });
    }

    @Override
    public int getItemCount() {
        return yapilacaklarListesi.size();
    }
}
