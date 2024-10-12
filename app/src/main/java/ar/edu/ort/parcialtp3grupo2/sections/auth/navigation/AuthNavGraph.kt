package ar.edu.ort.parcialtp3grupo2.sections.auth.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.navigation.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import ar.edu.ort.parcialtp3grupo2.sections.auth.screens.Location
import ar.edu.ort.parcialtp3grupo2.sections.auth.screens.Login
import ar.edu.ort.parcialtp3grupo2.sections.auth.screens.SignUp
import ar.edu.ort.parcialtp3grupo2.sections.auth.screens.Onboarding
import ar.edu.ort.parcialtp3grupo2.sections.auth.screens.SplashScreen

@Composable
fun AuthNavGraph(authController: NavHostController, globalController:NavHostController, innerPadding: PaddingValues) {
    NavHost(navController = authController, startDestination = AuthDestination.Splash.route) {

        composable(AuthDestination.Splash.route) {
            SplashScreen(authController)
        }

        composable(AuthDestination.Login.route) {
            Login(innerPadding, authController, globalController)
        }
        composable(AuthDestination.Register.route) {
            SignUp(innerPadding, globalController, authController)
        }

        composable(AuthDestination.Onboarding.route){
            Onboarding(innerPadding, authController)
        }

        composable(AuthDestination.Location.route){
            Location(innerPadding, globalController)
        }

    }
}