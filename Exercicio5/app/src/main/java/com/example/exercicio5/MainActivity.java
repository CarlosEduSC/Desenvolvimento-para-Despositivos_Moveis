package com.example.exercicio5;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btIniciar;
    private TextView txtContador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btIniciar = findViewById(R.id.btIniciar);
        txtContador = findViewById(R.id.txtContador);

        btIniciar.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        ProcessarTask task = new ProcessarTask(this);
        task.execute();
    }

    public void atualizarContador(int contador) {
        txtContador.setText(String.valueOf(contador));
    }

    public void desabilitarBotao() {
        btIniciar.setEnabled(false);
        txtContador.setVisibility(View.VISIBLE);
    }

    public void habilitarBotao() {
        btIniciar.setEnabled(true);
        txtContador.setVisibility(View.INVISIBLE);
    }
}