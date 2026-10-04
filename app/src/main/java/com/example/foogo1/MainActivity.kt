package com.example.foogo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.foogo.ui.components.BottomNavItem
import com.example.foogo.ui.components.FoogoBottomNavBar
import com.example.foogo.ui.screens.FavoritesScreen
import com.example.foogo.ui.screens.GroceryScreen
import com.example.foogo.ui.screens.LoadingScreen
import com.example.foogo.ui.screens.OrderHistoryScreen
import com.example.foogo.ui.screens.ProfileScreen
import com.example.foogo.ui.theme.AppTypography
import com.example.foogo.ui.theme.FoogoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FoogoTheme {
                MainAppContainer()
            }
        }
    }
}

@Composable
fun MainAppContainer() {
    // State untuk kontrol Loading Screen
    var isLoading by remember { mutableStateOf(true) }

    // State untuk kontrol Tab Navigasi Aktif
    var currentRoute by remember { mutableStateOf(BottomNavItem.Home.route) }

    if (isLoading) {
        // 1. Tampilkan Loading Screen saat pertama kali dibuka
        LoadingScreen(
            onLoadingComplete = {
                isLoading = false
            }
        )
    } else {
        // 2. Tampilkan Halaman Utama + Bottom Navigation Bar
        Scaffold(
            bottomBar = {
                FoogoBottomNavBar(
                    selectedRoute = currentRoute,
                    onTabSelected = { newRoute ->
                        currentRoute = newRoute
                    }
                )
            }
        ) { innerPadding ->
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding)
            ) {
                // Switcher Halaman Berdasarkan Tab Terpilih
                when (currentRoute) {
                    BottomNavItem.Home.route -> HomeScreenPlaceholder()
                    BottomNavItem.Grocery.route -> GroceryScreen()
                    BottomNavItem.Favorites.route -> FavoritesScreen()
                    BottomNavItem.Orders.route -> OrderHistoryScreen()
                    BottomNavItem.Profile.route -> ProfileScreen()
                }
            }
        }
    }
}

// Placeholder Sederhana untuk Tab Home
@Composable
fun HomeScreenPlaceholder() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "Welcome to Foogo Home!",
            style = AppTypography.HeaderTitle
        )
    }
}