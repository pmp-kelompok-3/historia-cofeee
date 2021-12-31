package com.example.kelompok

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import com.example.kelompok.models.Coffee
import com.example.kelompok.stores.ListCoffee

class FormPembelian : AppCompatActivity() {

    //edit text
    lateinit var edtNama: EditText

    //spinner
    lateinit var spMenu: Spinner
    lateinit var spQty: Spinner

    //checkbox
    lateinit var cbHot: RadioButton
    lateinit var cbIce: RadioButton

    //button
    lateinit var btnSave: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_form_pembelian)

        var price: Double = 0.0
        var totalPrice: Double = 0.0

        spMenu = findViewById(R.id.sp_Menu)
        val coffeeAdapter = ArrayAdapter<Coffee>(this, R.layout.spinner_item, ListCoffee.items())
        spMenu.adapter = coffeeAdapter;

        spMenu.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(p0: AdapterView<*>, p1: View, p2: Int, p3: Long) {
                val selectedCoffee: Coffee = p0.selectedItem as Coffee
                price = selectedCoffee.price
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {

            }
        }

        edtNama = findViewById(R.id.ed_nama)

        cbHot = findViewById(R.id.cb_Hot)
        cbIce = findViewById(R.id.cb_Ice)
        spQty = findViewById(R.id.sp_Qty)
        btnSave = findViewById(R.id.btn_Saved)


        btnSave.setOnClickListener {
            totalPrice = price * spQty.selectedItem.toString().toInt()

            // Get Data from Checkbox
            val MenuVarian = StringBuilder()
            MenuVarian.append("")
            if (cbHot.isChecked) {
                MenuVarian.append( "" + cbHot.text )
            }
            if (cbIce.isChecked) {
                MenuVarian.append( "" + cbIce.text)
            }

            //Buka activity kedua dan kirim pakai intent explisit
            val intent = Intent(this, OutputPembeli::class.java)
                .apply {
                    putExtra("name", edtNama.text.toString())
                    putExtra("menu", spMenu.selectedItem.toString())
                    putExtra("variant", MenuVarian.toString())
                    putExtra("qty", spQty.selectedItem.toString())
                    putExtra("total", totalPrice.toString())
                    putExtra("Head", "Historia Coffee")
                }
            startActivity(intent)
        }
    }
}
