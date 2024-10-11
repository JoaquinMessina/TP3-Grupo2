package ar.edu.ort.parcialtp3grupo2.ui.navigation
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import ar.edu.ort.parcialtp3grupo2.sections.explore.screens.FindProductsScreen
import ar.edu.ort.parcialtp3grupo2.sections.home.account.screens.AccountScreen
import ar.edu.ort.parcialtp3grupo2.sections.home.screens.ShopScreen

@Composable
fun NavGraph(navController: NavHostController, innerPadding: PaddingValues) {
    NavHost(navController = navController, startDestination = AppDestination.Shop.route) {
        composable(AppDestination.Shop.route) {
           ShopScreen(innerPadding, navController)
        }
        composable(AppDestination.Account.route) {
            AccountScreen(innerPadding, navController)
        }
        composable(AppDestination.Explore.route) {
            FindProductsScreen(innerPadding = innerPadding)
        }
    }
}