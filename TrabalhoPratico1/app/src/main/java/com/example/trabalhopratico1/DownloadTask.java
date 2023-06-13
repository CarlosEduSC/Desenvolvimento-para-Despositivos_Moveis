package com.example.trabalhopratico1;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class DownloadTask extends AsyncTask<String, Integer, String> {
    private ProgressBar progressBar;
    private ImageView img;

    public DownloadTask(ProgressBar progressBar, ImageView img) {
        this.progressBar = progressBar;
        this.img = img;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    protected String doInBackground(String... params) {
        String imageUrl = params[0];
        try {
            URL url = new URL(imageUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.connect();

            int fileLength = connection.getContentLength();

            InputStream input = new BufferedInputStream(url.openStream());
            FileOutputStream output = MainActivity.getInstance().openFileOutput("downloaded_image.jpg", Context.MODE_PRIVATE);

            byte[] data = new byte[1024];
            long total = 0;
            int count;

            while ((count = input.read(data)) != -1) {
                total += count;
                publishProgress((int) (total * 100 / fileLength));
                output.write(data, 0, count);
            }

            output.flush();
            output.close();
            input.close();

            return "Download concluído";

        } catch (IOException e) {
            e.printStackTrace();
            return "Erro ao baixar a imagem";
        }
    }

    @Override
    protected void onProgressUpdate(Integer... progress) {
        super.onProgressUpdate(progress);
        progressBar.setProgress(progress[0]);
    }

    @Override
    protected void onPostExecute(String result) {
        super.onPostExecute(result);
        progressBar.setVisibility(View.INVISIBLE);
        Toast.makeText(MainActivity.getInstance(), result, Toast.LENGTH_SHORT).show();

        // Exibir a imagem baixada no ImageView
        String imagePath = MainActivity.getInstance().getFilesDir().getAbsolutePath() + "/downloaded_image.jpg";
        Bitmap bitmap = BitmapFactory.decodeFile(imagePath);
        img.setImageBitmap(bitmap);


    }
}
