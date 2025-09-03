package com.example.firstapp;

import android.os.Bundle;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.button.MaterialButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        TextView nameEdittext = findViewById(R.id.name_input);
        String name = nameEdittext.getText().toString();

        SeekBar seekBar = findViewById(R.id.seekbar);

        TextView info = findViewById(R.id.info);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                switch (i) {
                    case 0:
                        info.setText("malo");
                        break;
                    case 1:
                        info.setText("srednio");
                        break;
                    case 2:
                        info.setText("duzo");
                        break;
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        MaterialButton sendButton = findViewById(R.id.button);
        sendButton.setOnClickListener(view -> {
            if (name.length() < 5) {
                nameEdittext.setError("IMIE MUSI MIEC PRZYNAJMNIEJ 5 ZNAKOW!!!");
            }
        });
    }
}