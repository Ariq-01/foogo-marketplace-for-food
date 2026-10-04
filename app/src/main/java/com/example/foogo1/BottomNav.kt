package com.example.foogo.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import com.example.foogo.ui.theme.AppColors
import com.example.foogo.ui.theme.AppTypography

// Item Tab Navigation
sealed class BottomNavItem(val route: String, val title: String, val icon: ImageVector) {
    object Home : BottomNavItem("home", "Home", Icons.Default.Home)
    object Grocery : BottomNavItem("grocery", "Grocery", Icons.Default.ShoppingCart)
    object Favorites : BottomNavItem("favorites", "Favorites", Icons.Default.Favorite)
    object Orders : BottomNavItem("orders", "Orders", Icons.Default.List)
    object Profile : BottomNavItem("profile", "Profile", Icons.Default.Person)
}

@Composable
fun FoogoBottomNavBar(
    selectedRoute: String,
    onTabSelected: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    val items = listOf(
        BottomNavItem.Home,
        BottomNavItem.Grocery,
        BottomNavItem.Favorites,
        BottomNavItem.Orders,
        BottomNavItem.Profile
    )

    Row(
        modifier = modifier
            .fillMaxWidth()
            .background(AppColors.CardBackground)
            .padding(vertical = 8.dp),
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically
    ) {
        items.forEach { item ->
            val isSelected = selectedRoute == item.route
            val activeColor = AppColors.TextPrimary
            val inactiveColor = AppColors.TextMuted

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier
                    .weight(1f)
                    .clickable(
                        interactionSource = remember { MutableInteractionSource() },
                        indication = null
                    ) {
                        onTabSelected(item.route)
                    }
            ) {
                Icon(
                    imageVector = item.icon,
                    contentDescription = item.title,
                    tint = if (isSelected) activeColor else inactiveColor,
                    modifier = Modifier.size(24.dp)
                )
                Text(
                    text = item.title,
                    style = AppTypography.Caption,
                    color = if (isSelected) activeColor else inactiveColor,
                    modifier = Modifier.padding(top = 4.dp)
                )
            }
        }
    )
}