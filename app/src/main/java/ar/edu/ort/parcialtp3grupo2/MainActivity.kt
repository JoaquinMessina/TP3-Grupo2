package ar.edu.ort.parcialtp3grupo2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import ar.edu.ort.parcialtp3grupo2.ui.theme.ParcialTP3Grupo2Theme
import ar.edu.ort.parcialtp3grupo2.ui.navigation.NavGraph
import androidx.navigation.compose.rememberNavController
import ar.edu.ort.parcialtp3grupo2.ui.navigation.AppDestination
import ar.edu.ort.parcialtp3grupo2.sections.home.components.MyTopAppBar as TopBar

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {

            ParcialTP3Grupo2Theme {
                val navController = rememberNavController()
                Scaffold(modifier = Modifier.fillMaxSize(), topBar = {
                    TopBar(
                        title = AppDestination.fromRoute(navController.currentDestination?.route).label,
                        isArrowBack = false
                    )
                }) { innerPadding ->
                    NavGraph(navController = navController, innerPadding = innerPadding)
                }
            }
        }
    }
}

