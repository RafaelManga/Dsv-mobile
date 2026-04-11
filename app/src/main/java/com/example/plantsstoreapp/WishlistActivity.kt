package com.example.plantsstoreapp

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.plantsstoreapp.databinding.ActivityWishlistBinding

class WishlistActivity : AppCompatActivity() {

    private lateinit var binding: ActivityWishlistBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityWishlistBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.wishlistRecycler.layoutManager = LinearLayoutManager(this)

        loadWishlist()

        binding.btnClearWishlist.setOnClickListener {
            WishlistManager.clear(this)
            Toast.makeText(this, "Lista de desejos limpa!", Toast.LENGTH_SHORT).show()
            loadWishlist()
        }

        binding.btnBack.setOnClickListener { finish() }
    }

    private fun loadWishlist() {
        val savedIds   = WishlistManager.getWishlist(this)
        val wishPlants = PlantRepository.todas().filter { it.id in savedIds }.toMutableList()

        val total = wishPlants.sumOf { it.preco }
        binding.tvTotal.text = "Total: R$ ${"%.2f".format(total)}"

        if (wishPlants.isEmpty()) {
            binding.tvEmpty.visibility           = View.VISIBLE
            binding.wishlistRecycler.visibility  = View.GONE
            binding.btnClearWishlist.visibility  = View.GONE
            binding.tvTotal.visibility           = View.GONE
        } else {
            binding.tvEmpty.visibility           = View.GONE
            binding.wishlistRecycler.visibility  = View.VISIBLE
            binding.btnClearWishlist.visibility  = View.VISIBLE
            binding.tvTotal.visibility           = View.VISIBLE

            binding.wishlistRecycler.adapter = WishlistAdapter(
                context     = this,
                plantas     = wishPlants,
                onCardClick = { planta -> showPlantDialog(planta) },
                onRemover   = { planta ->
                    WishlistManager.toggle(this, planta.id)
                    Toast.makeText(this, "${planta.nome} removido do carrinho.", Toast.LENGTH_SHORT).show()
                    loadWishlist()
                }
            )
        }
    }

    private fun showPlantDialog(planta: Planta) {
        AlertDialog.Builder(this)
            .setTitle(planta.nome)
            .setMessage("Tipo: ${planta.tipo}\nPreço: R$ ${"%.2f".format(planta.preco)}\n\nDescrição:\n${planta.descricao}\n\nCuidados:\n${planta.cuidados}")
            .setPositiveButton("Fechar", null)
            .show()
    }
}
