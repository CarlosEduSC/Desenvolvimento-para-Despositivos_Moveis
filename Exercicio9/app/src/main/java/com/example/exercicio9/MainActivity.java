package com.example.exercicio9;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.time.LocalDate;
import java.time.LocalTime;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView txtData = findViewById(R.id.txtData);
        txtData.setText(LocalDate.now().getDayOfMonth() + "/" + LocalDate.now().getMonthValue() + "/" + LocalDate.now().getYear());

        TextView txtHora = findViewById(R.id.txtHora);
        txtHora.setText(LocalTime.now().getHour() + ":" + LocalTime.now().getMinute());
    }

    public void openDialogData(View view) {
        DialogDatePicker dialogDatePicker = new DialogDatePicker();
        dialogDatePicker.show(getSupportFragmentManager(), "data");
    }

    public void openDialogHora(View view) {
        DialogTimePicker dialogTimePicker = new DialogTimePicker();
        dialogTimePicker.show(getSupportFragmentManager(), "hora");
    }
}