package ar.edu.ort.parcialtp3grupo2.sections.home.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.layout.*
import androidx.compose.ui.graphics.Color
import androidx.compose.foundation.border
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.shape.RoundedCornerShape
import ar.edu.ort.parcialtp3grupo2.ui.components.SymbolButton
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.navigation.NavController
import ar.edu.ort.parcialtp3grupo2.sections.home.data.Product


@Composable
fun AddressName(){
    Row (
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center,

    ){
        Text(text = "Address Name", fontSize = 18.sp, fontWeight = FontWeight(700))
    }
}

@Composable
fun Banner(){
    Row (
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center,

    ){
        Text(text = "Banner", fontSize = 18.sp, fontWeight = FontWeight(700))
    }
}

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
        Button(onClick = { navController.navigate("account") }) {
            Text("Go to Account")
        }
        Spacer(modifier = Modifier.height(16.dp))
        Banner()
        Spacer(modifier = Modifier.height(16.dp))
        SectionTitle("Exclusive Offer")
        ProductSection(viewModel.products)
        Spacer(modifier = Modifier.height(16.dp))
        SectionTitle("Best Selling")
        ProductSection(viewModel.products)
    }
}

@Composable
fun SectionTitle(title: String) {
    Row (
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp, 16.dp)
    ){
        Text(
            text = title,
            fontSize = 24.sp,
            fontWeight = FontWeight(700),
        )

        Text(text = "See all", fontSize = 16.sp, fontWeight = FontWeight.Bold, color = Color(0xFF53B175))
    }
}

@Composable
fun ProductCard(product: Product) {
    Column(
        modifier = Modifier
            .border(BorderStroke(1.dp, Color(0x1A333333)), RoundedCornerShape(32.dp))
            .padding(16.dp)
            .width(250.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row (
            modifier = Modifier
                .fillMaxWidth()
                .height(150.dp)
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ){
            Text(
                text = "Imagen",
                fontSize = 14.sp,
                color = Color.Gray,
            )
        }
        Column(
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = product.name,
                fontSize = 18.sp,
                fontWeight = FontWeight(700),
            )
            Text(
                text = product.detail,
                fontSize = 14.sp,
                color = Color.Gray,
            )

        }
        Spacer(modifier = Modifier.height(38.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ){
            Text(
                text = product.price.toString(),
                fontSize = 24.sp,
                fontWeight = FontWeight(700),
                modifier = Modifier.padding(16.dp)
            )
            SymbolButton(symbol = "+") {}
        }

    }
}

@Composable
fun ProductSection(products: List<Product> = listOf()) {
    Row(
        modifier = Modifier
            .padding(16.dp)
            .horizontalScroll(rememberScrollState()) // Hace que la fila sea scrollable horizontalmente
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ){
        products.forEach { product ->
            ProductCard(product)
            Spacer(modifier = Modifier.width(16.dp))
        }
    }
}