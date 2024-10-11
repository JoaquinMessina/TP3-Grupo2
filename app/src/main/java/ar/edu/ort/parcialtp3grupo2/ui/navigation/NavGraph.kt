package ar.edu.ort.parcialtp3grupo2.ui.navigation
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import ar.edu.ort.parcialtp3grupo2.sections.find_product.screens.FindProductsScreen
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
        composable(AppDestination.FindProducts.route) {
            val categories = listOf(
                Color.Red to "Fresh Fruits & Vegetable",
                Color.Blue to "Fresh Fruits & Vegetable",
                Color.Green to "Fresh Fruits & Vegetable",
                Color.Yellow to "Fresh Fruits & Vegetable",
                Color.Magenta to "Fresh Fruits & Vegetable",
                Color.Cyan to "Fresh Fruits & Vegetable",
                Color.Gray to "Fresh Fruits & Vegetable",
                Color.LightGray to "Fresh Fruits & Vegetable",
                Color.DarkGray to "Fresh Fruits & Vegetable",
                Color.Black to "Fresh Fruits & Vegetable",
            )
            FindProductsScreen(innerPadding = innerPadding, categories = categories) {
            }
        }
    }
}