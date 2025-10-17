package com.example.rumahpinara.data.remote.api

import com.example.rumahpinara.data.remote.dto.ProductDto
import retrofit2.http.GET

interface ApiService {
    // Mendeklarasikan bahwa ada sebuah endpoint "products"
    // yang akan mengembalikan daftar produk.
    @GET("products")
    suspend fun getProducts(): List<ProductDto> // Mengembalikan data mentah (DTO)
}