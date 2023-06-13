package com.example.exercicio2;

import static android.content.ContentValues.TAG;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText edtNome;
    private RadioGroup rgSexo;
    private RadioButton rbMasculino;
    private RadioButton rbFeminino;
    private EditText edtEmail;
    private EditText edtTelefone;
    private CheckBox cbMusica;
    private CheckBox cbCinema;
    private CheckBox cbEsporte;
    private CheckBox cbGastronomia;
    private Switch swNotificacoes;
    private Button btExibir;
    private Button btLimpar;
    private LinearLayout llDados;
    private TextView txtNome;
    private TextView txtSexo;
    private TextView txtEmail;
    private TextView txtTefone;
    private TextView txtPreferencias;
    private TextView txtNotificacoes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtNome = findViewById(R.id.edtNome);
        rgSexo = findViewById(R.id.rgSexo);
        rbMasculino = findViewById(R.id.rbMasculino);
        rbFeminino = findViewById(R.id.rbFeminino);
        edtEmail = findViewById(R.id.edtEmail);
        edtTelefone = findViewById(R.id.edtTelefone);
        cbMusica = findViewById(R.id.cbMusica);
        cbCinema = findViewById(R.id.cbCinema);
        cbEsporte = findViewById(R.id.cbEsporte);
        cbGastronomia = findViewById(R.id.cbGastronomia);
        swNotificacoes = findViewById(R.id.swNotificacoes);
        llDados = findViewById(R.id.llDados);
        btExibir = findViewById(R.id.btExibir);
        btLimpar = findViewById(R.id.btLimpar);
        txtNome = findViewById(R.id.txtNome);
        txtSexo = findViewById(R.id.txtSexo);
        txtEmail = findViewById(R.id.txtEmail);
        txtTefone = findViewById(R.id.txtTelefone);
        txtPreferencias = findViewById(R.id.txtPreferencias);
        txtNotificacoes = findViewById(R.id.txtNotificacoes);

        btExibir.setOnClickListener(this);
        btLimpar.setOnClickListener(this);

        Log.i(TAG, "Método onCreate() chamado:" + savedInstanceState);
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.btLimpar) {
            edtNome.setText(" ");
            rgSexo.clearCheck();
            edtEmail.setText("");
            edtTelefone.setText("");
            cbMusica.setChecked(false);
            cbCinema.setChecked(false);
            cbEsporte.setChecked(false);
            cbGastronomia.setChecked(false);
            swNotificacoes.setChecked(false);

            llDados.setVisibility(View.INVISIBLE);

        } else if (v.getId() == R.id.btExibir) {
            llDados.setVisibility(View.VISIBLE);

            txtNome.setText("Nome: " + edtNome.getText().toString());

            int IdRbSexo = rgSexo.getCheckedRadioButtonId();

            if (IdRbSexo > 0) {
                RadioButton rbSelecionado = findViewById(IdRbSexo);

                txtSexo.setText("Sexo: " + rbSelecionado.getText().toString());
            }

            txtEmail.setText("Email: " + edtEmail.getText().toString());
            txtTefone.setText("Telefone: " + edtTelefone.getText().toString());

            String pref= "";

            if (cbMusica.isChecked() == true) {
                pref += cbMusica.getText().toString() + " ";
            }

            if (cbCinema.isChecked() == true) {
                pref += cbCinema.getText().toString() + " ";
            }

            if (cbEsporte.isChecked() == true) {
                pref += cbEsporte.getText().toString() + " ";
            }

            if (cbGastronomia.isChecked() == true) {
                pref += cbGastronomia.getText().toString() + " ";
            }

            txtPreferencias.setText("Preferências: " + pref);

            if (swNotificacoes.isChecked() == true) {
                txtNotificacoes.setText("Notificações: " + swNotificacoes.getTextOn().toString());

            } else {
                txtNotificacoes.setText("Notificações: " + swNotificacoes.getTextOff().toString());
            }
        }
    }

    @Override
    protected void onStart() {
        super.onStart();

        Log.i(TAG, "Método onStart chamado:");
    }

    @Override
    protected void onResume() {
        super.onResume();

        Log.i(TAG, "Método onResume chamado:");
    }

    @Override
    protected void onPause() {
        super.onPause();

        Log.i(TAG, "Método onPause chamado:");
    }

    @Override
    protected void onStop() {
        super.onStop();

        Log.i(TAG, "Método onStop chamado:");
    }

    @Override
    protected void onRestart() {
        super.onRestart();

        Log.i(TAG, "Método onRestart chamado:");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        Log.i(TAG, "Método onDestroy chamado:");
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);

        Log.i(TAG, "Método onSavedInstanceState chamado:" + outState);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        Log.i(TAG, "Método onRestoreInstanceState chamado:" + savedInstanceState);
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {
        super.onPointerCaptureChanged(hasCapture);
    }
}