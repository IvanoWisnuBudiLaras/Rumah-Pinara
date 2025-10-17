package com.example.rumahpinara.ui.screen.menu

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.rumahpinara.ui.components.ProductCard

@Composable
fun MenuScreen(
    // viewModel: MenuViewModel = hiltViewModel() // cara mendapatkan viewModel
) {
    // Mock ViewModel untuk preview, ganti dengan yang asli saat running
    val mockViewModel = MenuViewModel(GetProductsUseCase(ProductRepositoryImpl(FakeApiService())))
    val uiState by mockViewModel.uiState.collectAsState()

    Box(modifier = Modifier.fillMaxSize()) {
        if (uiState.isLoading) {
            CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
        }

        if (uiState.error != null) {
            Text(
                text = "Error: ${uiState.error}",
                modifier = Modifier.align(Alignment.Center)
            )
        }

        LazyColumn(
            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            items(uiState.products) { product ->
                ProductCard(product = product)
            }
        }
    }
}

// Catatan: FakeApiService dan implementasi lainnya diperlukan untuk membuat preview ini bekerja.