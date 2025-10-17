package com.example.rumahpinara.data.remote.dto

import com.example.rumahpinara.domain.model.Product
import com.squareup.moshi.Json

// Data class ini HARUS cocok dengan struktur JSON dari API
data class ProductDto(
    @field:Json(name = "product_id") // Nama field di JSON bisa beda
    val id: Int,

    @field:Json(name = "product_name")
    val name: String,

    val description: String,
    val price: Int,

    @field:Json(name = "image_url")
    val imageUrl: String,

    val category: String
) {
    // Fungsi ini penting untuk mengubah data "mentah" (DTO)
    // menjadi data "bersih" (Domain Model) yang akan dipakai di seluruh aplikasi.
    fun toProduct(): Product {
        return Product(
            id = id,
            name = name,
            price = price,
            imageUrl = imageUrl
        )
    }
}