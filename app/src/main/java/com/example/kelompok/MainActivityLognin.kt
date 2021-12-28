package com.example.kelompok

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class MainActivityLognin : AppCompatActivity() , View.OnClickListener {
    private lateinit var btnNext : Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_lognin)

        btnNext = findViewById(R.id.btnNext)
        btnNext.setOnClickListener(this)

    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.btnNext -> {
                val intentNext = Intent(this@MainActivityLognin, Home1::class.java)
                startActivity(intentNext)
            }
        }
    }
}