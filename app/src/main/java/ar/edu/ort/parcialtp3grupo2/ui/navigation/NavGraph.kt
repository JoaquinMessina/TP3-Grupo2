package ar.edu.ort.parcialtp3grupo2.ui.navigation
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import ar.edu.ort.parcialtp3grupo2.R
import androidx.navigation.compose.rememberNavController
import ar.edu.ort.parcialtp3grupo2.sections.auth.navigation.AuthNavGraph
import ar.edu.ort.parcialtp3grupo2.sections.auth.screens.Login
import ar.edu.ort.parcialtp3grupo2.sections.explore.screens.FindProductsScreen
import ar.edu.ort.parcialtp3grupo2.sections.home.account.screens.AccountScreen
import ar.edu.ort.parcialtp3grupo2.sections.home.data.Product
import ar.edu.ort.parcialtp3grupo2.sections.home.screens.MyCartScreen
import ar.edu.ort.parcialtp3grupo2.sections.home.screens.MyFavoriteScreen
import ar.edu.ort.parcialtp3grupo2.sections.home.screens.ShopScreen
import ar.edu.ort.parcialtp3grupo2.sections.home.screens.productDetail.ProductDetailScreen
import ar.edu.ort.parcialtp3grupo2.sections.orderAccepted.OrderAcceptedScreen


var apple = Product(
    id = 1,
    name = "Natural Red Apple",
    price = 4.99,
    amount = "1kg",
    image = R.drawable.apple,
    detail = "Apples are Nutritious. Apples May Be Good For Weight Loss. Apples May Be Good For Your Heart. As Part Of A Healtful And Varied Diet"
)

@Composable
fun NavGraph(navController: NavHostController, innerPadding: PaddingValues) {
    NavHost(navController = navController, startDestination = AppDestination.Shop.route) {
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
        composable(AppDestination.ProductDetail.route) {
            ProductDetailScreen(innerPadding = innerPadding, apple)
        }
        composable(AppDestination.OrderAccepted.route) {
            OrderAcceptedScreen(innerPadding = innerPadding)
        }
    }
}