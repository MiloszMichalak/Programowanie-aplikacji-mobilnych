package com.example.generatorhasel;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            androidx.core.graphics.Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        TextView iloscznakow = findViewById(R.id.ilosc_znakow);
        SeekBar seekBar = findViewById(R.id.seekbar);

        CheckBox male = findViewById(R.id.male);
        CheckBox wielkie = findViewById(R.id.wielkie);
        CheckBox cyfry = findViewById(R.id.cyfry);
        CheckBox specjalne = findViewById(R.id.specjalne);

        Spinner spinner = findViewById(R.id.spinner);
        RadioGroup radioGroup = findViewById(R.id.radio_group);
        Switch switchBtn = findViewById(R.id.switchBtn);
        Button button = findViewById(R.id.button);
        TextView passwords = findViewById(R.id.passwords);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                iloscznakow.setText("Dlugosc hasla: " + i + " znakow");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        String maleLitery = "abcdefghijklmnopqrstuvwxyz";
        String wielkieLitery = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String cyfrylista = "0123456789";
        String znakiSpecjalne = "!@#$%^&*";

        button.setOnClickListener(view -> {
            int ilosc = seekBar.getProgress();
            boolean czyMale = male.isChecked();
            boolean czyWielkie = wielkie.isChecked();
            boolean czyCyfry = cyfry.isChecked();
            boolean czyZnaki = cyfry.isChecked();

            int pozycja = spinner.getSelectedItemPosition();
            int id = radioGroup.getCheckedRadioButtonId();
            boolean zapamietaj = switchBtn.isChecked();

            StringBuilder haslo = new StringBuilder();
            if(czyMale){
                haslo.append(maleLitery);
            }
            if(czyWielkie){
                haslo.append(wielkieLitery);
            }
            if(czyCyfry){
                haslo.append(cyfrylista);
            }
            if (czyZnaki){
                haslo.append(znakiSpecjalne);
            }
            if(haslo.length() == 0){
                Toast.makeText(this, "Wybierz co najmniej jedna opcje", Toast.LENGTH_SHORT).show();
                return;
            }

            for (int j = 0; j < ilosc; j++) {
                
            }

        });

    }
}
