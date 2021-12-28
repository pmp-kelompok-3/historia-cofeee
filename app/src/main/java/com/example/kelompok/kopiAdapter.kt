package com.example.kelompok

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions


//import java.net.Authenticator

class kopiAdapter(private val listKopi: ArrayList<kopi>)  :RecyclerView.Adapter<kopiAdapter.CardViewViewHolder>() {
    private lateinit var onItemClickCallback: OnItemClickCallback

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback){
        this.onItemClickCallback = onItemClickCallback
        }

    inner class CardViewViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var imgPhoto: ImageView = itemView.findViewById(R.id.img_item1)
        var tvName: TextView = itemView.findViewById(R.id.tv_item_foto1)
        var tvDeskripsi: TextView = itemView.findViewById(R.id.tv_item_deskripsi)
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_card_foto1, parent, false)
        return CardViewViewHolder(view)
        }

    override fun getItemCount(): Int {
        return listKopi.size
        }

    override fun onBindViewHolder(holder: CardViewViewHolder, position: Int) {
        val kopi = listKopi[position]
        Glide.with(holder.itemView.context).load(kopi.photo).apply(RequestOptions()).into(holder.imgPhoto)
        holder.tvName.text = kopi.name
        holder.tvDeskripsi.text = kopi.deskripsi

        holder.itemView.setOnClickListener {
            onItemClickCallback.onItemClicked(listKopi[holder.adapterPosition]) }
        }

    interface OnItemClickCallback {
        fun onItemClicked(data: kopi)
        }
    }
