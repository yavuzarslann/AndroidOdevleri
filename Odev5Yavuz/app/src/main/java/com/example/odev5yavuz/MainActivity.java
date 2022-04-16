package com.example.odev5yavuz;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.odev5yavuz.databinding.ActivityMainBinding;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding tasarim;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        tasarim = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(tasarim.getRoot());

        ArrayList<String> sayilar = new ArrayList<>();//Butonlardan gelen sayıları Arraylist ile topluyorum

        tasarim.button0.setOnClickListener(view -> {
            String i = tasarim.textViewSonucEkrani.getText().toString();
            if (i == "0") {
                tasarim.textViewSonucEkrani.setText("");
            }
            tasarim.textViewSonucEkrani.setText(tasarim.textViewSonucEkrani.getText() + "0");
            sayilar.add("0");
        });

        tasarim.button1.setOnClickListener(view -> {
            String i = tasarim.textViewSonucEkrani.getText().toString();
            if (i == "0") {
                tasarim.textViewSonucEkrani.setText("");
            }
            tasarim.textViewSonucEkrani.setText(tasarim.textViewSonucEkrani.getText() + "1");
            sayilar.add("1");
        });

        tasarim.button2.setOnClickListener(view -> {
            String i = tasarim.textViewSonucEkrani.getText().toString();
            if (i == "0") {
                tasarim.textViewSonucEkrani.setText("");
            }
            tasarim.textViewSonucEkrani.setText(tasarim.textViewSonucEkrani.getText() + "2");
            sayilar.add("2");
        });

        tasarim.button3.setOnClickListener(view -> {
            String i = tasarim.textViewSonucEkrani.getText().toString();
            if (i == "0") {
                tasarim.textViewSonucEkrani.setText("");
            }
            tasarim.textViewSonucEkrani.setText(tasarim.textViewSonucEkrani.getText() + "3");
            sayilar.add("3");
        });

        tasarim.button4.setOnClickListener(view -> {
            String i = tasarim.textViewSonucEkrani.getText().toString();
            if (i == "0") {
                tasarim.textViewSonucEkrani.setText("");
            }
            tasarim.textViewSonucEkrani.setText(tasarim.textViewSonucEkrani.getText() + "4");
            sayilar.add("4");
        });

        tasarim.button5.setOnClickListener(view -> {
            String i = tasarim.textViewSonucEkrani.getText().toString();
            if (i == "0") {
                tasarim.textViewSonucEkrani.setText("");
            }
            tasarim.textViewSonucEkrani.setText(tasarim.textViewSonucEkrani.getText() + "5");
            sayilar.add("5");
        });

        tasarim.button6.setOnClickListener(view -> {
            String i = tasarim.textViewSonucEkrani.getText().toString();
            if (i == "0") {
                tasarim.textViewSonucEkrani.setText("");
            }
            tasarim.textViewSonucEkrani.setText(tasarim.textViewSonucEkrani.getText() + "6");
            sayilar.add("6");
        });

        tasarim.button7.setOnClickListener(view -> {
            String i = tasarim.textViewSonucEkrani.getText().toString();
            if (i == "0") {
                tasarim.textViewSonucEkrani.setText("");
            }
            tasarim.textViewSonucEkrani.setText(tasarim.textViewSonucEkrani.getText() + "7");
            sayilar.add("7");
        });
        tasarim.button8.setOnClickListener(view -> {
            String i = tasarim.textViewSonucEkrani.getText().toString();
            if (i == "0") {
                tasarim.textViewSonucEkrani.setText("");
            }
            tasarim.textViewSonucEkrani.setText(tasarim.textViewSonucEkrani.getText() + "8");
            sayilar.add("8");
        });

        tasarim.button9.setOnClickListener(view -> {
            String i = tasarim.textViewSonucEkrani.getText().toString();
            if (i == "0") {
                tasarim.textViewSonucEkrani.setText("");
            }
            tasarim.textViewSonucEkrani.setText(tasarim.textViewSonucEkrani.getText() + "9");
            sayilar.add("9");
        });

        tasarim.buttonTopla.setOnClickListener(view -> {
            String i = tasarim.textViewSonucEkrani.getText().toString();
            if (i == "0") {
                tasarim.textViewSonucEkrani.setText("");
            }
            tasarim.textViewSonucEkrani.setText(tasarim.textViewSonucEkrani.getText() + "+");
            sayilar.add("+");
        });

        tasarim.buttonEsittir.setOnClickListener(view -> {
            try {
                String sayilarString = "";//String Arraylist i String e çeviriyorum
                for (String s : sayilar) {
                    sayilarString += s;
                }
                String[] s = sayilarString.split("\\+");
                String s1 = s[0];
                String s2 = s[1];
                int sayi1 = Integer.parseInt(s1);
                int sayi2 = Integer.parseInt(s2);
                int toplam = sayi1 + sayi2;
                tasarim.textViewSonucEkrani.setText(String.valueOf(toplam));

            }catch(Exception e){
                if(e instanceof ArithmeticException){
                }
            }
        });

        tasarim.buttonSifirla.setOnClickListener(view -> {
            sayilar.clear();
            tasarim.textViewSonucEkrani.setText("0");
        });

    }
}