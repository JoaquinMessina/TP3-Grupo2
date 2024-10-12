package ar.edu.ort.parcialtp3grupo2.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.Modifier


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTopAppBar(title: String, isArrowBack: Boolean) {
    TopAppBar(
        title = {
            Text(
                text = title,
                style = MaterialTheme.typography.titleLarge,
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center
            )
        },
        navigationIcon = {
            IconButton(onClick = {
                if (isArrowBack) {
                    //futura logica de flechita
                } else {
                    //no hay logica de 3 barritas
                }
            }) {
                Icon(
                    imageVector = if (isArrowBack) Icons.Default.KeyboardArrowLeft else Icons.Default.Menu,
                    contentDescription = if (isArrowBack) "Back Icon" else "Menu Icon"
                )
            }
        },
        modifier = Modifier.fillMaxWidth()
    )
}

