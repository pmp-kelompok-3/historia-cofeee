package com.example.kelompok

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class DetailMenu : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_menu)

        val tvImage = findViewById<ImageView>(R.id.imageView)
        val tvItem = findViewById<TextView>(R.id.tv_item)
        val tvDesc = findViewById<TextView>(R.id.tv_deskripsi)

        val image = intent.getStringExtra(EXTRA_PHOTO)
        val name = intent.getStringExtra(EXTRA_NAME)
        val desc = intent.getStringExtra(EXTRA_DESC)

        tvItem.text = name
        tvDesc.text = desc
        Glide.with(this).load(image).apply(RequestOptions().override(300,300)).into(tvImage)
    }
    companion object{
        const val EXTRA_NAME = "extra_name"
        const val EXTRA_PHOTO = "extra_photo"
        const val EXTRA_DESC = "extra_desc"
    }
}