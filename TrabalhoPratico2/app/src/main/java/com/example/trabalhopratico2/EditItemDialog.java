package com.example.trabalhopratico2;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import java.util.ArrayList;
import java.util.List;

public class EditItemDialog extends DialogFragment implements DialogInterface.OnClickListener{
    private static final String ARG_POSITION = "position";
    private static final String ARG_ITEM_LIST = "itemList";

    private List<String> itemList;
    private ItemAdapter adapter;
    private EditText input;
    private int position;

    public static EditItemDialog newInstance(int position, List<String> itemList) {
        EditItemDialog dialog = new EditItemDialog();
        Bundle args = new Bundle();
        args.putInt(ARG_POSITION, position);
        args.putStringArrayList(ARG_ITEM_LIST, new ArrayList<>(itemList));
        dialog.setArguments(args);
        return dialog;
    }

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
        if (getArguments() != null) {
            position = getArguments().getInt(ARG_POSITION);
            itemList = getArguments().getStringArrayList(ARG_ITEM_LIST);
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        input = new EditText(getActivity());
        input.setText(itemList.get(position));
        builder.setTitle(R.string.edit);
        builder.setView(input);
        builder.setPositiveButton(R.string.editar,this);
        builder.setNegativeButton(R.string.cancelar, this);

        return builder.create();
    }

    @Override
    public void onClick(DialogInterface dialogInterface, int i) {
        if (i == DialogInterface.BUTTON_POSITIVE){
            adapter.editItem(position, input.getText().toString());
        }
    }
}
