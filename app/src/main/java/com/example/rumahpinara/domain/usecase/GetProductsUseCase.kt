package com.example.rumahpinara.domain.usecase

import com.example.rumahpinara.data.repository.ProductRepository
import com.example.rumahpinara.domain.model.Product

class GetProductsUseCase(
    private val repository: ProductRepository // Tergantung pada kontrak, bukan implementasi
) {
    // `operator fun invoke` membuat class ini bisa dipanggil seperti fungsi.
    // Contoh: getProductsUseCase()
    suspend operator fun invoke(): List<Product> {
        // Logika bisa ditambahkan di sini, misal: sortir produk berdasarkan harga.
        // Untuk sekarang, kita hanya meneruskan panggilan ke repository.
        return repository.getProducts()
    }
}