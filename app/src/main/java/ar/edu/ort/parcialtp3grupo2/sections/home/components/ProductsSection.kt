package ar.edu.ort.parcialtp3grupo2.sections.home.components

import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import ar.edu.ort.parcialtp3grupo2.sections.home.data.Product

@Composable
fun ProductSection(title:String, products: List<Product> = listOf(), navController: NavController) {
    Column (
        modifier = Modifier.fillMaxWidth().padding(
            bottom =  16.dp,
        )
    ) {
        SectionTitle(title)
        Row(
            modifier = Modifier
                .horizontalScroll(rememberScrollState()) // Hace que la fila sea scrollable horizontalmente
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ){
            products.forEach { product ->
                ProductCard(product, navController)
                Spacer(modifier = Modifier.width(16.dp))
            }
        }
    }
}