package com.example.plantsstoreapp

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class WishlistActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var tvEmpty: TextView
    private lateinit var btnClear: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_wishlist)

        recyclerView = findViewById(R.id.wishlistRecycler)
        tvEmpty      = findViewById(R.id.tvEmpty)
        btnClear     = findViewById(R.id.btnClearWishlist)

        recyclerView.layoutManager = LinearLayoutManager(this)

        loadWishlist()

        btnClear.setOnClickListener {
            WishlistManager.clear(this)
            loadWishlist()
        }

        findViewById<View>(R.id.btnBack).setOnClickListener { finish() }
    }

    private fun loadWishlist() {
        val savedIds    = WishlistManager.getWishlist(this)
        val wishPlants  = PlantRepository.todas().filter { it.id in savedIds }

        if (wishPlants.isEmpty()) {
            tvEmpty.visibility      = View.VISIBLE
            recyclerView.visibility = View.GONE
            btnClear.visibility     = View.GONE
        } else {
            tvEmpty.visibility      = View.GONE
            recyclerView.visibility = View.VISIBLE
            btnClear.visibility     = View.VISIBLE
            recyclerView.adapter = PlantAdapter(this, wishPlants) { planta ->
                showPlantDialog(planta)
            }
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
