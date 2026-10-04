package com.client.foogo1.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.client.foogo1.data.UserProfile
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class ProfileViewModel : ViewModel() {

    private val _profile = MutableStateFlow<UserProfile?>(null)
    val profile: StateFlow<UserProfile?> = _profile.asStateFlow()

    init {
        // TODO: Inject UserRepository here
        // TODO: Call loadProfile() to fetch data from repository
        loadProfile()
    }

    fun loadProfile() {
        viewModelScope.launch {
            // TODO: Implement data fetching via repository
            // val result = repository.getUserProfile()
            // _profile.value = result
        }
    }

    fun updateProfile(profile: UserProfile) {
        // TODO: Implement profile update via repository
    }
}
