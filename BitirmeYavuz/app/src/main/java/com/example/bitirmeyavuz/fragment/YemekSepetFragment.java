package com.example.bitirmeyavuz.fragment;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.bitirmeyavuz.R;
import com.example.bitirmeyavuz.adapter.SepetAdapter;
import com.example.bitirmeyavuz.databinding.FragmentYemekSepetBinding;
import com.example.bitirmeyavuz.viewmodel.YemekSepetFragmentViewModel;
import com.google.android.material.snackbar.Snackbar;

public class YemekSepetFragment extends Fragment {
    private FragmentYemekSepetBinding tasarim;
    private YemekSepetFragmentViewModel viewModel;

    private Integer eskiAdet;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        tasarim = DataBindingUtil.inflate(inflater, R.layout.fragment_yemek_sepet, container, false);
        tasarim.setSepetToolbarBaslik("");
        tasarim.setYemekSepetFragment(this);

        viewModel.sepetYemeklerListesi.observe(getViewLifecycleOwner(), liste -> {
            SepetAdapter sepetAdapter = new SepetAdapter(requireContext(), liste, viewModel);
            tasarim.setSepetAdapter(sepetAdapter);
        });


        //toplam fiyat hesaplama
        viewModel.toplamFiyatiAl().observe(getViewLifecycleOwner(), new Observer<Double>() {
            @Override
            public void onChanged(Double aDouble) {
                tasarim.textViewToplamTutar.setText("Sepet Toplamı: " + aDouble.toString() + " TL");
            }
        });

        tasarim.buttonSiparisiOnayla.setOnClickListener(view -> {
            Snackbar.make(view, "Siparişiniz Onaylandı", Snackbar.LENGTH_LONG).show();
        });

        tasarim.imageViewSepetGeri.setOnClickListener(view -> {
            Navigation.findNavController(view).navigate(R.id.sepettenAnaGecis);
        });

        //sepetteki tekrarı önleme
        /*viewModel.toplamAdetiAl().observe(getViewLifecycleOwner(), new Observer<Integer>() {
            @Override
            public void onChanged(Integer integer) {
                tasarim.textViewAdet.setText(integer.toString());
            }
        });*/

        return tasarim.getRoot();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel = new ViewModelProvider(this).get(YemekSepetFragmentViewModel.class);
    }

    public void buttonSepettenSilTikla(int sepet_yemek_id, String kullanici_adi) {
        viewModel.sepetYemekleriSil(sepet_yemek_id, kullanici_adi);
    }

    public Integer adetAl() {
        return eskiAdet;
    }
}