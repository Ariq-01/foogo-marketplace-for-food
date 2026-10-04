package com.client.foogo1

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.client.foogo1.data.UiState

@Composable
fun <T> LoadingScreen(
    uiState: UiState<T>,
    onRetry: () -> Unit = {},
    modifier: Modifier = Modifier,
    content: @Composable (T) -> Unit
) {
    when (uiState) {
        is UiState.Loading -> {
            Box(
                modifier = modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator()
            }
        }
        is UiState.Success -> {
            content(uiState.data)
        }
        is UiState.Error -> {
            Box(
                modifier = modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text(
                        text = uiState.message,
                        color = MaterialTheme.colorScheme.error,
                        style = MaterialTheme.typography.bodyMedium
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Button(onClick = onRetry) {
                        Text("Retry")
                    }
                }
            }
        }
    }
}
