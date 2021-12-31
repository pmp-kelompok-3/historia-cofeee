package com.example.kelompok.stores

import com.example.kelompok.R
import com.example.kelompok.models.Coffee
import java.util.*

class ListCoffee {
    companion object {
        fun items(): MutableList<Coffee> {
            val coffees = mutableListOf<Coffee>(
                Coffee(
                    id = UUID.randomUUID().toString(),
                    name = "Matcha Latte",
                    description = "Pure Matcha extract with fresh milk is the perfect\n beverge for everday activity",
                    price = 20000.0,
                    image = R.drawable.matcha_coffee
                ),
                Coffee(
                    id = UUID.randomUUID().toString(),
                    name = "Red Velvet Latte",
                    description = "Red velvet cake in forms of liquid ? its the sweetest\n available option not gonna lie !",
                    price = 20000.0,
                    image = R.drawable.matcha_coffee
                ),
                Coffee(
                    id = UUID.randomUUID().toString(),
                    name = "Hazelnut",
                    description = "Expresso and milk with Hazelnut is our best seller!\n Well, who doesnt love its unique flavor ?",
                    price = 20000.0,
                    image = R.drawable.matcha_coffee
                )
            );

            return coffees;
        }
    }

}