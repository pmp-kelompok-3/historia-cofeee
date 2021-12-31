package com.example.kelompok

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.kelompok.adapters.MenuCoffeeAdapter
import com.example.kelompok.models.Coffee
import java.util.*
import kotlin.collections.ArrayList

class Home : AppCompatActivity(), OnClickListener {
    private lateinit var rvKopi: RecyclerView

    private val list = ArrayList<kopi>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        rvKopi = findViewById(R.id.rvKopi)
        rvKopi.setHasFixedSize(true)

        list.addAll(kopiData.listData)
        showRecyclerView()

        val btnShare : Button = findViewById(R.id.btnShare)
        btnShare.setOnClickListener(this)
        val message: String = "AYO NGOPI BLAY"

        val btnDial : Button = findViewById(R.id.buttonDIal)
        btnDial.setOnClickListener(this)
    }

     private fun replace(rvKopi: Int) {

     }

     private fun showRecyclerView() {
         rvKopi.layoutManager = LinearLayoutManager(this)
         val listkopiAdapter = kopiAdapter(list)
         rvKopi.adapter = MenuCoffeeAdapter()
         listkopiAdapter.setOnItemClickCallback(object : kopiAdapter.OnItemClickCallback {
             override fun onItemClicked(data: kopi) {
                showSelectedKopi(data)
             }
         })
    }

     private fun showSelectedKopi(kopi: kopi) {
//         Toast.makeText(this, "Kamu memilih " + kopi.name, Toast.LENGTH_SHORT).show()

         val moveWithDataIntent = Intent(this@Home, DetailMenu::class.java)
         moveWithDataIntent.putExtra(DetailMenu.EXTRA_NAME, kopi.name)
         moveWithDataIntent.putExtra(DetailMenu.EXTRA_DESC, kopi.deskripsi)
         moveWithDataIntent.putExtra(DetailMenu.EXTRA_PHOTO, kopi.photo)
         startActivity(moveWithDataIntent)
     }


     override fun onClick(p0: View) {
         when(p0.id){
             R.id.buttonDIal -> {
                 val phoneNumber = "082114395458"
                 val dialNumber = Intent(Intent.ACTION_DIAL, Uri.parse("tel:$phoneNumber"))
                 startActivity(dialNumber)
             }
             R.id.btnShare -> {
                 val pesan = "AYO NGOPI DI COFFE SHOP HISTORIA"
                 val intent = Intent(Intent.ACTION_SEND)
                 intent.type = "text/plain"
                 intent.putExtra("share this",pesan)

                 val chooser = Intent.createChooser(intent,"Share Kemana")
                 startActivity(chooser)
             }
         }
     }
 }







