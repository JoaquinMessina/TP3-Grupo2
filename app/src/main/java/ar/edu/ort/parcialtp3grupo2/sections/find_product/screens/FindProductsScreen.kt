package ar.edu.ort.parcialtp3grupo2.sections.find_product.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.material3.TextField
import androidx.compose.material3.Icon
import androidx.compose.material.icons.automirrored.filled.ExitToApp
import androidx.compose.material.icons.automirrored.outlined.Send
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.remember
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.rememberScrollState
import ar.edu.ort.parcialtp3grupo2.sections.find_product.components.CategoryCard

@Composable
fun FindProductsScreen(innerPadding: PaddingValues, categories: List<Pair<Color, String>>, onClick: (String) -> Unit) {
    var text by remember { mutableStateOf("") }

    val scrollState = rememberScrollState()


    Column (
        modifier = Modifier
            .padding(innerPadding)
            .fillMaxWidth()
    ){
        TextField(
            value = "",
            onValueChange = { text = it },
            label = { Text("Search Store") },
            leadingIcon = {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.ExitToApp,
                    contentDescription = "Email Icon"
                )
            },
            trailingIcon = {
                IconButton(onClick = { text = "" }) {
                    Icon(
                        imageVector =  Icons.AutoMirrored.Outlined.Send,
                        contentDescription = "Clear Text"
                    )
                }
            },
            shape = RoundedCornerShape(16.dp),
            colors = TextFieldDefaults.colors(
                unfocusedContainerColor = Color(0xF2F3F2FF),
                cursorColor = Color(0x00000000),
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                disabledIndicatorColor = Color.Transparent
            ),
            modifier = Modifier
                .width(500.dp)
                .padding(horizontal = 16.dp)
        )

        LazyVerticalGrid(
            columns = GridCells.Fixed(2), // Fija 2 columnas
            modifier = Modifier.padding(16.dp),
            contentPadding = androidx.compose.foundation.layout.PaddingValues(8.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            userScrollEnabled = true,
        ) {
            items(categories) { category ->
                CategoryCard(color = category.first, title = category.second) {
                    onClick(category.second)
                }
            }
        }
    }

}