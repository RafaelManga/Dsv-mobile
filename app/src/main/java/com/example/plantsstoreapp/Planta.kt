package com.example.plantsstoreapp

import java.io.Serializable

data class Planta(
    val id: Int,
    val nome: String,
    val tipo: String,
    val descricao: String,
    val cuidados: String,
    val imagem: Int,
    var favorito: Boolean = false,
    val preco: Double
) : Serializable
