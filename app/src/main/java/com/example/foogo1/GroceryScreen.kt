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
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.foogo.ui.theme.AppColors
import com.example.foogo.ui.theme.AppShapes
import com.example.foogo.ui.theme.AppTypography

// Model data produk grocery mockup
data class GroceryProductModel(
    val id: String,
    val name: String,
    val price: String,
    val originalPrice: String? = null,
    val discountTag: String? = null
)

@Composable
fun GroceryScreen(
    modifier: Modifier = Modifier
) {
    val categories = listOf("Supermarket", "Convenience", "Fresh Food", "Beverages", "Daily Supplies")

    val fastDeliveryProducts = listOf(
        GroceryProductModel("1", "Fresh Milk 1L", "$2.98", discountTag = "20% OFF"),
        GroceryProductModel("2", "Apples 1.5kg", "$12.80", originalPrice = "$16.00", discountTag = "20% OFF"),
        GroceryProductModel("3", "Organic Lettuce", "$1.98"),
        GroceryProductModel("4", "Pork Belly 500g", "$15.90", originalPrice = "$18.90", discountTag = "15% OFF")
    )

    val recommendedProducts = listOf(
        GroceryProductModel("1", "Ramen Cup 6pk", "$5.94", discountTag = "10% OFF"),
        GroceryProductModel("2", "Strawberries 500g", "$9.90"),
        GroceryProductModel("3", "Fresh Eggs 15pk", "$7.48"),
        GroceryProductModel("4", "Bananas 1kg", "$3.98")
    )

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(AppColors.BackgroundLight)
            .verticalScroll(rememberScrollState())
            .padding(bottom = 16.dp)
    ) {
        // Location & Search Header
        Column(modifier = Modifier.padding(16.dp)) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(
                    imageVector = Icons.Default.LocationOn,
                    contentDescription = "Location",
                    tint = AppColors.TextPrimary
                )
                Spacer(modifier = Modifier.width(4.dp))
                Text(text = "Downtown Area", style = AppTypography.ItemTitle)
            }

            Spacer(modifier = Modifier.height(12.dp))

            OutlinedTextField(
                value = "",
                onValueChange = {},
                placeholder = { Text("Search products you need", style = AppTypography.BodyMedium, color = AppColors.TextMuted) },
                trailingIcon = { Icon(Icons.Default.Search, contentDescription = "Search", tint = AppColors.TextPrimary) },
                modifier = Modifier.fillMaxWidth(),
                shape = AppShapes.Pill,
                colors = OutlinedTextFieldDefaults.colors(
                    unfocusedContainerColor = AppColors.CardBackground,
                    focusedContainerColor = AppColors.CardBackground,
                    unfocusedBorderColor = Color.Transparent,
                    focusedBorderColor = AppColors.PrimaryCyan
                )
            )
        }

        // Promotional Banner
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            shape = AppShapes.Large,
            colors = CardDefaults.cardColors(containerColor = AppColors.SecondaryCyan)
        ) {
            Column(modifier = Modifier.padding(16.dp)) {
                Text(text = "Fresh Daily Grocery Market", style = AppTypography.SectionTitle)
                Spacer(modifier = Modifier.height(4.dp))
                Text(text = "Fast delivery from fresh produce to daily supplies!", style = AppTypography.BodySmall)
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Categories Row
        LazyRow(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            contentPadding = androidx.compose.foundation.layout.PaddingValues(horizontal = 16.dp)
        ) {
            items(categories) { category ->
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Box(
                        modifier = Modifier
                            .size(56.dp)
                            .clip(CircleShape)
                            .background(AppColors.CardBackground),
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            imageVector = Icons.Default.ShoppingCart,
                            contentDescription = category,
                            tint = AppColors.PrimaryCyan
                        )
                    }
                    Spacer(modifier = Modifier.height(6.dp))
                    Text(text = category, style = AppTypography.Caption)
                }
            }
        }

        Spacer(modifier = Modifier.height(20.dp))

        // Fast Delivery Section
        SectionHeader(title = "Fast Delivery Items")
        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            contentPadding = androidx.compose.foundation.layout.PaddingValues(horizontal = 16.dp)
        ) {
            items(fastDeliveryProducts) { product ->
                GroceryProductCard(product = product)
            }
        }

        Spacer(modifier = Modifier.height(20.dp))

        // Recommended Items Section
        SectionHeader(title = "Recommended Products")
        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            contentPadding = androidx.compose.foundation.layout.PaddingValues(horizontal = 16.dp)
        ) {
            items(recommendedProducts) { product ->
                GroceryProductCard(product = product)
            }
        }
    }
}

@Composable
fun SectionHeader(title: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(text = title, style = AppTypography.SectionTitle)
        Text(text = "See All >", style = AppTypography.Caption, color = AppColors.TextMuted)
    }
}

@Composable
fun GroceryProductCard(product: GroceryProductModel) {
    Card(
        modifier = Modifier.width(130.dp),
        shape = AppShapes.Medium,
        colors = CardDefaults.cardColors(containerColor = AppColors.CardBackground)
    ) {
        Column(modifier = Modifier.padding(8.dp)) {
            // Product Image Placeholder
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(90.dp)
                    .clip(AppShapes.Small)
                    .background(AppColors.SecondaryCyan),
                contentAlignment = Alignment.Center
            ) {
                if (product.discountTag != null) {
                    Box(
                        modifier = Modifier
                            .align(Alignment.TopStart)
                            .background(AppColors.AccentRed, shape = AppShapes.Small)
                            .padding(horizontal = 6.dp, vertical = 2.dp)
                    ) {
                        Text(text = product.discountTag, style = AppTypography.Caption, color = Color.White)
                    }
                }
                Icon(
                    imageVector = Icons.Default.ShoppingCart,
                    contentDescription = product.name,
                    tint = AppColors.PrimaryCyan
                )
            }

            Spacer(modifier = Modifier.height(8.dp))

            Text(text = product.name, style = AppTypography.BodyMedium, maxLines = 1)

            Spacer(modifier = Modifier.height(4.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column {
                    Text(text = product.price, style = AppTypography.ItemTitle)
                    if (product.originalPrice != null) {
                        Text(
                            text = product.originalPrice,
                            style = AppTypography.Caption,
                            color = AppColors.TextMuted
                        )
                    }
                }

                IconButton(
                    onClick = { },
                    modifier = Modifier
                        .size(28.dp)
                        .background(AppColors.PrimaryCyan, shape = CircleShape)
                ) {
                    Icon(
                        imageVector = Icons.Default.Add,
                        contentDescription = "Add",
                        tint = Color.White,
                        modifier = Modifier.size(16.dp)
                    )
                }
            }
        }
    }
}