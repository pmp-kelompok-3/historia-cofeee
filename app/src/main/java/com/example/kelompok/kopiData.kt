package com.example.kelompok

object kopiData {

    private val kopiNames = arrayOf(
        "Matcha Latte",
        "Red Velvet Latte",
        "Hazelnut"
    )

    private val kopiDesk = arrayOf(
        "Pure Matcha extract with fresh milk is the perfect\n beverge for everday activity",
        "Red velvet cake in forms of liquid ? its the sweetest\n available option not gonna lie !",
        "Expresso and milk with Hazelnut is our best seller!\n Well, who doesnt love its unique flavor ?"
    )

    private val kopiPhoto = arrayOf(
        R.drawable.kopi,
        R.drawable.kopiii,
        R.drawable.kopii
    )

    val listData: ArrayList<kopi>
    get() {
         var list = arrayListOf<kopi>()
        for (position in kopiNames.indices){
            val kopi = kopi()
            kopi.name = kopiNames[position]
            kopi.deskripsi = kopiDesk[position]
            kopi.photo = kopiPhoto[position]
            list.add(kopi)
        }
        return list
    }
}