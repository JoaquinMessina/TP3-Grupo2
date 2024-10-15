package ar.edu.ort.parcialtp3grupo2.sections.explore.screens

import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ar.edu.ort.parcialtp3grupo2.R
import ar.edu.ort.parcialtp3grupo2.sections.explore.components.SearchInput
import ar.edu.ort.parcialtp3grupo2.sections.home.data.Product
import ar.edu.ort.parcialtp3grupo2.sections.home.data.ProductRepository
import ar.edu.ort.parcialtp3grupo2.sections.home.screens.ProductCardCat

@Composable
fun SearchScreen(
    text: String,
    onTextChange: (String) -> Unit
) {
    val productRepository = ProductRepository()
    val cartItems = productRepository.getAllData()

    val itemsCoincidents = cartItems.filter { it.name.contains(text, ignoreCase = true) }

    Column(
            modifier = Modifier
                .padding(start = 16.dp, end = 16.dp, bottom = 16.dp, top = 64.dp)
                .fillMaxWidth()
        ) {

            SearchInput(text = text,
                onTextChange = onTextChange)
            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                verticalArrangement = Arrangement.spacedBy(16.dp),
                horizontalArrangement = Arrangement.spacedBy(16.dp),

                modifier = Modifier
                    .padding()
                    .padding(16.dp)
                    .fillMaxSize()
            ) {
                items(itemsCoincidents) { product ->
                    ProductCardCat(product = product)
                }
            }
        }
    }
