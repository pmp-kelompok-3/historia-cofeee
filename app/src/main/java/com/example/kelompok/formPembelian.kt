package com.example.kelompok

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import java.text.SimpleDateFormat
import java.util.*

class formPembelian : AppCompatActivity() {

    //edit text
    lateinit var edtNama: EditText

    //spinner
    lateinit var spMenu: Spinner
    lateinit var spQty: Spinner

    //checkbox
    lateinit var cbHot: CheckBox
    lateinit var cbIce: CheckBox

    //button
    lateinit var btnSave: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_form_pembelian)

        edtNama = findViewById(R.id.ed_nama)
        spMenu = findViewById(R.id.sp_Menu)
        cbHot = findViewById(R.id.cb_Hot)
        cbIce = findViewById(R.id.cb_Ice)
        spQty = findViewById(R.id.sp_Qty)
        btnSave = findViewById(R.id.btn_Saved)



        btnSave.setOnClickListener {
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


            var name: String = "Name    :   " + nama
            var menu: String = "Menu   :   " + menuCoffee
            var varian: String = "Varian   :" + MenuVarian
            var qty: String = "Quantity    :" + quantity
            var total : String = "Total :"

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
            val intent = Intent(this@formPembelian, OutputPembeli::class.java)
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
