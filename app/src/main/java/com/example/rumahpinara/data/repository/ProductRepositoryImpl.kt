package com.example.rumahpinara.data.repository

import com.example.rumahpinara.data.remote.api.ApiService
import com.example.rumahpinara.domain.model.Product

// Menggunakan dependency injection untuk mendapatkan ApiService
class ProductRepositoryImpl(
    private val api: ApiService
) : ProductRepository {

    override suspend fun getProducts(): List<Product> {
        return try {
            // 1. Panggil API untuk dapat data mentah (List<ProductDto>)
            val remoteProducts = api.getProducts()

            // 2. Ubah setiap item dari DTO menjadi Domain Model (List<Product>)
            //    lalu kembalikan hasilnya.
            remoteProducts.map { it.toProduct() }
        } catch (e: Exception) {
            // Jika ada error (misal: tidak ada internet), kembalikan list kosong
            // atau lempar error khusus untuk ditangani di ViewModel.
            emptyList()
        }
    }
}