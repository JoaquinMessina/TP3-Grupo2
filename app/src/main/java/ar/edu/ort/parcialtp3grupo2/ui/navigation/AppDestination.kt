package ar.edu.ort.parcialtp3grupo2.ui.navigation

sealed class AppDestination(val route: String, val label: String) {
    object Shop : AppDestination("shop", "Shop")
    object Account : AppDestination("account", "Account")
    object FindProducts : AppDestination("find_products", "Find Products")

    companion object {
        fun fromRoute(route: String?): AppDestination =
            when (route) {
                Shop.route -> Shop
                Account.route -> Account
                null -> Shop  // Default screen
                else -> throw IllegalArgumentException("Route $route is not recognized.")
            }
    }
}