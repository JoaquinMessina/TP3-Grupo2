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
import ar.edu.ort.parcialtp3grupo2.sections.explore.components.SearchInput
import ar.edu.ort.parcialtp3grupo2.sections.home.data.ProductRepository
import ar.edu.ort.parcialtp3grupo2.ui.components.MyTopAppBar
import ar.edu.ort.parcialtp3grupo2.ui.navigation.BottomBar


@Composable
fun SearchScreen(innerPadding: PaddingValues) {
    val productRepository = ProductRepository()
    val productsByCategory = productRepository.getByCategoryId(1);
    var text by remember { mutableStateOf("") }
    var isSheetOpen by remember {
        mutableStateOf(false)
    }
    Scaffold(
        topBar = {
            MyTopAppBar(
                title = "Search",
                isArrowBack = false,
                navController = null
            )
        },
        bottomBar = {
            BottomBar(currentRoute = "Explore") {
            }
        }

    ) { paddingValues ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
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
                    .padding(paddingValues)
                    .padding(16.dp)
                    .fillMaxSize()
            ) {
                items(productsByCategory) { product ->
                    ProductCardCat(product = product)
                }
            }
        }
    }
}