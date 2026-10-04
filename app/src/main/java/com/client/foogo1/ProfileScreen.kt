package com.client.foogo1

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.client.foogo1.data.UserProfile
import com.client.foogo1.viewmodel.ProfileViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileScreen(
    viewModel: ProfileViewModel,
    modifier: Modifier = Modifier
) {
    val profile by viewModel.profile.collectAsState()

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(title = { Text("Profile") })
        },
        floatingActionButton = {
            FloatingActionButton(onClick = { /* TODO: edit profile */ }) {
                Text(text = "Edit")
            }
        },
        modifier = modifier
    ) { padding ->
        profile?.let { userProfile ->
            ProfileContent(
                profile = userProfile,
                modifier = Modifier
                    .fillMaxSize()
                    .verticalScroll(rememberScrollState())
                    .padding(padding)
                    .padding(24.dp)
            )
        } ?: run {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(padding),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "No profile data available",
                    style = MaterialTheme.typography.bodyLarge,
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}

@Composable
fun ProfileContent(
    profile: UserProfile,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier) {
        Text(
            text = profile.name,
            style = MaterialTheme.typography.titleLarge
        )
        Spacer(modifier = Modifier.height(24.dp))
        ProfileInfoRow(label = "Email", value = profile.email)
        ProfileInfoRow(label = "Phone", value = profile.phone)
        ProfileInfoRow(label = "Address", value = profile.address)
    }
}

@Composable
fun ProfileInfoRow(label: String, value: String) {
    Column(modifier = Modifier.fillMaxWidth()) {
        Text(
            text = label,
            style = MaterialTheme.typography.titleSmall,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
        Text(
            text = value,
            style = MaterialTheme.typography.bodyLarge
        )
        Spacer(modifier = Modifier.height(16.dp))
    }
}
