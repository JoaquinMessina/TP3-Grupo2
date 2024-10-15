package ar.edu.ort.parcialtp3grupo2.sections.home.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Divider
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import ar.edu.ort.parcialtp3grupo2.sections.home.components.CheckoutBottomSheet
import ar.edu.ort.parcialtp3grupo2.sections.home.components.Counter
import ar.edu.ort.parcialtp3grupo2.sections.home.data.Product
import ar.edu.ort.parcialtp3grupo2.sections.home.data.ProductRepository
import ar.edu.ort.parcialtp3grupo2.sections.home.screens.productDetail.ProductDetailScreen
import ar.edu.ort.parcialtp3grupo2.ui.components.GreenButtonRightText


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyCartContent(innerPadding: PaddingValues, navController: NavController) {
    val sheetState = rememberModalBottomSheetState(skipPartiallyExpanded = true)
    var isSheetopen by remember { mutableStateOf(false) }
    val productRepository = ProductRepository()
    val cartItems = productRepository.getAllData()

    Column(
        modifier = Modifier
            .fillMaxSize() // Ocupa toda la pantalla
            .padding(innerPadding)
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
                Box(modifier = Modifier.padding(horizontal = 25.dp)) {
                    Divider(color = Color.LightGray, thickness = 0.7.dp)
                }
            }
        }
        Spacer(modifier = Modifier.height(16.dp))
        GreenButtonRightText(onClick = { isSheetopen = true }, text = "Go to Checkout", rightText = "$1500")
        if (isSheetopen) {
            CheckoutBottomSheet(onDismiss = { isSheetopen = false }, sheetState = sheetState, navController)
        }
    }
}

@Composable
fun ProductRow(product: Product) {
    var counter by remember { mutableStateOf(0) }
    Row(
        modifier = Modifier
            .width(375.dp)
            .height(180.dp)
            .padding(20.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = product.image),
            contentDescription = product.name,
            modifier = Modifier
                .size(80.69.dp)
                .padding(end = 8.dp)
        )
        Column(
            modifier = Modifier
                .weight(1f)
                .fillMaxHeight(),
            verticalArrangement = Arrangement.Center
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = product.name,
                    style = TextStyle(
                        fontSize = 16.sp,
                        letterSpacing = 0.01.sp,
                        lineHeight = 18.sp
                    )
                )
                Icon(
                    imageVector = Icons.Default.Close,
                    contentDescription = "Close",
                    modifier = Modifier
                        .padding(start = 8.dp)
                        .size(24.dp)
                )
            }
            Text(
                text = "${product.amount}, Price",
                style = TextStyle(
                    fontSize = 14.sp,
                    color = Color(0xFF7C7C7C),
                    lineHeight = 18.sp,
                    letterSpacing = 0.sp
                ),
                modifier = Modifier.align(Alignment.Start)
            )
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Counter(counter, onDecrement = { if (counter > 0) counter-- }, onIncrement = { counter++ })
                Text(
                    text = "$${product.price}",
                    style = TextStyle(
                        fontSize = 16.sp,
                        letterSpacing = 0.01.sp,
                        lineHeight = 27.sp
                    ),
                    modifier = Modifier
                        .padding(start = 16.dp)
                        .wrapContentWidth(Alignment.End)
                )
            }
        }
    }
}


