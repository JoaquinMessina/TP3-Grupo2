package ar.edu.ort.parcialtp3grupo2.sections.home.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Divider
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import ar.edu.ort.parcialtp3grupo2.sections.auth.navigation.AuthDestination
import ar.edu.ort.parcialtp3grupo2.sections.home.data.Product
import ar.edu.ort.parcialtp3grupo2.sections.home.data.ProductRepository
import ar.edu.ort.parcialtp3grupo2.ui.components.GreenButton
import ar.edu.ort.parcialtp3grupo2.ui.components.MyTopAppBar
import ar.edu.ort.parcialtp3grupo2.ui.navigation.AppDestination
import ar.edu.ort.parcialtp3grupo2.ui.navigation.BottomBar


@Composable
fun MyFavoriteScreen(navController: NavController) {
    Scaffold(
        topBar = {
            MyTopAppBar(
                title = "My Favorite",
                isArrowBack = false,
                navController = navController
            )
        },
        bottomBar = {
            BottomBar(currentRoute = "Cart") {
            }
        }
    ) { innerPadding ->
        MyFavoriteContent(modifier = Modifier.padding(innerPadding), navController = navController)
    }
}

@Composable
fun MyFavoriteContent(modifier: Modifier = Modifier, navController: NavController) {
    val productRepository = ProductRepository()
    val cartItems = productRepository.getAllData()

    Column(
        modifier = modifier
            .fillMaxSize()
    ) {
        Divider(color = Color.LightGray, thickness = 0.7.dp)
        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            contentPadding = PaddingValues(vertical = 8.dp)
        ) {
            items(cartItems) { product ->
                ProductRowFav(product)
                Box(modifier = Modifier.padding(horizontal = 25.dp)) {
                    Divider(color = Color.LightGray, thickness = 0.7.dp)
                }
            }
        }
        Divider(color = Color.LightGray, thickness = 0.7.dp)
        GreenButton(onClick = {
            navController.navigate(AppDestination.Cart.route)
        }, "Add All To Cart")
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
        Row(
            modifier = Modifier.fillMaxSize(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = product.image),
                contentDescription = product.name,
                modifier = Modifier
                    .size(55.69.dp)
                    .padding(end = 8.dp)
            )
            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(end = 8.dp),
                verticalArrangement = Arrangement.Center
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
                Text(
                    text = "${product.amount}, Price",
                    style = TextStyle(
                        fontSize = 14.sp,
                        color = Color(0xFF7C7C7C),
                        lineHeight = 18.sp,
                        letterSpacing = 0.sp
                    )
                )
            }
            Text(
                text = "$${product.price}",
                style = TextStyle(
                    fontSize = 18.sp,
                    color = Color(0xFF181725),
                    letterSpacing = 0.01.sp,
                    lineHeight = 27.sp
                ),
                modifier = Modifier
                    .align(Alignment.CenterVertically)
                    .padding(end = 8.dp)
            )
            Icon(
                imageVector = Icons.Default.KeyboardArrowRight,
                contentDescription = null,
                modifier = Modifier.size(24.dp)
            )
        }
    }
}

