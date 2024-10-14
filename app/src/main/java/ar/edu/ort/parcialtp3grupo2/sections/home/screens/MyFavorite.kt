package ar.edu.ort.parcialtp3grupo2.sections.home.screens

import androidx.compose.foundation.background
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ar.edu.ort.parcialtp3grupo2.sections.home.components.Counter
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

/**
 * Counter(num = num, onIncrement = {
 *                     num++
 *                 }, onDecrement = {
 *                     if (num > 0) {
 *                         num--
 *                     }
 *                 })
 */

@Composable
fun MyFavoriteContent(modifier: Modifier = Modifier) {
    val productRepository = ProductRepository()
    val cartItems = productRepository.getAllData()



    Column(
        modifier = modifier
            .fillMaxSize()
    ) {
        HorizontalDivider(
            color = Color(0xFFE2E2E2),
        )
        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            contentPadding = PaddingValues(vertical = 8.dp)
        ) {
            items(cartItems) { product ->
                val isFirstItem = cartItems.indexOf(product) == 0
                val isLastItem = cartItems.indexOf(product) == cartItems.size - 1

                if(!isFirstItem){
                    HorizontalDivider(
                        modifier = Modifier.padding(horizontal = 16.dp),
                        color = Color(0xFFE2E2E2),
                    )
                }

                ProductRowFav(product)

                if(isLastItem){
                    HorizontalDivider(
                        color = Color(0xFFE2E2E2),
                    )
                }

            }
        }

        GreenButton(onClick = {},"Add All To Cart")
    }
}
@Composable
fun ProductRowFav(product: Product) {
    Box(
        modifier = Modifier
    ) {
        Column(
                modifier = Modifier
            ) {
                Text(
                    text = product.name,
                    modifier    = Modifier.padding(bottom = 8.dp),
                    style = TextStyle(
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFF181725),
                        letterSpacing = 0.01.sp,
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
                    ),
                )
                    Text(
                        text = "$${product.price}",
                        style = TextStyle(
                            letterSpacing = 0.01.sp,
                            lineHeight = 27.sp
                        ),
                    )
                    Icon(
                        imageVector = Icons.Default.KeyboardArrowRight,
                        contentDescription = null,
                        modifier = Modifier.size(24.dp)
                    )
                }
        }
}


