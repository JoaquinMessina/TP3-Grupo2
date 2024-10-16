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
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
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
            .fillMaxSize()
            .verticalScroll(
                rememberScrollState()
            )
    ) {
        Spacer(modifier = Modifier.height(16.dp))
        AddressName()
        Spacer(modifier = Modifier.height(4.dp))

        ShopBanner()

        ProductSection(title="Exclusive Offer", viewModel.products, navController)
        Spacer(modifier = Modifier.height(16.dp))
        ProductSection(title= "Best Selling",viewModel.products, navController)
    }
}

@Preview (showBackground = true)
@Composable
fun test(){
    val navController = rememberNavController()
    ShopScreen(innerPadding = PaddingValues(), navController )
}




