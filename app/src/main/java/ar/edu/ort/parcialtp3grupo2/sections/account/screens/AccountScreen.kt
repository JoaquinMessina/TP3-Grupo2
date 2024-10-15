package ar.edu.ort.parcialtp3grupo2.sections.home.account.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.compose.material3.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ExitToApp
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.CreditCard
import androidx.compose.material.icons.outlined.AccountBox
import androidx.compose.material.icons.outlined.ConfirmationNumber
import androidx.compose.material.icons.outlined.Help
import androidx.compose.material.icons.outlined.LocalMall
import androidx.compose.material.icons.outlined.LocationOn
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import ar.edu.ort.parcialtp3grupo2.R
import ar.edu.ort.parcialtp3grupo2.ui.components.GreenButton

@Composable
fun AccountScreen(innerPadding: PaddingValues, isDarkTheme: Boolean, onThemeChange: (Boolean) -> Unit) {

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
            ) {
                Image(painter = painterResource(id = R.drawable.profile),
                    contentDescription = null,
                    modifier = Modifier.fillMaxSize())
            }

            Spacer(modifier = Modifier.size(18.dp))

            Column {
                Row {
                    Text(text = "Afsar Hossen", fontWeight = FontWeight.Bold, fontSize = 20.sp)
                }
                Text(text = "Imshuvo97@gmail.com", fontWeight = FontWeight.Normal, fontSize = 16.sp, color = MaterialTheme.colorScheme.tertiary.copy(alpha = 0.4f))
            }
        }
       Column (
              modifier = Modifier
                .fillMaxWidth(),
              verticalArrangement = Arrangement.spacedBy(0.dp),
       ) {
           HorizontalDivider(thickness = 1.dp)
           Item(icon = Icons.Outlined.LocalMall, name = "Orders")
           HorizontalDivider(thickness = 1.dp)
           Item(icon = Icons.Outlined.AccountBox, name = "My Details")
           HorizontalDivider(thickness = 1.dp)
           Item(icon = Icons.Outlined.LocationOn, name = "Delivery Address")
           HorizontalDivider(thickness = 1.dp)
           Item(icon = Icons.Default.CreditCard, name = "Payment Methods")
           HorizontalDivider(thickness = 1.dp)
           Item(icon = Icons.Outlined.ConfirmationNumber, name = "Promo Card")
           HorizontalDivider(thickness = 1.dp)
           Item(icon = Icons.Outlined.Notifications, name = "Notification")
           HorizontalDivider(thickness = 1.dp)
           Item(icon = Icons.Outlined.Help, name = "Help")
           HorizontalDivider(thickness = 1.dp)
           DarkModeItem(isDarkTheme, onThemeChange)
           HorizontalDivider(thickness = 1.dp)
           
           GreenButton(onClick = { /*TODO*/ }, text ="Log Out", isInverted = true, leftIcon = Icons.AutoMirrored.Filled.ExitToApp)
       }

    }
}


@Composable
fun Item (icon: ImageVector, name: String){
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
            Icon(imageVector = icon,
                contentDescription = null)
            Text(text = name, fontWeight = FontWeight.Bold, fontSize = 18.sp, color = MaterialTheme.colorScheme.tertiary)
            Spacer(modifier = Modifier.weight(1f))
            Icon(
                imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
                contentDescription = null
            )
        }
    }
}

@Composable
fun DarkModeItem(isDarkTheme: Boolean, onThemeChange: (Boolean) -> Unit) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth(),
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            modifier = Modifier
                .fillMaxWidth(),
        ) {
            Text(text = "", fontWeight = FontWeight.Bold, fontSize = 20.sp)
            Text(
                text = "Dark Mode",
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp,
                color = MaterialTheme.colorScheme.tertiary
            )
            Spacer(modifier = Modifier.weight(1f))

            Switch(
                checked = isDarkTheme,
                onCheckedChange = { checked -> onThemeChange(checked) },
                colors = SwitchDefaults.colors(
                    checkedThumbColor = MaterialTheme.colorScheme.primary,
                    checkedTrackColor = MaterialTheme.colorScheme.primary.copy(alpha = 0.5f),
                    uncheckedThumbColor = MaterialTheme.colorScheme.tertiary.copy(alpha = 0.4f),
                    uncheckedTrackColor = MaterialTheme.colorScheme.tertiary.copy(alpha = 0.2f)
                )
            )
        }
    }
}
