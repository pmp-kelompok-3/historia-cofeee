package com.example.kelompok

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import com.example.kelompok.R.id.btnSave

class MainActivity2 : AppCompatActivity(), View.OnClickListener {

    private lateinit var btnSave: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        btnSave = findViewById(R.id.btnSave)
        btnSave.setOnClickListener(this)
  }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.btnSave -> {
                val intentSave = Intent(this@MainActivity2, MainActivityLognin::class.java)
                startActivity(intentSave)
            }
        }
    }
}