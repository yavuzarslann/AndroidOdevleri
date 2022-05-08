package com.example.odev7yavuz.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.example.odev7yavuz.R;
import com.example.odev7yavuz.adapter.YapilacakAdapter;
import com.example.odev7yavuz.databinding.FragmentAnasayfaBinding;
import com.example.odev7yavuz.entity.Yapilacaklar;
import com.example.odev7yavuz.viewmodel.AnasayfaFragmentViewModel;
import com.example.odev7yavuz.viewmodel.AnasayfaVMF;

import java.util.ArrayList;

public class AnasayfaFragment extends Fragment implements SearchView.OnQueryTextListener {
    private FragmentAnasayfaBinding tasarim;
    private AnasayfaFragmentViewModel viewModel;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        tasarim = DataBindingUtil.inflate(inflater, R.layout.fragment_anasayfa,container, false);
        tasarim.setAnasayfaFragment(this);
        tasarim.setAnasayfaToolbarBaslik("Yapılacaklar");
        ((AppCompatActivity) getActivity()).setSupportActionBar(tasarim.toolbarAnasayfa);

        viewModel.yapilacakListesi.observe(getViewLifecycleOwner(),liste -> {
            YapilacakAdapter adapter = new YapilacakAdapter(requireContext(),liste,viewModel);
            tasarim.setYapilacakAdapter(adapter);
        });


        return tasarim.getRoot();
    }

    public void fabTikla(View view){
        Navigation.findNavController(view).navigate(R.id.isKayitGecis);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
        viewModel = new ViewModelProvider(this,
                new AnasayfaVMF(requireActivity().getApplication())).get(AnasayfaFragmentViewModel.class);
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        inflater.inflate(R.menu.toolbar_menu, menu);

        MenuItem item = menu.findItem(R.id.action_ara);
        SearchView searchView = (SearchView) item.getActionView();
        searchView.setOnQueryTextListener(this);

        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        viewModel.ara(query);
        return true;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        viewModel.ara(newText);
        return true;
    }

    @Override
    public void onResume() {
        super.onResume();
        viewModel.yapilacakYukle();
    }
}