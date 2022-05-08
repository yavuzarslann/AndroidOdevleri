package com.example.odev7yavuz.fragments;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.odev7yavuz.R;
import com.example.odev7yavuz.databinding.FragmentDetayBinding;
import com.example.odev7yavuz.entity.Yapilacaklar;
import com.example.odev7yavuz.viewmodel.DetayFragmentViewModel;
import com.example.odev7yavuz.viewmodel.DetayVMF;

public class DetayFragment extends Fragment {
    private FragmentDetayBinding tasarim;
    private DetayFragmentViewModel viewModel;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        tasarim = DataBindingUtil.inflate(inflater, R.layout.fragment_detay, container, false);
        tasarim.setDetayFragment(this);
        tasarim.setDetayToolbarBaslik("Yapılacak İş Detay");

        DetayFragmentArgs bundle = DetayFragmentArgs.fromBundle(getArguments());
        Yapilacaklar gelenIs = bundle.getIs();
        tasarim.setYapilacakNesnesi(gelenIs);

        return tasarim.getRoot();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel = new ViewModelProvider(this,
                new DetayVMF(requireActivity().getApplication())).get(DetayFragmentViewModel.class);
    }

    public void buttonGuncelle(int is_id, String is_adi) {
        viewModel.guncelle(is_id,is_adi);
    }
}