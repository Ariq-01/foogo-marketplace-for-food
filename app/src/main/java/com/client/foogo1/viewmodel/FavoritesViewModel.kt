package com.client.foogo1.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.client.foogo1.data.FavoriteProduct
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class FavoritesViewModel : ViewModel() {

    private val _favorites = MutableStateFlow<List<FavoriteProduct>>(emptyList())
    val favorites: StateFlow<List<FavoriteProduct>> = _favorites.asStateFlow()

    init {
        // TODO: Inject FavoriteRepository here
        // TODO: Call loadFavorites() to fetch data from repository
        loadFavorites()
    }

    fun loadFavorites() {
        viewModelScope.launch {
            // TODO: Implement data fetching via repository
            // repository.getFavorites().collect { result ->
            //     _favorites.value = result
            // }
        }
    }

    fun removeFromFavorites(productId: String) {
        // TODO: Implement remove from favorites via repository
    }
}
