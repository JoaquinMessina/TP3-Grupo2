package ar.edu.ort.parcialtp3grupo2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.compose.currentBackStackEntryAsState
import ar.edu.ort.parcialtp3grupo2.ui.theme.ParcialTP3Grupo2Theme
import ar.edu.ort.parcialtp3grupo2.ui.navigation.NavGraph
import androidx.navigation.compose.rememberNavController
import ar.edu.ort.parcialtp3grupo2.ui.navigation.AppDestination
import ar.edu.ort.parcialtp3grupo2.ui.navigation.BottomBar
import ar.edu.ort.parcialtp3grupo2.ui.components.MyTopAppBar as TopBar

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ParcialTP3Grupo2Theme {
                val navController = rememberNavController()
                val currentBackStackEntry by navController.currentBackStackEntryAsState()

                val nonTopBarRoutes = listOf(
                    AppDestination.Auth.route,
                )

                val nonBottomBarRoutes = listOf(
                    AppDestination.Auth.route
                )

                Scaffold(modifier = Modifier.fillMaxSize(), bottomBar = {
                    var destination = AppDestination.fromRoute(currentBackStackEntry?.destination?.route ?: "")

                    if(
                        nonBottomBarRoutes.contains(destination.route)
                    ) {
                        return@Scaffold
                    }

                    BottomBar (
                        currentRoute = currentBackStackEntry?.destination?.route ?: "",
                        onNavigate = { route ->
                            navController.navigate(route)
                        }
                    )
                }, topBar = {
                    var destination = AppDestination.fromRoute(currentBackStackEntry?.destination?.route ?: "")

                    if(
                        nonTopBarRoutes.contains(destination.route)
                    ) {
                        return@Scaffold
                    }

                    TopBar(
                        title = AppDestination.fromRoute(currentBackStackEntry?.destination?.route ?: "").label,
                        isArrowBack = false
                    )
                }) { innerPadding ->
                    NavGraph(navController = navController, innerPadding = innerPadding)
                }
            }
        }
    }
}