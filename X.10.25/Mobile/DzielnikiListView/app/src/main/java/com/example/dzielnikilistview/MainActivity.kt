package com.example.dzielnikilistview

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    lateinit var button: Button
    lateinit var listView: ListView
    lateinit var editText: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        button = findViewById(R.id.btn)
        listView = findViewById(R.id.listView)
        editText = findViewById(R.id.EditText)


        button.setOnClickListener() {
            val n = editText.text.toString().toInt()
            val dzielniki = policzDzielniki(n)
            listView.adapter = ArrayAdapter(this, R.layout.listitem, R.id.textview, dzielniki)
        }
    }


    fun policzDzielniki(n: Int): List<Int> {
        val dzielniki = mutableListOf<Int>()
        for (i in 1 .. n) {
            if (n % i == 0) {
                dzielniki.add(i)
            }
        }
        return dzielniki
    }
}