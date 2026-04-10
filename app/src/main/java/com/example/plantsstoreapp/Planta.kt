package com.example.plantsstoreapp

import java.io.Serializable

data class Planta(
    val id: Int,                 // Identificador único (importante para listas)
    val nome: String,            // Nome da planta
    val tipo: String,            // Tipo (Suculentas, Tropicais, etc.)
    val descricao: String,       // Descrição geral
    val cuidados: String,        // Como cuidar da planta
    val imagem: Int,             // ID da imagem (R.drawable...)
    var favorito: Boolean = false, // Para salvar no carrinho (SharedPreferences)
    val preco: Double            // Preço da planta
) : Serializable