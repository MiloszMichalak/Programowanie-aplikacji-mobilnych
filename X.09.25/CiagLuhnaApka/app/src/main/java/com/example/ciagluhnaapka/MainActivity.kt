package com.example.ciagluhnaapka

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        var kod = ""

        val losujBtn = findViewById<android.widget.Button>(R.id.losujBtn)
        var wylosowanyKod = findViewById<android.widget.EditText>(R.id.wylosowanyKodEditText)
        var sprawdzBtn = findViewById<android.widget.Button>(R.id.sprawdzBtn)
        var wyliczonyKod = findViewById<android.widget.EditText>(R.id.wyliczonyKodEditText)

        val luhna = Luhna()

        losujBtn.setOnClickListener {
            kod = (1_000_000_000_000_000..9_999_999_999_999_999).random().toString()
            wylosowanyKod.setText(kod)
        }

        sprawdzBtn.setOnClickListener {
            val wyliczony = luhna.sumaMnozona(kod)
            val poprawnosc = luhna.czyPoprawny(wyliczony).toString()
            wyliczonyKod.setText("Suma: $wyliczony, Poprawny: $poprawnosc")
        }
    }
}