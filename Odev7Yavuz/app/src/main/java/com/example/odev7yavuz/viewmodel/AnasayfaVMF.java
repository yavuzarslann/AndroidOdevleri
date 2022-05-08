package com.example.odev7yavuz.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

public class AnasayfaVMF extends ViewModelProvider.NewInstanceFactory {
    private final Application application;

    public AnasayfaVMF(Application application) {
        this.application = application;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        return (T) new AnasayfaFragmentViewModel(application);
    }
}
