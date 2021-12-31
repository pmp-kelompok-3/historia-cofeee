package com.example.kelompok.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.kelompok.R
import com.example.kelompok.models.Coffee
import com.example.kelompok.stores.ListCoffee

interface MenuAdapterProps {
    fun onClick(coffee: Coffee)
}

class MenuCoffeeAdapter : RecyclerView.Adapter<MenuCoffeeAdapter.CardViewViewHolder>() {
    private lateinit var props: MenuAdapterProps;

    lateinit var onClick: (coffee: Coffee) -> Unit;

    inner class CardViewViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var image: ImageView = itemView.findViewById(R.id.img_item1)
        var textViewName: TextView = itemView.findViewById(R.id.tv_item_foto1)
        var textViewDeskripsi: TextView = itemView.findViewById(R.id.tv_item_deskripsi)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_card_foto1, parent, false);
        return CardViewViewHolder(view);
    }

    override fun onBindViewHolder(holder: CardViewViewHolder, position: Int) {
        val coffee = ListCoffee.items()[position]

        Glide.with(holder.itemView.context).load(coffee.image).apply(RequestOptions()).into(holder.image)

        holder.also {
            it.textViewName.text = coffee.name
            it.textViewDeskripsi.text = coffee.description

            holder.itemView.setOnClickListener {
                this.onClick(coffee)
            }
        }
    }

    override fun getItemCount(): Int {
        return ListCoffee.items().size;
    }
}