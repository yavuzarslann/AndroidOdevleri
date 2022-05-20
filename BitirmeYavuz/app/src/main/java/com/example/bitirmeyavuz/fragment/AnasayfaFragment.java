package com.example.bitirmeyavuz.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.example.bitirmeyavuz.R;
import com.example.bitirmeyavuz.adapter.YemeklerAdapter;
import com.example.bitirmeyavuz.databinding.FragmentAnasayfaBinding;
import com.example.bitirmeyavuz.entity.Yemekler;
import com.example.bitirmeyavuz.viewmodel.AnasayfaFragmentViewModel;

import java.util.ArrayList;

public class AnasayfaFragment extends Fragment {
    private FragmentAnasayfaBinding tasarim;
    private AnasayfaFragmentViewModel viewModel;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        tasarim = DataBindingUtil.inflate(inflater,R.layout.fragment_anasayfa, container, false);
        tasarim.setAnasayfaFragment(this);
        ((AppCompatActivity)getActivity()).setSupportActionBar(tasarim.toolbarAnasayfa);
        tasarim.setAnasayfaToolbarBaslik("Anasayfa");


        viewModel.yemeklerListesi.observe(getViewLifecycleOwner(),liste ->{
            YemeklerAdapter yemeklerAdapter = new YemeklerAdapter(requireContext(),liste);
            tasarim.setYemeklerAdapter(yemeklerAdapter);
        });



        return tasarim.getRoot();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel = new ViewModelProvider(this).get(AnasayfaFragmentViewModel.class);
        setHasOptionsMenu(true);
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        inflater.inflate(R.menu.main_menu,menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    public void sepeteGecis(View view){
        Navigation.findNavController(view).navigate(R.id.sepetGecis);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.action_sepete_git:
                sepeteGecis(requireView());
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }
}