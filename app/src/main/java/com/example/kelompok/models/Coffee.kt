package com.example.kelompok.models

data class Coffee (
    val id: String,
    val name: String,
    val description: String,
    val price: Double,
    val image: Int
) {
    override fun toString(): String {
        return this.name;
    }
}