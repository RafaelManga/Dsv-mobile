package com.example.plantsstoreapp

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.plantsstoreapp.databinding.CardWishlistBinding

class WishlistAdapter(
    private val context: Context,
    private val plantas: MutableList<Planta>,
    private val onCardClick: (Planta) -> Unit,
    private val onRemover: (Planta) -> Unit
) : RecyclerView.Adapter<WishlistAdapter.WishlistViewHolder>() {

    inner class WishlistViewHolder(val binding: CardWishlistBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WishlistViewHolder {
        val binding = CardWishlistBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return WishlistViewHolder(binding)
    }

    override fun onBindViewHolder(holder: WishlistViewHolder, position: Int) {
        val planta = plantas[position]
        val b = holder.binding

        b.imgCard.setImageResource(planta.imagem)
        b.type.text    = planta.tipo
        b.name.text    = planta.nome
        b.tvPreco.text = "R$ ${"%.2f".format(planta.preco)}"

        b.btnRemover.setOnClickListener { onRemover(planta) }
        holder.itemView.setOnClickListener { onCardClick(planta) }
    }

    override fun getItemCount(): Int = plantas.size
}
