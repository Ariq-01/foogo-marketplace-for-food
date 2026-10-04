package com.client.foogo1.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.client.foogo1.data.Order
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class OrderHistoryViewModel : ViewModel() {

    private val _orders = MutableStateFlow<List<Order>>(emptyList())
    val orders: StateFlow<List<Order>> = _orders.asStateFlow()

    init {
        // TODO: Inject OrderRepository here
        // TODO: Call loadOrders() to fetch data from repository
        loadOrders()
    }

    fun loadOrders() {
        viewModelScope.launch {
            // TODO: Implement data fetching via repository
            // repository.getOrders().collect { result ->
            //     _orders.value = result
            // }
        }
    }
}
