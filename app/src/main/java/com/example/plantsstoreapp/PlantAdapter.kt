package com.example.plantsstoreapp

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.plantsstoreapp.databinding.CardLayoutBinding

class PlantAdapter(
    private val context: Context,
    private val plantas: List<Planta>,
    private val onCardClick: (Planta) -> Unit
) : RecyclerView.Adapter<PlantAdapter.PlantViewHolder>() {

    inner class PlantViewHolder(val binding: CardLayoutBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlantViewHolder {
        val binding = CardLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PlantViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PlantViewHolder, position: Int) {
        val planta = plantas[position]
        val b = holder.binding

        b.imgCard.setImageResource(planta.imagem)
        b.type.text = planta.tipo
        b.name.text = planta.nome

        b.addCartBtn.setOnClickListener {
            val adicionou = WishlistManager.toggle(context, planta.id)
            val msg = if (adicionou) "${planta.nome} adicionado ao carrinho! 🛒"
                      else "${planta.nome} removido do carrinho."
            Toast.makeText(context, msg, Toast.LENGTH_SHORT).show()
        }

        holder.itemView.setOnClickListener { onCardClick(planta) }
    }

    override fun getItemCount(): Int = plantas.size
}
