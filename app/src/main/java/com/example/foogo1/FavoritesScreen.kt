package com.example.foogo.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.ScrollableTabRow
import androidx.compose.material3.Tab
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.foogo.ui.theme.AppColors
import com.example.foogo.ui.theme.AppShapes
import com.example.foogo.ui.theme.AppTypography

// Model data toko favorit mockup
data class FavoriteStoreModel(
    val id: String,
    val name: String,
    val category: String,
    val rating: String,
    val deliveryTime: String,
    val minOrder: String
)

@Composable
fun FavoritesScreen(
    modifier: Modifier = Modifier
) {
    var selectedFilterIndex by remember { mutableIntStateOf(0) }
    val filters = listOf("Most Popular", "Recently Liked", "Fast Delivery")

    // Mock Data Store Favorit (Bahasa Inggris)
    val favoriteStores = listOf(
        FavoriteStoreModel("1", "BHC Chicken", "Chicken • Fried Food", "4.8 (9,999+)", "25~35 min", "Min. order $18.00"),
        FavoriteStoreModel("2", "Sinjeon Tteokbokki", "Snacks • Spicy Food", "4.7 (9,999+)", "20~30 min", "Min. order $12.00"),
        FavoriteStoreModel("3", "Sushiya", "Japanese • Sushi • Sashimi", "4.9 (9,999+)", "25~40 min", "Min. order $18.00"),
        FavoriteStoreModel("4", "Byeongcheon Soup", "Korean • Soup • Rice", "4.7 (9,999+)", "20~35 min", "Min. order $10.00")
    )

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(AppColors.BackgroundLight)
    ) {
        // Header Title
        Text(
            text = "Favorites",
            style = AppTypography.HeaderTitle,
            modifier = Modifier.padding(16.dp)
        )

        // Filter Bar
        ScrollableTabRow(
            selectedTabIndex = selectedFilterIndex,
            edgePadding = 16.dp,
            containerColor = AppColors.BackgroundLight,
            contentColor = AppColors.TextPrimary,
            divider = {}
        ) {
            filters.forEachIndexed { index, title ->
                Tab(
                    selected = selectedFilterIndex == index,
                    onClick = { selectedFilterIndex = index },
                    text = {
                        Text(
                            text = title,
                            style = AppTypography.ButtonText,
                            color = if (selectedFilterIndex == index) AppColors.TextPrimary else AppColors.TextMuted
                        )
                    }
                )
            }
        }

        Spacer(modifier = Modifier.height(8.dp))

        // Grid Store Content
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(favoriteStores) { store ->
                FavoriteStoreCard(store = store)
            }

            // Bottom Banner Section (Mengisi 2 Kolom)
            item(span = { GridItemSpan(2) }) {
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 16.dp),
                    shape = AppShapes.Large,
                    colors = CardDefaults.cardColors(containerColor = AppColors.SecondaryCyan)
                ) {
                    Column(
                        modifier = Modifier.padding(20.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            text = "Explore More Places!",
                            style = AppTypography.ItemTitle
                        )
                        Spacer(modifier = Modifier.height(4.dp))
                        Text(
                            text = "Add your favorite restaurants to order faster next time.",
                            style = AppTypography.BodySmall,
                            color = AppColors.TextSecondary
                        )
                        Spacer(modifier = Modifier.height(12.dp))
                        Button(
                            onClick = { },
                            shape = AppShapes.Pill,
                            colors = ButtonDefaults.buttonColors(containerColor = AppColors.TextPrimary)
                        ) {
                            Text("Browse Stores", style = AppTypography.ButtonText, color = Color.White)
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun FavoriteStoreCard(store: FavoriteStoreModel) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = AppShapes.Medium,
        colors = CardDefaults.cardColors(containerColor = AppColors.CardBackground)
    ) {
        Column {
            // Image Placeholder + Like Icon
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(110.dp)
                    .background(AppColors.SecondaryCyan),
                contentAlignment = Alignment.TopEnd
            ) {
                // Heart Icon
                Box(
                    modifier = Modifier
                        .padding(8.dp)
                        .size(32.dp)
                        .clip(CircleShape)
                        .background(Color.White),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        imageVector = Icons.Default.Favorite,
                        contentDescription = "Favorite",
                        tint = AppColors.AccentRed,
                        modifier = Modifier.size(18.dp)
                    )
                }

                // Center Placeholder Icon
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        imageVector = Icons.Default.Home,
                        contentDescription = "Store",
                        tint = AppColors.PrimaryCyan,
                        modifier = Modifier.size(40.dp)
                    )
                }
            }

            // Info Details
            Column(modifier = Modifier.padding(10.dp)) {
                Text(text = store.name, style = AppTypography.ItemTitle)
                Spacer(modifier = Modifier.height(2.dp))
                Text(text = store.category, style = AppTypography.Caption)

                Spacer(modifier = Modifier.height(6.dp))

                // Rating & Delivery Time
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        imageVector = Icons.Default.Star,
                        contentDescription = "Rating",
                        tint = AppColors.StarYellow,
                        modifier = Modifier.size(14.dp)
                    )
                    Spacer(modifier = Modifier.width(2.dp))
                    Text(text = store.rating, style = AppTypography.Caption, fontWeight = androidx.compose.ui.text.font.FontWeight.Bold)
                    Text(text = " • ${store.deliveryTime}", style = AppTypography.Caption)
                }

                Spacer(modifier = Modifier.height(4.dp))
                Text(text = store.minOrder, style = AppTypography.Caption, color = AppColors.TextMuted)
            }
        }
    }
}