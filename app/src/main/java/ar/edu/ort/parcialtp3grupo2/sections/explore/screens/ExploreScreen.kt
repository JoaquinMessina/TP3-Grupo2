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
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.SheetValue
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import ar.edu.ort.parcialtp3grupo2.sections.explore.components.CategoryCard
import ar.edu.ort.parcialtp3grupo2.sections.explore.components.SearchInput
import ar.edu.ort.parcialtp3grupo2.sections.explore.data.Category
import ar.edu.ort.parcialtp3grupo2.sections.explore.data.CategoryRepository
import ar.edu.ort.parcialtp3grupo2.sections.home.components.FiltersBottomSheet
import ar.edu.ort.parcialtp3grupo2.sections.home.screens.ShopScreenViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FindProductsScreen(innerPadding: PaddingValues, navController: NavController) {
    var text by remember { mutableStateOf("") }
    val viewModel = ExploreScreenViewModel()
    val sheetState = rememberModalBottomSheetState(skipPartiallyExpanded = true )
    var isSheetopen by remember {
        mutableStateOf(false)
    }

    if(text != ""){
        SearchScreen(
            text = text,
            onTextChange = fun(newText: String){
                text = newText
            }
        )
    }else{
    Column (
        modifier = Modifier
            .padding(innerPadding)
            .fillMaxWidth()
    ){

        SearchInput(
            text = text,
            onTextChange = fun( newText: String){
            text = newText
        },
            onClick = { isSheetopen = true })

        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            modifier = Modifier.padding(16.dp),
            contentPadding = PaddingValues(8.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            userScrollEnabled = true,
            verticalArrangement = Arrangement.spacedBy(16.dp),
        ) {
            items(viewModel.getAllCategories()) { category ->
                CategoryCard(color = category.color, image = category.image, title = category.name, navController = navController)
            }
        }
        if(isSheetopen){
            FiltersBottomSheet(onDismiss = { isSheetopen = false }, sheetState = sheetState)
        }

    }
    }

}