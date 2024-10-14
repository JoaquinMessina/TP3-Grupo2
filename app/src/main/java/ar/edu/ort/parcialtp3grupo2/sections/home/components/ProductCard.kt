package ar.edu.ort.parcialtp3grupo2.sections.home.components

import android.net.Uri
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import ar.edu.ort.parcialtp3grupo2.sections.home.data.Product
import ar.edu.ort.parcialtp3grupo2.ui.components.SymbolButton
import ar.edu.ort.parcialtp3grupo2.ui.navigation.AppDestination

@Composable
fun ProductCard(product: Product, navController: NavController) {

    Column(
        modifier = Modifier
            .border(BorderStroke(1.dp, Color(0x1A333333)), RoundedCornerShape(32.dp))
            .padding(16.dp)
            .width(250.dp)
            .clickable {
                val route =
                    "${AppDestination.ProductDetail.route}/${Uri.encode(product.id.toString())}"
                navController.navigate(route)
            },
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
            Image(painter = painterResource(id = product.image) , contentDescription = null)
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
            SymbolButton(symbol = Icons.Default.Add) {}
        }

    }
}