package ar.edu.ort.parcialtp3grupo2.sections.home.screens


import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ar.edu.ort.parcialtp3grupo2.sections.home.data.Product
import ar.edu.ort.parcialtp3grupo2.ui.components.MyTopAppBar
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import ar.edu.ort.parcialtp3grupo2.sections.home.data.ProductRepository

@Composable
fun CategoriesScreen(innerPadding: PaddingValues) {
    val productRepository = ProductRepository()
    val productsByCategory =productRepository.getByCategoryId(1);

    Scaffold(
        topBar = {
            MyTopAppBar(
                title = "PONER CATEGORIA",
                isArrowBack = true,
                navController = null
            )
        },
    ) { paddingValues ->
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            modifier = Modifier
                .padding(paddingValues)
                .padding(16.dp)
                .fillMaxSize()
        ) {
            items(productsByCategory) { product ->
                ProductCardCat(product = product)
            }
        }
    }
}


@Composable
fun ProductCardCat(product: Product) {
    Column(
        modifier = Modifier
            .size(width = 173.32.dp, height = 248.51.dp)
            .border(BorderStroke(1.dp, MaterialTheme.colorScheme.outline), RoundedCornerShape(32.dp))
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(89.dp)
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Image(painter = painterResource(id = product.image) , contentDescription = null)
        }
        Column(
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = product.name,
                fontSize = 16.sp,
                fontWeight = FontWeight(700),
            )
            Text(
                text = "${product.amount}, Price",
                fontSize = 14.sp,
                color = MaterialTheme.colorScheme.secondary,
                lineHeight = 18.sp,
                fontWeight = FontWeight.Medium,
                modifier = Modifier
            )
        }
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "$${product.price}",
                fontSize = 18.sp,
                fontWeight = FontWeight(700),
                modifier = Modifier
                    .align(Alignment.CenterVertically)
            )
            SymbolButtonCat(symbol = "+") {}
        }

    }
}
@Composable
fun SymbolButtonCat(symbol: String, onClick: () -> Unit) {
    Button(
        onClick = onClick,
        modifier = Modifier
            .size(45.67.dp)
            .padding(0.dp),
        contentPadding = PaddingValues(0.dp),
        shape = RoundedCornerShape(12.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = MaterialTheme.colorScheme.primary
        ),
        elevation = ButtonDefaults.buttonElevation(0.dp)
    ) {
        Text(text = symbol, fontSize = 24.sp, color = Color.White)
    }
}
