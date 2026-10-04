package com.client.foogo1.data

data class Product(
    val id: String,
    val name: String,
    val price: Double,
    val category: String,
    val imageUrl: String,
    val isInStock: Boolean = true,
    val isFavorite: Boolean = false
)

data class FavoriteProduct(
    val productId: String,
    val productName: String,
    val price: Double,
    val imageUrl: String
)

data class OrderItem(
    val productId: String,
    val productName: String,
    val quantity: Int,
    val price: Double
)

data class Order(
    val orderId: String,
    val date: String,
    val totalAmount: Double,
    val status: String,
    val items: List<OrderItem>
)

data class UserProfile(
    val name: String,
    val email: String,
    val phone: String,
    val address: String
)

sealed interface UiState<out T> {
    object Loading : UiState<Nothing>
    data class Success<T>(val data: T) : UiState<T>
    data class Error(val message: String) : UiState<Nothing>
}
