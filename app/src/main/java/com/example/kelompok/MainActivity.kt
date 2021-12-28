package com.example.kelompok

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var btnSignup: Button
    private lateinit var btnLogin: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnSignup = findViewById(R.id.btnSignup)
        btnSignup.setOnClickListener(this)

        btnLogin = findViewById(R.id.btnLogin)
        btnLogin.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.btnSignup -> {
                val intentSignup = Intent(this@MainActivity, MainActivity2::class.java)
                startActivity(intentSignup)
            }
            R.id.btnLogin -> {
                val intentSigin = Intent(this@MainActivity, MainActivityLognin::class.java)
                startActivity(intentSigin)
            }
        }
    }
}