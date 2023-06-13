package com.example.trabalhopratico2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class ItemAdapter extends ArrayAdapter<String> {
    private List<String> itemList;
    private Context context;

    public ItemAdapter(Context context, List<String> itemList) {
        super(context, 0, itemList);
        this.context = context;
        this.itemList = itemList;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.adapter_item, parent, false);
        }

        String item = itemList.get(position);

        TextView txtitem = convertView.findViewById(R.id.txtItem);
        txtitem.setText(item);

        return convertView;
    }

    public void addItem(String item) {
        itemList.add(item);
        notifyDataSetChanged();
    }

    public void editItem(int position, String newItem) {
        itemList.set(position, newItem);
        notifyDataSetChanged();
    }

    public void deleteItem(int position) {
        itemList.remove(position);
        notifyDataSetChanged();
    }
}
