package ar.edu.ort.parcialtp3grupo2.sections.home.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ar.edu.ort.parcialtp3grupo2.sections.home.components.CheckoutBottomSheet
import ar.edu.ort.parcialtp3grupo2.sections.home.data.Product
import ar.edu.ort.parcialtp3grupo2.sections.home.data.ProductRepository
import ar.edu.ort.parcialtp3grupo2.ui.components.GreenButtonRightText
import ar.edu.ort.parcialtp3grupo2.ui.components.MyTopAppBar
import ar.edu.ort.parcialtp3grupo2.ui.navigation.BottomBar

@Preview
@Composable
fun MyCartScreen() {
    Scaffold(
        topBar = {
            MyTopAppBar(
                title = "My Cart",
                isArrowBack = false,
                navController = null
            )
        },
        bottomBar = {
            BottomBar(currentRoute = "Cart") {
            }
        }
    ) { innerPadding ->
        MyCartContent(modifier = Modifier.padding(innerPadding))
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyCartContent(modifier: Modifier = Modifier) {
    val sheetState = rememberModalBottomSheetState(skipPartiallyExpanded = true )
    var isSheetopen by remember {
        mutableStateOf(false)
    }
    val productRepository = ProductRepository()
    val cartItems = productRepository.getAllData()

    Column(
        modifier = modifier.fillMaxSize()
    ) {
        Divider(color = Color.LightGray, thickness = 0.7.dp)
        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            contentPadding = PaddingValues(vertical = 8.dp),
        ) {
            items(cartItems) { product ->
                ProductRow(product)
                Box(modifier = Modifier.padding(horizontal = 25.dp)) { // Ajusta el padding como desees
                    Divider(color = Color.LightGray, thickness = 0.7.dp)
                }
            }
        }
        Divider(color = Color.LightGray, thickness = 0.7.dp)
        GreenButtonRightText(onClick = { isSheetopen = true }, text="Go to Checkout", rightText = "$1500")
        if(isSheetopen){
            CheckoutBottomSheet(onDismiss = { isSheetopen = false }, sheetState = sheetState)

        }
    }
}



@Composable
fun ProductRow(product: Product) {
    Column(
        modifier = Modifier
            .width(375.17.dp)
            .height(96.98.dp)
            .padding(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            text = product.name,
            style = TextStyle(
                fontSize = 16.sp,
                color = Color(0xFF181725),
                letterSpacing = 0.01.sp,
                lineHeight = 18.sp
            ),
            modifier = Modifier.padding(bottom = 4.dp)
        )

        Text(
            text = "${product.amount}, Price",
            style = TextStyle(
                fontSize = 14.sp,
                color = Color(0xFF7C7C7C),
                lineHeight = 18.sp,
                letterSpacing = 0.sp
            ),
            modifier = Modifier.padding(bottom = 4.dp)
        )
        Text(
            text = "$${product.price}",
            style = TextStyle(
                fontSize = 18.sp,
                color = Color(0xFF181725),
                letterSpacing = 0.01.sp,
                lineHeight = 27.sp
            ),
            modifier = Modifier
                .width(49.38.dp)
                .height(27.dp)
                .padding(top = 4.dp)
                .align(Alignment.End)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyCartScreen()
}