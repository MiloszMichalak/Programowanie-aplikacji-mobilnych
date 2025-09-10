package com.example.pierwszetestywmobilce;

import static com.example.pierwszetestywmobilce.Liczby.nwd;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textview.MaterialTextView;

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

        EditText inputA = findViewById(R.id.number_input2);
        EditText inputB = findViewById(R.id.number_input);
        MaterialButton button = findViewById(R.id.calculate_button);

        button.setOnClickListener(view -> {
            Toast.makeText(this, String.valueOf(nwd(Integer.parseInt(inputA.getText().toString()), Integer.parseInt(inputB.getText().toString()))), Toast.LENGTH_SHORT).show();
        });
    }


}