package com.example.kelompok

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.kelompok.adapters.MenuCoffeeAdapter
import com.example.kelompok.models.Coffee

class Home : AppCompatActivity(), OnClickListener {
    private lateinit var rvKopi: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        rvKopi = findViewById(R.id.rvKopi)
        rvKopi.setHasFixedSize(true)

        showRecyclerView()

        val btnShare : Button = findViewById(R.id.btnShare)
        btnShare.setOnClickListener(this)
        val message: String = "AYO NGOPI BLAY"

        val btnDial : Button = findViewById(R.id.buttonDIal)
        btnDial.setOnClickListener(this)
    }

     private fun showRecyclerView() {
         rvKopi.layoutManager = LinearLayoutManager(this)

         val menuCoffeeAdapter = MenuCoffeeAdapter()
         rvKopi.adapter = menuCoffeeAdapter

         menuCoffeeAdapter.onClick = fun (coffee: Coffee) {
             val intent = Intent(this, DetailMenu::class.java)
             intent.putExtra(DetailMenu.EXTRA_NAME, coffee.name)
             intent.putExtra(DetailMenu.EXTRA_DESC, coffee.description)
             intent.putExtra(DetailMenu.EXTRA_PHOTO, coffee.image)
             startActivity(intent)
         }
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







