package com.example.plantsstoreapp

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.activity.enableEdgeToEdge
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        setupHorizontalList(R.id.rvSuculentas, PlantRepository.suculentas)
        setupHorizontalList(R.id.rvTropicais,  PlantRepository.tropicais)
        setupHorizontalList(R.id.rvErvas,      PlantRepository.ervas)
        setupHorizontalList(R.id.rvFlores,     PlantRepository.flores)

        findViewById<ImageButton>(R.id.cartbtn).setOnClickListener {
            startActivity(Intent(this, WishlistActivity::class.java))
        }
    }

    private fun setupHorizontalList(viewId: Int, plantas: List<Planta>) {
        val rv = findViewById<RecyclerView>(viewId)
        rv.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        rv.adapter = PlantAdapter(this, plantas) { planta -> showPlantDialog(planta) }
    }

    private fun showPlantDialog(planta: Planta) {
        AlertDialog.Builder(this)
            .setTitle(planta.nome)
            .setMessage("Tipo: ${planta.tipo}\nPreço: R$ ${"%.2f".format(planta.preco)}\n\nDescrição:\n${planta.descricao}\n\nCuidados:\n${planta.cuidados}")
            .setPositiveButton("Fechar", null)
            .setNeutralButton("♡ Wishlist") { _, _ ->
                WishlistManager.toggle(this, planta.id)
            }
            .show()
    }
}
