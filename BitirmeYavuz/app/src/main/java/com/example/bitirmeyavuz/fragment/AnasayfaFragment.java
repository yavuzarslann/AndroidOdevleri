package com.example.bitirmeyavuz.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
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
import com.example.bitirmeyavuz.adapter.KategorilerAdapter;
import com.example.bitirmeyavuz.adapter.YemeklerAdapter;
import com.example.bitirmeyavuz.databinding.FragmentAnasayfaBinding;
import com.example.bitirmeyavuz.entity.Kategoriler;
import com.example.bitirmeyavuz.entity.Yemekler;
import com.example.bitirmeyavuz.viewmodel.AnasayfaFragmentViewModel;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.ArrayList;

public class AnasayfaFragment extends Fragment {
    private FragmentAnasayfaBinding tasarim;
    private AnasayfaFragmentViewModel viewModel;
    private SearchView searchView;
    private FirebaseAuth mAuth;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        tasarim = DataBindingUtil.inflate(inflater, R.layout.fragment_anasayfa, container, false);
        tasarim.setAnasayfaFragment(this);
        ((AppCompatActivity) getActivity()).setSupportActionBar(tasarim.toolbarAnasayfa);
        tasarim.setAnasayfaToolbarBaslik("");

        viewModel.yemeklerListesi.observe(getViewLifecycleOwner(), liste -> {
            YemeklerAdapter yemeklerAdapter = new YemeklerAdapter(requireContext(), liste);
            tasarim.setYemeklerAdapter(yemeklerAdapter);
        });

        tasarim.imageViewProfil.setOnClickListener(view -> {
            Navigation.findNavController(view).navigate(R.id.profilGecis);
        });

        //login
        mAuth = FirebaseAuth.getInstance();

        //arama
        /*tasarim.searchViewAnasayfa.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {

                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                viewModel.ara(newText);
                return true;
            }
        });*/

        ArrayList<Kategoriler> liste = new ArrayList<>();
        Kategoriler k1 = new Kategoriler(1, "Izgaralar", "izgara");
        Kategoriler k2 = new Kategoriler(2, "Pizzalar", "pizza");
        Kategoriler k3 = new Kategoriler(3, "İçecekler", "kahve");
        Kategoriler k4 = new Kategoriler(4, "Tatlılar", "tiramisu");
        Kategoriler k5 = new Kategoriler(5, "Burgerler", "hamburger");
        Kategoriler k6 = new Kategoriler(6, "Salatalar", "salata");
        liste.add(k1);
        liste.add(k2);
        liste.add(k3);
        liste.add(k4);
        liste.add(k5);
        liste.add(k6);
        KategorilerAdapter kategorilerAdapter = new KategorilerAdapter(requireContext(), liste);
        tasarim.setKategorilerAdapter(kategorilerAdapter);

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
        inflater.inflate(R.menu.main_menu, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    public void sepeteGecis(View view) {
        Navigation.findNavController(view).navigate(R.id.sepetGecis);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_sepete_git:
                sepeteGecis(requireView());
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }

    //login
    @Override
    public void onStart() {
        super.onStart();
        FirebaseUser user = mAuth.getCurrentUser();
        if (user == null) {
            Navigation.findNavController(requireView()).navigate(R.id.anaDanLogineGecis);
        }
    }
}