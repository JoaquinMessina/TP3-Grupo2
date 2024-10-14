package ar.edu.ort.parcialtp3grupo2.sections.home.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ar.edu.ort.parcialtp3grupo2.sections.home.data.Product
import ar.edu.ort.parcialtp3grupo2.sections.home.data.ProductRepository
import ar.edu.ort.parcialtp3grupo2.ui.components.GreenButton
import ar.edu.ort.parcialtp3grupo2.ui.components.MyTopAppBar
import ar.edu.ort.parcialtp3grupo2.ui.navigation.BottomBar


@Composable
fun MyFavoriteScreen() {
    Scaffold(
        topBar = {
            MyTopAppBar(
                title = "My Favorite",
                isArrowBack = false,
                navController = null
            )
        },
        bottomBar = {
            BottomBar(currentRoute = "Cart") {
            }
        }
    ) { innerPadding ->
        MyFavoriteContent(modifier = Modifier.padding(innerPadding))
    }
}

@Composable
fun MyFavoriteContent(modifier: Modifier = Modifier) {
    val productRepository = ProductRepository()
    val cartItems = productRepository.getAllData()

    Column(
        modifier = modifier
            .fillMaxSize()
    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            contentPadding = PaddingValues(vertical = 8.dp)
        ) {
            items(cartItems) { product ->
                ProductRowFav(product)
            }
        }
        GreenButton(onClick = {},"Add All To Cart")
    }
}
@Composable
fun ProductRowFav(product: Product) {
    Box(
        modifier = Modifier
            .width(375.17.dp)
            .height(96.98.dp)
            .padding(8.dp)
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.Start
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 4.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = product.name,
                    style = TextStyle(
                        fontSize = 16.sp,
                        color = Color(0xFF181725),
                        letterSpacing = 0.01.sp,
                        lineHeight = 18.sp
                    )
                )
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
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
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.End
                ) {
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
                    )
                    Icon(
                        imageVector = Icons.Default.KeyboardArrowRight,
                        contentDescription = null,
                        modifier = Modifier.size(24.dp)
                    )
                }
            }
        }
    }
}


