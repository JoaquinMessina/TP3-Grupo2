package ar.edu.ort.parcialtp3grupo2.sections.home.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.navigation.NavController
import ar.edu.ort.parcialtp3grupo2.sections.home.components.ProductSection
import ar.edu.ort.parcialtp3grupo2.sections.home.components.ShopBanner
import ar.edu.ort.parcialtp3grupo2.sections.home.components.AddressName

@Composable
fun ShopScreen(innerPadding: PaddingValues, navController: NavController) {
    // implement the view model here
    val viewModel = ShopScreenViewModel()

    Column(
        modifier = Modifier
            .padding(innerPadding)
            .verticalScroll(
                rememberScrollState()
            )
    ) {
        AddressName()
        Spacer(modifier = Modifier.height(16.dp))

        ShopBanner()
        Spacer(modifier = Modifier.height(16.dp))

        ProductSection(title="Exclusive Offer", viewModel.products, navController)
        Spacer(modifier = Modifier.height(16.dp))
        ProductSection(title= "Best Selling",viewModel.products, navController)
    }
}




