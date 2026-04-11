package com.example.plantsstoreapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class PlantAdapter(
    private val context: Context,
    private val plantas: List<Planta>,
    private val onCardClick: (Planta) -> Unit
) : RecyclerView.Adapter<PlantAdapter.PlantViewHolder>() {

    inner class PlantViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val imgCard:    ImageView   = view.findViewById(R.id.imgCard)
        val tvType:     TextView    = view.findViewById(R.id.type)
        val tvName:     TextView    = view.findViewById(R.id.name)
        val addCartBtn: ImageButton = view.findViewById(R.id.addCartBtn)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlantViewHolder {
        val v = LayoutInflater.from(parent.context)
            .inflate(R.layout.card_layout, parent, false)
        return PlantViewHolder(v)
    }

    override fun onBindViewHolder(holder: PlantViewHolder, position: Int) {
        val planta = plantas[position]

        holder.imgCard.setImageResource(planta.imagem)
        holder.tvType.text = planta.tipo
        holder.tvName.text = planta.nome

        // Botão adicionar à wishlist
        holder.addCartBtn.setOnClickListener {
            WishlistManager.toggle(context, planta.id)
        }

        // Clique no card abre detalhes
        holder.itemView.setOnClickListener { onCardClick(planta) }
    }

    override fun getItemCount(): Int = plantas.size
}
