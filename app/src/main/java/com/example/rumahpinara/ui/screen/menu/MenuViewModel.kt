package com.example.rumahpinara.ui.screen.menu

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.rumahpinara.domain.model.Product
import com.example.rumahpinara.domain.usecase.GetProductsUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

// State yang akan diobservasi oleh UI
data class MenuUiState(
    val isLoading: Boolean = false,
    val products: List<Product> = emptyList(),
    val error: String? = null
)

// Contoh dengan Hilt untuk dependency injection
// @HiltViewModel
class MenuViewModel( // @Inject constructor(
    private val getProductsUseCase: GetProductsUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow(MenuUiState())
    val uiState: StateFlow<MenuUiState> = _uiState.asStateFlow()

    init {
        loadProducts()
    }

    private fun loadProducts() {
        viewModelScope.launch {
            // 1. Tampilkan loading
            _uiState.value = MenuUiState(isLoading = true)

            // 2. Panggil use case untuk dapatkan data
            val result = getProductsUseCase() // Memanggil invoke() secara implisit

            // 3. Update state dengan hasil
            _uiState.value = MenuUiState(products = result, isLoading = false)
        }
    }
}