package com.example.kelompok

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import com.example.kelompok.models.Coffee
import java.util.*

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

        val coffees = mutableListOf<Coffee>(
            Coffee(
                id = UUID.randomUUID().toString(),
                name = "Matcha Latte",
                description = "Pure Matcha extract with fresh milk is the perfect\n beverge for everday activity",
                price = 20000.0,
            ),
            Coffee(
                id = UUID.randomUUID().toString(),
                name = "Red Velvet Latte",
                description = "Red velvet cake in forms of liquid ? its the sweetest\n available option not gonna lie !",
                price = 20000.0,
            ),
            Coffee(
                id = UUID.randomUUID().toString(),
                name = "Hazelnut",
                description = "Expresso and milk with Hazelnut is our best seller!\n Well, who doesnt love its unique flavor ?",
                price = 20000.0,
            )
        );

        spMenu = findViewById(R.id.sp_Menu)
        val coffeeAdapter = ArrayAdapter<Coffee>(this, R.layout.spinner_item, coffees)
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
            totalPrice = price * spQty.selectedItem.toString().toDouble();

            // Get Data from Checkbox
            val MenuVarian = StringBuilder()
            MenuVarian.append("")
            if (cbHot.isChecked) {
                MenuVarian.append( "" + cbHot.text )
            }
            if (cbIce.isChecked) {
                MenuVarian.append( "" + cbIce.text)
            }

            //Get data from spinner
            val menuCoffee: String = spMenu.selectedItem.toString()
            val quantity: String = spQty.selectedItem.toString()

            //Get data from EditTaext
            val nama: String = edtNama.text.toString()

            //Get nilai total


            var name: String = "Name\t:   " + nama
            var menu: String = "Menu\t:" + menuCoffee
            var varian: String = "Varian\t:" + MenuVarian
            var qty: String = "Quantity\t:" + quantity
            var total : String = "Total\t: ${price * quantity.toDouble()}"

//             Set all Value to variabel
//            Toast.makeText(this, menuCoffee,
//                Toast.LENGTH_LONG).show()
//            Toast.makeText(this, name,
//                Toast.LENGTH_LONG).show()
//            Toast.makeText(this, varian,
//                Toast.LENGTH_LONG).show()
//            Toast.makeText(this, quantity,
//                Toast.LENGTH_LONG).show()

            //Buka activity kedua dan kirim pakai intent explisit
            val intent = Intent(this@FormPembelian, OutputPembeli::class.java)
                .apply {
                    putExtra("nama", name)
                    putExtra("menu", menu)
                    putExtra("varian", varian)
                    putExtra("qty", qty)
                    putExtra("total", total)
                    putExtra("Head", "Historia Coffee")
                }
            startActivity(intent)
        }
    }
}
