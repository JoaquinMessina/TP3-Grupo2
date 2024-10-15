package ar.edu.ort.parcialtp3grupo2.sections.orderAccepted


import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import ar.edu.ort.parcialtp3grupo2.R
import ar.edu.ort.parcialtp3grupo2.ui.components.GreenButtonRightText
import ar.edu.ort.parcialtp3grupo2.ui.navigation.AppDestination


@Composable
fun OrderAcceptedScreen(innerPadding: PaddingValues, navController: NavController) {
    Column(
        modifier = Modifier
            .padding(innerPadding)
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(25.dp))
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(400.dp),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(id = R.drawable.check),
                    contentDescription = "Order Confirmed",
                    modifier = Modifier
                        .width(269.dp)
                        .height(240.dp)
                )
            }
            OrderAcceptedBody()
        }

        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            GreenButtonRightText(onClick = { navController.navigate(AppDestination.Shop.route) }, text = "Track Order")
            BackButton(navController)
            Spacer(modifier = Modifier.height(24.dp))
        }
    }
}



@Composable
fun OrderAcceptedBody() {

            Text(
                text = "Your Order has been\naccepted",
                fontSize = 27.sp,
                style = MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.Bold),
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(20.dp))

            Text(
                text = "Your items has been placed and is on\nits way to being processed",
                fontSize = 16.sp,
                textAlign = TextAlign.Center,
                color = Color.Gray
            )

            Spacer(modifier = Modifier.height(24.dp))
}

@Composable
fun BackButton(navController: NavController) {
    Button(
        onClick = {navController.navigate(AppDestination.Shop.route)},
        modifier = Modifier
            .fillMaxWidth()
            .height(60.dp)
            .padding(horizontal = 16.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.Transparent
        )
    ) {
        Text(
            text = "Back to Home",
            fontSize = 16.sp,
            style = MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.Bold)
        )
    }
}


