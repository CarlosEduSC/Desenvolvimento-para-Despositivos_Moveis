package com.example.exercicio5;

import android.os.AsyncTask;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

public class ProcessarTask extends AsyncTask <Integer, Integer, Void> {

    private MainActivity activity;

    public ProcessarTask(MainActivity activity) {
        this.activity = activity;
    }

    @Override
    protected Void doInBackground(Integer... integers) {
        for (int i = 10; i >= 0; i--) {
            publishProgress(i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);
        int contador = values[0];
        activity.atualizarContador(contador);
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
        activity.habilitarBotao();
        activity.atualizarContador(0);
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        activity.desabilitarBotao();
    }

}
