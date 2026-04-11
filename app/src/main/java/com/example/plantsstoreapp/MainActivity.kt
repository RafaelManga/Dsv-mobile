package com.example.plantsstoreapp

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.activity.enableEdgeToEdge
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.plantsstoreapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        setupHorizontalList(binding.rvSuculentas, PlantRepository.suculentas)
        setupHorizontalList(binding.rvTropicais,  PlantRepository.tropicais)
        setupHorizontalList(binding.rvErvas,      PlantRepository.ervas)
        setupHorizontalList(binding.rvFlores,     PlantRepository.flores)

        binding.cartbtn.setOnClickListener {
            startActivity(Intent(this, WishlistActivity::class.java))
        }
    }

    private fun setupHorizontalList(rv: androidx.recyclerview.widget.RecyclerView, plantas: List<Planta>) {
        rv.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        rv.adapter = PlantAdapter(this, plantas) { planta -> showPlantDialog(planta) }
    }

    private fun showPlantDialog(planta: Planta) {
        AlertDialog.Builder(this)
            .setTitle(planta.nome)
            .setMessage("Tipo: ${planta.tipo}\nPreço: R$ ${"%.2f".format(planta.preco)}\n\nDescrição:\n${planta.descricao}\n\nCuidados:\n${planta.cuidados}")
            .setPositiveButton("Fechar", null)
            .setNeutralButton("♡ Wishlist") { _, _ ->
                val adicionou = WishlistManager.toggle(this, planta.id)

                val msg = if (adicionou) "${planta.nome} adicionado ao carrinho! 🛒"
                          else "${planta.nome} removido do carrinho."
                Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
            }
            .show()
    }
}
