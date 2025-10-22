package com.example.challengelayoutkod;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import kotlin.text.Regex;

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

        EditText nameEditText = findViewById(R.id.nameEditText);
        EditText surnameEditText = findViewById(R.id.surnameEdiText);
        EditText passwordEditText = findViewById(R.id.passwordEditText);
        EditText confirmPasswordEditText = findViewById(R.id.confirmPasswordEditText);
        EditText emailEditText = findViewById(R.id.emailEditText);
        Button registerButton = findViewById(R.id.registerButton);
        Button helpButton = findViewById(R.id.helpBtn);

        CheckBox regulamin = findViewById(R.id.checkBox);

        RelativeLayout main = findViewById(R.id.main);


        registerButton.setOnClickListener(view -> {
            var name = nameEditText.getText().toString();
            var surname = surnameEditText.getText().toString();
            var password = passwordEditText.getText().toString();
            var confirmPassword = confirmPasswordEditText.getText().toString();
            var email = emailEditText.getText().toString();

            Regex nameRegex = new Regex("^[A-Z]{1}[a-z]{2,}$");
            Regex emailRegex = new Regex("^[A-Za-z0-9]+@[A-Za-z]+\\.[A-Za-z]{2,}$");

            if (name.isEmpty() || surname.isEmpty() || password.isEmpty() || confirmPassword.isEmpty() || email.isEmpty() ||
               !password.equals(confirmPassword) || !emailRegex.matches(email) || regulamin.isChecked() || password.length() < 6 ||
                    !nameRegex.matches(name) || !nameRegex.matches(surname)) {
                Toast.makeText(this, "BLAD DANYCH", Toast.LENGTH_SHORT).show();
                return;
            }
            Toast.makeText(this, name + ", " + surname + ", " + password + ", " + confirmPassword + ", " + email, Toast.LENGTH_SHORT).show();
        });

        helpButton.setOnClickListener(view -> {
            Toast.makeText(this, "CHYBA JESTES NIESPELNA ROZUMU?!?!?!?", Toast.LENGTH_SHORT).show();
            main.setBackgroundColor(Color.RED);
            helpButton.setBackgroundColor(Color.GREEN);
        });
    }
}