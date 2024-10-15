package ar.edu.ort.parcialtp3grupo2.ui.navigation
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import ar.edu.ort.parcialtp3grupo2.R
import ar.edu.ort.parcialtp3grupo2.sections.auth.navigation.AuthNavGraph
import ar.edu.ort.parcialtp3grupo2.sections.explore.screens.FindProductsScreen
import ar.edu.ort.parcialtp3grupo2.sections.home.account.screens.AccountScreen
import ar.edu.ort.parcialtp3grupo2.sections.home.screens.CategoriesScreen
import ar.edu.ort.parcialtp3grupo2.sections.home.screens.MyCartContent
import ar.edu.ort.parcialtp3grupo2.sections.home.screens.MyFavoriteScreen
import ar.edu.ort.parcialtp3grupo2.sections.home.screens.ShopScreen
import ar.edu.ort.parcialtp3grupo2.sections.home.screens.productDetail.ProductDetailScreen
import ar.edu.ort.parcialtp3grupo2.sections.orderAccepted.OrderAcceptedScreen


@Composable
fun NavGraph(navController: NavHostController, innerPadding: PaddingValues, isDarkTheme: Boolean, onThemeChange: (Boolean) -> Unit) {
    NavHost(navController = navController, startDestination = AppDestination.Auth.route) {
        composable(AppDestination.Auth.route) {
            var authNavController = rememberNavController()
            AuthNavGraph(
                 authNavController,
                globalController = navController,
                innerPadding = innerPadding
            )
        }
        composable(AppDestination.Shop.route) {
           ShopScreen(innerPadding, navController)
        }

        composable(AppDestination.Cart.route) {
            MyCartContent(innerPadding, navController)
        }

        composable(AppDestination.Account.route) {
            AccountScreen(innerPadding, isDarkTheme = isDarkTheme, onThemeChange = onThemeChange)
        }
        composable(AppDestination.Explore.route) {
            FindProductsScreen(innerPadding = innerPadding)
        }
        composable(AppDestination.ProductDetail.route + "/{id}",
            arguments = listOf(navArgument(name = "id"){type = NavType.StringType})
       ) {backStackEntry ->
           val id = backStackEntry.arguments?.getString("id") ?: "0"
          ProductDetailScreen(innerPadding = innerPadding, id)
        }
        composable(AppDestination.OrderAccepted.route) {
            OrderAcceptedScreen(innerPadding = innerPadding, navController)
        }
        composable(AppDestination.Categories.route) {
            CategoriesScreen(innerPadding = innerPadding)
        }
        composable(AppDestination.Favourites.route) {
            MyFavoriteScreen(navController)
        }

    }

}