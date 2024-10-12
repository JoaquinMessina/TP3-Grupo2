package ar.edu.ort.parcialtp3grupo2.ui.navigation
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material.icons.outlined.ShoppingCart
import androidx.compose.material.icons.outlined.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

sealed class BottomNavItem(val route: String, val icon: ImageVector, val label: String) {
    object Shop : BottomNavItem(AppDestination.Shop.route, Icons.Outlined.Home, "Shop")
    object Explore : BottomNavItem(AppDestination.Explore.route, Icons.Outlined.Search, "Explore")
    object Cart : BottomNavItem(AppDestination.Cart.route, Icons.Outlined.ShoppingCart, "Cart")
    object Account : BottomNavItem(AppDestination.Account.route, Icons.Outlined.Person, "Account")
    object Favourites : BottomNavItem(AppDestination.Favourites.route, Icons.Outlined.Star, "Favourites")

}

val bottomNavItems = listOf(
    BottomNavItem.Shop,
    BottomNavItem.Explore,
    BottomNavItem.Cart,
    BottomNavItem.Favourites,
    BottomNavItem.Account,
)

@Composable
fun BottomBar (
    currentRoute: String,
    onNavigate: (String) -> Unit
){
   Box(
       modifier = Modifier
           .fillMaxWidth()
           .shadow(16.dp)
           .clip(RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp))
   ){
       BottomNavigation(
           contentColor = Color.Black,
           backgroundColor = Color.White,
           elevation = 16.dp,
           modifier = Modifier
               .border(
                   width = 0.dp,
                   color = Color.Transparent,
                   shape = RoundedCornerShape(
                       topStart = 32.dp,
                       topEnd = 32.dp
                   ),
               )
               .background(Color.White)
               .fillMaxWidth(),
       ){
           bottomNavItems.forEach { item ->
               val isSelected = currentRoute == item.route
               val color =  if(isSelected) Color(0xFF53B175) else Color.Black
               BottomNavigationItem(
                   modifier = Modifier.padding(0.dp, 8.dp),
                   icon = { Icon(imageVector = item.icon, contentDescription = item.label,tint = color, modifier = Modifier.size(20.dp)) },
                   label = { Text(text = item.label, color = color, fontSize = 11.sp, fontWeight = FontWeight.Bold) },
                   selected = false,
                   onClick = { onNavigate(item.route) }
               )
           }
       }
   }
}