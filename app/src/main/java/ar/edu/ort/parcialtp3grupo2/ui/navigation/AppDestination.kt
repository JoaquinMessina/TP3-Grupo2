package ar.edu.ort.parcialtp3grupo2.ui.navigation

sealed class AppDestination(val route: String, val label: String) {
    object Shop : AppDestination("shop", "Shop")
    object Account : AppDestination("account", "Account")
    object Explore : AppDestination("explore", "Find Products")
    object Cart : AppDestination("cart", "Cart")
    object Favourites : AppDestination("favourites", "Favourite")
    object ProductDetail: AppDestination("shop/productDetail", "ProductDetail")
    object OrderAccepted: AppDestination("orderAccepted", "orderAccepted")
    object Auth : AppDestination("auth", "Auth")
    object Categories : AppDestination("categories", "Categories")
    object Search : AppDestination("search", "Search")

    companion object {
        fun fromRoute(route: String?): AppDestination =
            when (route) {
                Shop.route -> Shop
                Account.route -> Account
                Explore.route -> Explore
                Cart.route -> Cart
                Favourites.route -> Favourites
                Auth.route -> Auth
                Search.route -> Search
                OrderAccepted.route -> OrderAccepted
                "${Categories.route}/{id}" -> Categories
                "${ProductDetail.route}/{id}" -> ProductDetail
                null -> Shop  // Default screen
                else -> Shop
            }
    }
}