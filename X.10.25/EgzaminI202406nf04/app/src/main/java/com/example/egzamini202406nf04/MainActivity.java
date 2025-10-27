package com.example.egzamini202406nf04;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.DrawableRes;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

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

        Button resetBtn = findViewById(R.id.resetBtn);
        Button throwBtn = findViewById(R.id.throwBtn);
        ImageView[] diceImageViews = {
                findViewById(R.id.imageview1),
                findViewById(R.id.imageview2),
                findViewById(R.id.imageview3),
                findViewById(R.id.imageview4),
                findViewById(R.id.imageview5)
        };

        TextView diceResult = findViewById(R.id.diceResult);
        TextView gameResult = findViewById(R.id.gameResult);

        int[] wyniki = new int[6];
        int suma = 0;

        throwBtn.setOnClickListener(v -> {
            Arrays.fill(wyniki, 0);
            Random random = new Random();
            for (int i = 0; i < 5; i++) {
                int number = random.nextInt(6) + 1;
                wyniki[number - 1]++;
                diceImageViews[i].setImageResource(imageWrapper(number));
            }
            gameResult.setText("Wynik gry: " + result(wyniki));
        });
    }

    public int imageWrapper(int a) {
        return switch (a) {
            case 1 -> R.drawable.k1;
            case 2 -> R.drawable.k2;
            case 3 -> R.drawable.k3;
            case 4 -> R.drawable.k4;
            case 5 -> R.drawable.k5;
            case 6 -> R.drawable.k6;
            default -> R.drawable.question;
        };
    }

    public int result(int[] tab){
        int suma = 0;
        for(int i = 0; i < tab.length; i++){
            if(tab[i] > 1){
                suma += (i + 1) * tab[i];
            }
        }
        return suma;
    }
}