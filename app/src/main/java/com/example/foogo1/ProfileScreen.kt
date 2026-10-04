package com.example.foogo.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import com.example.foogo.ui.theme.AppColors
import com.example.foogo.ui.theme.AppShapes
import com.example.foogo.ui.theme.AppTypography

@Composable
fun ProfileScreen(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(AppColors.BackgroundLight)
            .verticalScroll(rememberScrollState())
            .padding(16.dp)
    ) {
        // Search Bar Top
        OutlinedTextField(
            value = "",
            onValueChange = {},
            placeholder = { Text("Search profile", style = AppTypography.BodyMedium, color = AppColors.TextMuted) },
            trailingIcon = { Icon(Icons.Default.Search, contentDescription = "Search", tint = AppColors.TextPrimary) },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp),
            shape = AppShapes.Pill,
            colors = OutlinedTextFieldDefaults.colors(
                unfocusedContainerColor = AppColors.CardBackground,
                focusedContainerColor = AppColors.CardBackground,
                unfocusedBorderColor = Color.Transparent,
                focusedBorderColor = AppColors.PrimaryCyan
            )
        )

        // User Card Section
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp),
            shape = AppShapes.Large,
            colors = CardDefaults.cardColors(containerColor = AppColors.CardBackground)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                // Profile Avatar Placeholder
                Box(
                    modifier = Modifier
                        .size(60.dp)
                        .clip(CircleShape)
                        .background(AppColors.SecondaryCyan),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        imageVector = Icons.Default.AccountBox,
                        contentDescription = "Avatar",
                        tint = AppColors.PrimaryCyan,
                        modifier = Modifier.size(36.dp)
                    )
                }

                Spacer(modifier = Modifier.width(16.dp))

                Column(modifier = Modifier.weight(1f)) {
                    Text(text = "Minji Kim", style = AppTypography.ItemTitle)
                    
                    Spacer(modifier = Modifier.height(4.dp))
                    
                    // Gold Member Badge
                    Box(
                        modifier = Modifier
                            .background(AppColors.SecondaryCyan, shape = AppShapes.Pill)
                            .padding(horizontal = 8.dp, vertical = 2.dp)
                    ) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Icon(
                                imageVector = Icons.Default.Star,
                                contentDescription = "Gold Member",
                                tint = AppColors.StarYellow,
                                modifier = Modifier.size(12.dp)
                            )
                            Spacer(modifier = Modifier.width(4.dp))
                            Text(text = "Gold Member", style = AppTypography.Caption, color = AppColors.TextPrimary)
                        }
                    }

                    Spacer(modifier = Modifier.height(4.dp))
                    Text(text = "minji@baemin.app", style = AppTypography.BodySmall)
                }

                Icon(
                    imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
                    contentDescription = "Details",
                    tint = AppColors.TextMuted
                )
            }
        }

        // Premium Membership Banner
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp),
            shape = AppShapes.Large,
            colors = CardDefaults.cardColors(containerColor = AppColors.SecondaryCyan)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column(modifier = Modifier.weight(1f)) {
                    Text(text = "Premium Membership", style = AppTypography.ItemTitle)
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                        text = "Free delivery, extra coupons, and exclusive perks!",
                        style = AppTypography.BodySmall
                    )
                }
                
                Box(
                    modifier = Modifier
                        .background(AppColors.TextPrimary, shape = AppShapes.Pill)
                        .padding(horizontal = 12.dp, vertical = 6.dp)
                ) {
                    Text(
                        text = "View Benefits >",
                        style = AppTypography.Caption,
                        color = Color.White
                    )
                }
            }
        }

        // Settings Menu List
        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = AppShapes.Large,
            colors = CardDefaults.cardColors(containerColor = AppColors.CardBackground)
        ) {
            Column(modifier = Modifier.padding(vertical = 8.dp)) {
                ProfileMenuItem(icon = Icons.Default.Settings, title = "Account Settings")
                ProfileMenuItem(icon = Icons.Default.Lock, title = "Payment Methods")
                ProfileMenuItem(icon = Icons.Default.Info, title = "Coupon Wallet", value = "5 coupons")
                ProfileMenuItem(icon = Icons.Default.CheckCircle, title = "Points", value = "12,350 P")
                ProfileMenuItem(icon = Icons.Default.Call, title = "Customer Service")
                ProfileMenuItem(icon = Icons.Default.Settings, title = "App Settings")
            }
        }
    }
}

@Composable
fun ProfileMenuItem(
    icon: ImageVector,
    title: String,
    value: String? = null
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { }
            .padding(horizontal = 16.dp, vertical = 14.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = icon,
            contentDescription = title,
            tint = AppColors.TextPrimary,
            modifier = Modifier.size(20.dp)
        )
        
        Spacer(modifier = Modifier.width(16.dp))

        Text(
            text = title,
            style = AppTypography.BodyMedium,
            modifier = Modifier.weight(1f)
        )

        if (value != null) {
            Text(
                text = value,
                style = AppTypography.BodySmall,
                color = AppColors.TextMuted,
                modifier = Modifier.padding(end = 8.dp)
            )
        }

        Icon(
            imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
            contentDescription = "Go",
            tint = AppColors.TextMuted,
            modifier = Modifier.size(16.dp)
        )
    }
}