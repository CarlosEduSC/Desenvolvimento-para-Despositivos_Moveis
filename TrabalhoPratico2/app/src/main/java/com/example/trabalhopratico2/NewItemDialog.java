package com.example.trabalhopratico2;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.Adapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import java.util.ArrayList;
import java.util.List;

public class NewItemDialog extends DialogFragment implements DialogInterface.OnClickListener {

    private List<String> itemList;
    private ItemAdapter adapter;
    private EditText input;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof MainActivity) {
            MainActivity activity = (MainActivity) context;
            itemList = activity.getItemList();
            adapter = activity.getAdapter();
        }
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        input = new EditText(getActivity());

        builder.setTitle(R.string.add);
        builder.setView(input);
        builder.setPositiveButton(R.string.adicionar,this);
        builder.setNegativeButton(R.string.cancelar, this);

        return builder.create();
    }

    @Override
    public void onClick(DialogInterface dialogInterface, int i) {
        if (i == DialogInterface.BUTTON_POSITIVE){
            String newItem = input.getText().toString().trim();
            if (!newItem.isEmpty()) {
                adapter.addItem(newItem);
            }
        }
    }
}