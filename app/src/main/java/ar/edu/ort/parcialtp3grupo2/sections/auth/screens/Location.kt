package ar.edu.ort.parcialtp3grupo2.sections.auth.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import ar.edu.ort.parcialtp3grupo2.R
import ar.edu.ort.parcialtp3grupo2.sections.auth.components.DropDownMenuPersonal
import ar.edu.ort.parcialtp3grupo2.ui.components.GreenButton
import ar.edu.ort.parcialtp3grupo2.ui.navigation.AppDestination

@Composable
fun Location(
    innerPadding: PaddingValues,
    globalController: NavHostController
) {
    val zones = listOf(
        "Buenos Aires",
        "Catamarca",
        "Chaco",
        "Chubut",
        "Córdoba",
        "Corrientes",
        "Entre Ríos",
        "Formosa",
        "Jujuy",
        "La Pampa",
        "La Rioja",
        "Mendoza",
        "Misiones",
        "Neuquén",
        "Río Negro",
        "Salta",
        "San Juan",
        "San Luis",
        "Santa Cruz",
        "Santa Fe",
        "Santiago del Estero",
        "Tierra del Fuego",
        "Tucumán"
    )

    val areas = listOf(
        "Buenos Aires",
        "Córdoba",
        "Rosario",
        "Mendoza",
        "San Miguel de Tucumán",
        "La Plata",
        "Mar del Plata",
        "Salta",
        "Santa Fe",
        "San Juan",
        "Resistencia",
        "Santiago del Estero",
        "Corrientes",
        "Posadas",
        "San Salvador de Jujuy",
        "Bahía Blanca",
        "Paraná",
        "Neuquén",
        "Formosa",
        "San Fernando del Valle de Catamarca"
    )

    val scrollState = rememberScrollState()

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ) {
        if(!isSystemInDarkTheme()) {
            Image(
                painter = painterResource(id = R.drawable.login_background),
                contentDescription = "login background",
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop
            )
        }
        Column(
            modifier = Modifier
                .align(Alignment.Center)
                .padding(16.dp)
                .verticalScroll(scrollState),
            horizontalAlignment = Alignment.CenterHorizontally

        ) {
            Image(painter = painterResource(id = R.drawable.location),
                contentDescription = "carrot",
                modifier = Modifier.padding(40.dp)
            )

            Text(text = "Select your location",
                modifier = Modifier
                    .padding(horizontal = 16.dp),
                fontSize = 26.sp,
                fontWeight = FontWeight.Bold)


            Text(text = "Swithch on your location to stay in tune with what’s happening in your area",
                modifier = Modifier
                    .padding(horizontal = 16.dp, vertical = 12.dp),
                fontSize = 16.sp,
                color = Color(0xFF7C7C7C),
                textAlign = TextAlign.Center
                )

            Spacer(modifier = Modifier.height(50.dp))

            DropDownMenuPersonal(text = "Your Zone", options = zones)

            Spacer(modifier = Modifier.height(36.dp))

            DropDownMenuPersonal(text = "Your Area", options = areas)

            Spacer(modifier = Modifier.height(12.dp))

            GreenButton(onClick = {
                globalController.navigate(
                    AppDestination.Shop.route
                )
            }, text = "Submit")


        }
    }



}

