package com.example.exercicio9;

import android.app.Dialog;
import android.app.TimePickerDialog;
import android.os.Build;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.TimePicker;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.Calendar;
import java.util.Locale;

public class DialogTimePicker extends DialogFragment implements TimePickerDialog.OnTimeSetListener {
    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        return new TimePickerDialog(getActivity(),this, LocalTime.now().getHour(), LocalTime.now().getMinute(), false);
    }

    @Override
    public void onTimeSet(TimePicker timePicker, int i, int i1) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR, i);
        calendar.set(Calendar.MINUTE, i1);

        SimpleDateFormat formato = new SimpleDateFormat("HH:mm", Locale.getDefault());

        String horaFormatada = formato.format(calendar.getTime());

        TextView txtHora = getActivity().findViewById(R.id.txtHora);

        txtHora.setText(horaFormatada);
    }
}
