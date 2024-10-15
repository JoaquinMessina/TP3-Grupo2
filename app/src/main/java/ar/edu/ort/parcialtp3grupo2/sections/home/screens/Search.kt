package ar.edu.ort.parcialtp3grupo2.sections.home.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Scaffold
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
import ar.edu.ort.parcialtp3grupo2.ui.components.MyTopAppBar
import ar.edu.ort.parcialtp3grupo2.ui.navigation.BottomBar

@Preview
@Composable
fun SearchScreen() {
    val productRepository =  listOf(
        Product(
            id = "0",
            categoryId = 1,
            name = "Apple",
            price = 3000.0,
            amount = "1kg",
            image = R.drawable.apple,
            detail = "Apples are nutritious. Apples may be good for weight loss. apples may be good for your heart. As part of a healtful and varied diet."
        ),
        Product(
            id = "1",
            name = "Sprite",
            price = 3000.0,
            amount = "330ml",
            image = R.drawable.sprite,
            detail = "Fresh and sweet, always a good choice (of course over seven up)",
            categoryId = 6
        )
    )
    var text by remember { mutableStateOf("") }
    var isSheetOpen by remember {
        mutableStateOf(false)
    }

        Column(
            modifier = Modifier
                .padding()
                .fillMaxWidth()
        ) {

            SearchInput(text = text,
                onTextChange = fun(newText: String) {
                    text = newText
                },
                onClick = { isSheetOpen = true })
            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                verticalArrangement = Arrangement.spacedBy(16.dp),
                horizontalArrangement = Arrangement.spacedBy(16.dp),
                modifier = Modifier
                    .padding()
                    .padding(16.dp)
                    .fillMaxSize()
            ) {
                items(productRepository) { product ->
                    ProductCardCat(product = product)
                }
            }
        }
    }
