package com.example.mu_sayfa319_sirasizde;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText editTextAd, editTextSoyad;
    Button buttonKaydet;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextAd = findViewById(R.id.editTextAd);
        editTextSoyad = findViewById(R.id.editTextSoyad);
        buttonKaydet = findViewById(R.id.buttonKaydet);

        sharedPreferences = getSharedPreferences("veriler", MODE_PRIVATE);

        // Verileri Yükleme
        editTextAd.setText(sharedPreferences.getString("ad", ""));
        editTextSoyad.setText(sharedPreferences.getString("soyad", ""));

        buttonKaydet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ad = editTextAd.getText().toString();
                String soyad = editTextSoyad.getText().toString();

                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("ad", ad);
                editor.putString("soyad", soyad);
                editor.apply();
            }
        });
    }
}