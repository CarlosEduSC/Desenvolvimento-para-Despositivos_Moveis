package com.example.exercicio8;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

public class TimesAdapter extends BaseAdapter {
    private final Context context;
    private final List<Times> times;

    public TimesAdapter(Context context, List<Times> times) {
        this.context = context;
        this.times = times;
    }


    @Override
    public int getCount() {
        return times.size();
    }

    @Override
    public Object getItem(int i) {
        return times.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View v = LayoutInflater.from(context).inflate(R.layout.adapter_times, viewGroup, false);

        ImageView img = (ImageView) v.findViewById(R.id.imgPlaneta);
        TextView nome = (TextView) v.findViewById(R.id.txtTimes);
        TextView titulos = (TextView) v.findViewById(R.id.txtTitulos);

        Times time = times.get(i);
        img.setImageResource(time.img);
        nome.setText(time.name);
        titulos.setText(time.titulos + " títulos");

        return v;
    }
}
