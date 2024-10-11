package ar.edu.ort.parcialtp3grupo2.sections.home.account.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.compose.material3.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ExitToApp
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Switch
import androidx.compose.material3.VerticalDivider
import ar.edu.ort.parcialtp3grupo2.ui.components.GreenButton

@Composable
fun AccountScreen(innerPadding: PaddingValues,navController: NavController) {

    Column(
        modifier = Modifier
            .padding(innerPadding)
            .fillMaxWidth()
,        verticalArrangement = Arrangement.spacedBy(16.dp),
    ) {


        Row  (
            verticalAlignment = Alignment.CenterVertically,
           modifier = Modifier
               .padding(32.dp, 16.dp)
               .fillMaxWidth(),
        ){
            Box (
                modifier = Modifier
                    .size(65.dp)
                    .clip(RoundedCornerShape((27.dp)))
                    .background(Color.Red)
            ) {
            }

            Spacer(modifier = Modifier.size(18.dp))

            Column {
                Row {
                    Text(text = "Afsar Hossen", fontWeight = FontWeight.Bold, fontSize = 20.sp)
                }
                Text(text = "Imshuvo97@gmail.com", fontWeight = FontWeight.Normal, fontSize = 16.sp, color = Color(0x7C7C7CFF))
            }
        }
       Column (
              modifier = Modifier
                .fillMaxWidth(),
              verticalArrangement = Arrangement.spacedBy(0.dp),
       ) {
           HorizontalDivider(thickness = 1.dp)
           Item(icon = "📦", name = "Orders")
           HorizontalDivider(thickness = 1.dp)
           Item(icon = "🛒", name = "My Details")
           HorizontalDivider(thickness = 1.dp)
           Item(icon = "🛠", name = "Delivery Address")
           HorizontalDivider(thickness = 1.dp)
           Item(icon = "🔒", name = "Payment Methods")
           HorizontalDivider(thickness = 1.dp)
           Item(icon = "🔔", name = "Promo Card")
           HorizontalDivider(thickness = 1.dp)
           Item(icon = "🔗", name = "Notification")
           HorizontalDivider(thickness = 1.dp)
           Item(icon = "🔗", name = "Help")
           HorizontalDivider(thickness = 1.dp)
           DarkModeItem()
           HorizontalDivider(thickness = 1.dp)
           
           GreenButton(onClick = { /*TODO*/ }, text ="Log Out", isInverted = true, leftIcon = Icons.AutoMirrored.Filled.ExitToApp)
       }

    }
}


@Composable
fun Item (icon: String, name: String){
    Row (
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth(),
    ){
        Spacer(modifier = Modifier.size(18.dp))

        Row (
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            modifier = Modifier
                .fillMaxWidth(),
        ){
            Text(text = icon, fontWeight = FontWeight.Bold, fontSize = 20.sp)
            Text(text = name, fontWeight = FontWeight.Bold, fontSize = 18.sp, color = Color.Black)
            Spacer(modifier = Modifier.weight(1f))
            Icon(
                imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
                contentDescription = null
            )
        }
    }
}

@Composable
fun DarkModeItem (){
    Row (
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth(),
    ){
        Row (
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            modifier = Modifier
                .fillMaxWidth(),
        ){
            Text(text = "", fontWeight = FontWeight.Bold, fontSize = 20.sp)
            Text(text = "Dark Mode", fontWeight = FontWeight.Bold, fontSize = 18.sp, color = Color.Black)
            Spacer(modifier = Modifier.weight(1f))
            Switch(checked = true, onCheckedChange = fun(checked: Boolean) {
                // Handle the change
            })
        }
    }
}