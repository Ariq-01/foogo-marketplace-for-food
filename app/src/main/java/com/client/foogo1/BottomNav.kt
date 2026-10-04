package com.client.foogo1

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Receipt
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.client.foogo1.viewmodel.FavoritesViewModel
import com.client.foogo1.viewmodel.GroceryViewModel
import com.client.foogo1.viewmodel.OrderHistoryViewModel
import com.client.foogo1.viewmodel.ProfileViewModel

sealed class Screen(
    val title: String,
    val icon: androidx.compose.ui.graphics.vector.ImageVector,
    val route: String
) {
    object Grocery : Screen("Grocery", Icons.Default.Home, "grocery")
    object Favorites : Screen("Favorites", Icons.Default.Favorite, "favorites")
    object Orders : Screen("Orders", Icons.Default.Receipt, "orders")
    object Profile : Screen("Profile", Icons.Default.Person, "profile")
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BottomNav(
    groceryViewModel: GroceryViewModel = viewModel(),
    favoritesViewModel: FavoritesViewModel = viewModel(),
    orderHistoryViewModel: OrderHistoryViewModel = viewModel(),
    profileViewModel: ProfileViewModel = viewModel(),
    modifier: Modifier = Modifier
) {
    val screens = listOf(Screen.Grocery, Screen.Favorites, Screen.Orders, Screen.Profile)
    val (selectedRoute, setSelectedRoute) = rememberSaveable { mutableStateOf(screens[0].route) }
    val currentScreen = screens.find { it.route == selectedRoute } ?: screens[0]

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(title = { Text(currentScreen.title) })
        },
        bottomBar = {
            NavigationBar {
                screens.forEach { screen ->
                    NavigationBarItem(
                        selected = selectedRoute == screen.route,
                        onClick = { setSelectedRoute(screen.route) },
                        icon = { Icon(screen.icon, contentDescription = screen.title) },
                        label = { Text(screen.title) }
                    )
                }
            }
        },
        modifier = modifier
    ) { padding ->
        when (selectedRoute) {
            Screen.Grocery.route -> GroceryScreen(
                viewModel = groceryViewModel,
                modifier = Modifier.padding(padding)
            )
            Screen.Favorites.route -> FavoritesScreen(
                viewModel = favoritesViewModel,
                modifier = Modifier.padding(padding)
            )
            Screen.Orders.route -> OrderHistoryScreen(
                viewModel = orderHistoryViewModel,
                modifier = Modifier.padding(padding)
            )
            Screen.Profile.route -> ProfileScreen(
                viewModel = profileViewModel,
                modifier = Modifier.padding(padding)
            )
        }
    }
}
