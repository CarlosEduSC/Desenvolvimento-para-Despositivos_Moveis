package com.example.exercicio7;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements  ButtonsFragment.OnFragmentInteractionListener {

    private ResultFragment resultFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        resultFragment = (ResultFragment) getSupportFragmentManager().findFragmentById(R.id.fragResult);
    }


    @Override
    public void onFragmentInteraction(String text) {
        resultFragment.definirCor(text);
    }
}