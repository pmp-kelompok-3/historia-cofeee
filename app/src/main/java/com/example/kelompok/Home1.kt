package com.example.kelompok

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView

class Home1 : AppCompatActivity(), View.OnClickListener {
    private lateinit var cv_home : Button
    private lateinit var cv_shop : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home1)

        cv_home = findViewById(R.id.cv_home)
        cv_home.setOnClickListener(this)

        cv_shop = findViewById(R.id.cv_shop)
        cv_shop.setOnClickListener(this)


    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.cv_home -> {
                val intentCvHome1 = Intent(this@Home1, Home::class.java)
                startActivity(intentCvHome1)
            }
            R.id.cv_shop -> {
                val intentSigin = Intent(this@Home1, formPembelian::class.java)
                startActivity(intentSigin)
            }
        }
    }
}

