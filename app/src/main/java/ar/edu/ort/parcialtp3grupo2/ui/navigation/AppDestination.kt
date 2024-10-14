package ar.edu.ort.parcialtp3grupo2.ui.navigation

sealed class AppDestination(val route: String, val label: String) {
    object Shop : AppDestination("shop", "Shop")
    object Account : AppDestination("account", "Account")
    object Explore : AppDestination("explore", "Find Products")
    object Cart : AppDestination("cart", "Cart")
    object MyFavourites : AppDestination("myfavourites", "Favourites")
    object Auth : AppDestination("auth", "Auth")
    object Categories : AppDestination("categories", "Categories")

    companion object {
        fun fromRoute(route: String?): AppDestination =
            when (route) {
                Shop.route -> Shop
                Account.route -> Account
                Explore.route -> Explore
                Cart.route -> Cart
                MyFavourites.route -> MyFavourites
                Auth.route -> Auth
                Categories.route -> Categories
                null -> Shop  // Default screen
                else -> Shop
            }
    }
}