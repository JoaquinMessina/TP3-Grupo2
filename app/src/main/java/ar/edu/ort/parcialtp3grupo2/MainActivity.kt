package ar.edu.ort.parcialtp3grupo2

import android.os.Bundle
import android.view.View
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.navigation.compose.currentBackStackEntryAsState
import ar.edu.ort.parcialtp3grupo2.ui.theme.BrandTheme
import ar.edu.ort.parcialtp3grupo2.ui.navigation.NavGraph
import androidx.navigation.compose.rememberNavController
import ar.edu.ort.parcialtp3grupo2.ui.navigation.AppDestination
import ar.edu.ort.parcialtp3grupo2.ui.navigation.BottomBar
import ar.edu.ort.parcialtp3grupo2.ui.components.MyTopAppBar as TopBar

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        window.decorView.systemUiVisibility = (
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        or View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                        or View.SYSTEM_UI_FLAG_FULLSCREEN
                        or View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                )

        setContent {
            var isDarkTheme by remember { mutableStateOf(false) }

            BrandTheme(darkTheme = isDarkTheme) {
                val navController = rememberNavController()
                val currentBackStackEntry by navController.currentBackStackEntryAsState()

                val nonTopBarRoutes = listOf(
                    AppDestination.Auth.route,
                )

                val nonBottomBarRoutes = listOf(
                    AppDestination.Auth.route,
                    AppDestination.ProductDetail.route
                )

                val routesWithArrowBack = listOf(
                    "${AppDestination.ProductDetail.route}/{id}"
                )

                Scaffold(modifier = Modifier.fillMaxSize(), bottomBar = {
                    val destination = AppDestination.fromRoute(currentBackStackEntry?.destination?.route ?: "")

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
                    val destination = AppDestination.fromRoute(currentBackStackEntry?.destination?.route ?: "")

                    if(
                        nonTopBarRoutes.contains(destination.route)
                    ) {
                        return@Scaffold
                    }

                    TopBar(
                        title = AppDestination.fromRoute(currentBackStackEntry?.destination?.route ?: "").label,
                        isArrowBack = routesWithArrowBack.contains(currentBackStackEntry?.destination?.route),
                        navController = navController
                    )
                }) { innerPadding ->
                    NavGraph(navController = navController, innerPadding = innerPadding, isDarkTheme = isDarkTheme, onThemeChange = { isDarkTheme = it })
                }
            }
        }
    }
    override fun onWindowFocusChanged(hasFocus: Boolean) {
        super.onWindowFocusChanged(hasFocus)
        if (hasFocus) {
            window.decorView.systemUiVisibility = (
                    View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                            or View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                            or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                            or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                            or View.SYSTEM_UI_FLAG_FULLSCREEN
                            or View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                    )
        }
    }
}