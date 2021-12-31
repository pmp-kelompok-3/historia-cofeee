package com.example.kelompok

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class OutputPembeli : AppCompatActivity() {

    lateinit var tvPesan: TextView
    lateinit var tvName: TextView
    lateinit var tvMenu: TextView
    lateinit var tvVarian: TextView
    lateinit var tvQty: TextView
    lateinit var tvTotal: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_output_pembeli)

        tvPesan = findViewById(R.id.tv_tampil_pesan)
        tvName = findViewById(R.id.tv_name)
        tvMenu = findViewById(R.id.tv_Cmenu)
        tvVarian = findViewById(R.id.tv_Varian)
        tvQty = findViewById(R.id.tv_Qty)
        tvTotal = findViewById(R.id.tv_Total)

        //Menerima data dari activity 1 melalui intent
        val intent = intent
        val head = intent.getStringExtra("Head")
        val name = intent.getStringExtra("name")
        val menu = intent.getStringExtra("menu")
        val variant = intent.getStringExtra("variant")
        val qty = intent.getStringExtra("qty")
        val total = intent.getStringExtra("total")

        tvPesan.text = head
        tvName.text = name
        tvMenu.text = menu
        tvVarian.text = variant
        tvQty.text = qty
        tvTotal.text = "Rp$total"

    }
}
