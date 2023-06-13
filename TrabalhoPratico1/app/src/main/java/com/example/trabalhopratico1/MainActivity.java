package com.example.trabalhopratico1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private static MainActivity instance;
    private EditText edtLink;
    private Button btExibir;
    private ProgressBar progressBar;
    private ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        instance = this;

        edtLink = findViewById(R.id.edtLink);
        btExibir = findViewById(R.id.btExibir);
        progressBar = findViewById(R.id.progressBar);
        img = findViewById(R.id.img);

        btExibir.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        String imageUrl = edtLink.getText().toString();
        if (!imageUrl.isEmpty()) {
            DownloadTask downloadTask = new DownloadTask(progressBar, img);
            downloadTask.execute(imageUrl);
        } else {
            Toast.makeText(MainActivity.this, "Digite o link da imagem", Toast.LENGTH_SHORT).show();
        }
    }

    public static MainActivity getInstance() {
        return instance;
    }
}