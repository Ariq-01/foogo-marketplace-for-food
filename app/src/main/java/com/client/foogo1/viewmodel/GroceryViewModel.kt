package com.client.foogo1.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.client.foogo1.data.Product
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class GroceryViewModel : ViewModel() {

    private val _products = MutableStateFlow<List<Product>>(emptyList())
    val products: StateFlow<List<Product>> = _products.asStateFlow()

    init {
        // TODO: Inject ProductRepository here
        // TODO: Call loadProducts() to fetch data from repository
        loadProducts()
    }

    fun loadProducts() {
        viewModelScope.launch {
            // TODO: Implement data fetching via repository
            // repository.getProducts().collect { result ->
            //     _products.value = result
            // }
        }
    }

    fun toggleFavorite(productId: String) {
        // TODO: Implement favorite toggle via repository
    }
}
