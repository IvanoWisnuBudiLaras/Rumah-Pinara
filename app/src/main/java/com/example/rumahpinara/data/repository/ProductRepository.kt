package com.example.rumahpinara.data.repository

import com.example.rumahpinara.domain.model.Product

interface ProductRepository {
    // Perjanjian: Siapapun yang menjadi ProductRepository HARUS punya fungsi ini.
    suspend fun getProducts(): List<Product>
}