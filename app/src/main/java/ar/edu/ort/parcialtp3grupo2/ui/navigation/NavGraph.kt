package ar.edu.ort.parcialtp3grupo2.ui.navigation
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import ar.edu.ort.parcialtp3grupo2.sections.auth.navigation.AuthNavGraph
import ar.edu.ort.parcialtp3grupo2.sections.auth.screens.Login
import ar.edu.ort.parcialtp3grupo2.sections.explore.screens.FindProductsScreen
import ar.edu.ort.parcialtp3grupo2.sections.home.account.screens.AccountScreen
import ar.edu.ort.parcialtp3grupo2.sections.home.screens.MyCartScreen
import ar.edu.ort.parcialtp3grupo2.sections.home.screens.MyFavoriteScreen
import ar.edu.ort.parcialtp3grupo2.sections.home.screens.ShopScreen

@Composable
fun NavGraph(navController: NavHostController, innerPadding: PaddingValues) {
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
            MyCartScreen()
        }

        composable(AppDestination.Favourites.route) {
            MyFavoriteScreen()
        }

        composable(AppDestination.Account.route) {
            AccountScreen(innerPadding, navController)
        }
        composable(AppDestination.Explore.route) {
            FindProductsScreen(innerPadding = innerPadding)
        }


    }

}