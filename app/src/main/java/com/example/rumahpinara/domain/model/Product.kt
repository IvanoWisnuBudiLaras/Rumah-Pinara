package com.example.rumahpinara.domain.model

// Ini adalah model data yang akan digunakan oleh UI dan ViewModel.
// Sederhana dan hanya berisi apa yang dibutuhkan.
data class Product(
    val id: Int,
    val name: String,
    val price: Int,
    val imageUrl: String
)