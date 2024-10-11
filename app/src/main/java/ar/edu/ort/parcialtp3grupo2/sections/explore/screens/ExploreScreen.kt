package ar.edu.ort.parcialtp3grupo2.sections.explore.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.runtime.remember
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import ar.edu.ort.parcialtp3grupo2.sections.explore.components.CategoryCard
import ar.edu.ort.parcialtp3grupo2.sections.explore.components.SearchInput
import ar.edu.ort.parcialtp3grupo2.sections.explore.data.Category
import ar.edu.ort.parcialtp3grupo2.sections.explore.data.CategoryRepository

@Composable
fun FindProductsScreen(innerPadding: PaddingValues) {
    var text by remember { mutableStateOf("") }

    Column (
        modifier = Modifier
            .padding(innerPadding)
            .fillMaxWidth()
    ){

        SearchInput(text = text, onTextChange = fun( newText: String ){
            text = newText
        })

        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            modifier = Modifier.padding(16.dp),
            contentPadding = PaddingValues(8.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            userScrollEnabled = true,
            verticalArrangement = Arrangement.spacedBy(16.dp),
        ) {
            items(CategoryRepository().getAllData()) { category ->
                CategoryCard(color = category.color, title = category.name) {

                }
            }
        }
    }

}