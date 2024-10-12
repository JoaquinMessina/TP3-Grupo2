package ar.edu.ort.parcialtp3grupo2.sections.auth.navigation

sealed class AuthDestination(val route: String, val label: String) {
    object Splash : AuthDestination("splash", "Splash")
    object Onboarding : AuthDestination("onboarding", "Onboarding")
    object Login : AuthDestination("login", "Login")
    object Register : AuthDestination("register", "Register")
    object Location : AuthDestination("location", "Location")

    companion object {
        fun fromRoute(route: String?): AuthDestination =
            when (route) {
                Splash.route -> Splash
                Onboarding.route -> Onboarding
                Login.route -> Login
                Register.route -> Register
                Location.route -> Location
                null -> Login //Default screen
                else -> Login
            }
    }
}