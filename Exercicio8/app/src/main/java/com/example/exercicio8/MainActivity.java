package com.example.exercicio8;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lista = findViewById(R.id.lista);
        List<Times> times = Times.getTimes();
        TimesAdapter timesAdapter = new TimesAdapter(this, times);

        lista.setAdapter(timesAdapter);
    }
}