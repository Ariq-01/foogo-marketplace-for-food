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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.List
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
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

// Model data pesanan mockup
data class OrderItemModel(
    val id: String,
    val storeName: String,
    val itemsSummary: String,
    val date: String,
    val price: String,
    val status: String,
    val isCompleted: Boolean,
    val isCancelled: Boolean = false
)

@Composable
fun OrderHistoryScreen(
    modifier: Modifier = Modifier
) {
    var selectedTabIndex by remember { mutableIntStateOf(0) }
    val tabs = listOf("All", "Delivery", "Takeout")

    // Mock Data List Order History (Bahasa Inggris)
    val orderList = listOf(
        OrderItemModel("1", "BHC Chicken", "Prinkle Chicken, Cola 1.25L", "2026.09.24", "$24.00", "Delivery Completed", isCompleted = true),
        OrderItemModel("2", "Sinjeon Tteokbokki", "Tteokbokki, Tempura Set", "2026.09.23", "$16.50", "Preparing Food", isCompleted = false),
        OrderItemModel("3", "Hansot Lunchbox", "Chicken Mayo, Kimchi Stew", "2026.09.21", "$13.50", "Order Cancelled", isCompleted = false, isCancelled = true),
        OrderItemModel("4", "Sushiya", "Assorted Sushi 12pcs", "2026.09.20", "$28.00", "Delivery Completed", isCompleted = true)
    )

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(AppColors.BackgroundLight)
    ) {
        // Header Title
        Text(
            text = "Order History",
            style = AppTypography.HeaderTitle,
            modifier = Modifier.padding(16.dp)
        )

        // Filter Tabs
        ScrollableTabRow(
            selectedTabIndex = selectedTabIndex,
            edgePadding = 16.dp,
            containerColor = AppColors.BackgroundLight,
            contentColor = AppColors.TextPrimary,
            divider = {}
        ) {
            tabs.forEachIndexed { index, title ->
                Tab(
                    selected = selectedTabIndex == index,
                    onClick = { selectedTabIndex = index },
                    text = {
                        Text(
                            text = title,
                            style = AppTypography.ButtonText,
                            color = if (selectedTabIndex == index) AppColors.TextPrimary else AppColors.TextMuted
                        )
                    }
                )
            }
        }

        Spacer(modifier = Modifier.height(8.dp))

        // Order List
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(orderList) { order ->
                OrderCardItem(order = order)
            }
        }
    }
}

@Composable
fun OrderCardItem(order: OrderItemModel) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = AppShapes.Large,
        colors = CardDefaults.cardColors(containerColor = AppColors.CardBackground)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                // Food Image Placeholder
                Box(
                    modifier = Modifier
                        .size(64.dp)
                        .clip(AppShapes.Medium)
                        .background(AppColors.SecondaryCyan),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        imageVector = Icons.Default.List,
                        contentDescription = "Food",
                        tint = AppColors.PrimaryCyan
                    )
                }

                Spacer(modifier = Modifier.width(12.dp))

                Column(modifier = Modifier.weight(1f)) {
                    Text(text = order.storeName, style = AppTypography.ItemTitle)
                    Spacer(modifier = Modifier.height(2.dp))
                    Text(text = order.itemsSummary, style = AppTypography.BodySmall)
                    Spacer(modifier = Modifier.height(2.dp))
                    Text(text = order.date, style = AppTypography.Caption)
                }

                // Status Badge
                val statusBg = when {
                    order.isCancelled -> AppColors.AccentRed.copy(alpha = 0.1f)
                    order.isCompleted -> AppColors.SecondaryCyan
                    else -> AppColors.AccentOrange.copy(alpha = 0.1f)
                }
                val statusColor = when {
                    order.isCancelled -> AppColors.AccentRed
                    order.isCompleted -> AppColors.PrimaryCyan
                    else -> AppColors.AccentOrange
                }

                Box(
                    modifier = Modifier
                        .background(statusBg, shape = AppShapes.Pill)
                        .padding(horizontal = 8.dp, vertical = 4.dp)
                ) {
                    Text(
                        text = order.status,
                        style = AppTypography.Caption,
                        color = statusColor
                    )
                }
            }

            Spacer(modifier = Modifier.height(12.dp))

            // Price & Actions
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(text = order.price, style = AppTypography.SectionTitle)

                Row {
                    if (order.isCompleted) {
                        OutlinedButton(
                            onClick = { },
                            shape = AppShapes.Pill,
                            colors = ButtonDefaults.outlinedButtonColors(contentColor = AppColors.TextPrimary),
                            modifier = Modifier.padding(end = 8.dp)
                        ) {
                            Text("Write Review", style = AppTypography.Caption)
                        }
                    }

                    OutlinedButton(
                        onClick = { },
                        shape = AppShapes.Pill,
                        colors = ButtonDefaults.outlinedButtonColors(
                            containerColor = AppColors.TextPrimary,
                            contentColor = Color.White
                        )
                    ) {
                        Text("Reorder", style = AppTypography.Caption, color = Color.White)
                    }
                }
            }
        }
    }
}