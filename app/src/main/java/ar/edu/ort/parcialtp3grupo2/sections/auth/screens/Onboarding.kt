package ar.edu.ort.parcialtp3grupo2.sections.auth.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import ar.edu.ort.parcialtp3grupo2.R
import ar.edu.ort.parcialtp3grupo2.sections.auth.navigation.AuthDestination
import ar.edu.ort.parcialtp3grupo2.ui.components.GreenButton

@Composable
fun Onboarding(
    innerPadding: PaddingValues,
    authController: NavHostController
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        Image(
            painter = painterResource(id = R.drawable.onbording_background),
            contentDescription = "onboarding background",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )
        Column(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally

        ) {
            Image(painter = painterResource(id = R.drawable.carrot),
                contentDescription = "carrot",
                modifier = Modifier.padding(16.dp)
                )
            Text(
                text = "Welcome",
                color = Color.White,
                fontSize = 48.sp,
                fontWeight = FontWeight.Bold

            )
            Text(
                text = "to our store",
                color = Color.White,
                modifier = Modifier.padding(bottom = 8.dp),
                fontSize = 48.sp,
                fontWeight = FontWeight.Bold

            )
            Text(
                text = "Get your groceries in as fast as one hour",
                color = Color(0xB3FCFCFC),
                fontSize = 16.sp,
                modifier = Modifier.padding(bottom = 8.dp)

            )
            GreenButton(onClick = {
                authController.navigate(AuthDestination.Login.route)
            }, text = "Get Started")
            Spacer(modifier = Modifier.height(36.dp))
        }
    }
}
